package com.github.houbb.checksum.support.checksum;

import com.github.houbb.checksum.annotation.Checksum;
import com.github.houbb.checksum.api.checksum.IChecksum;
import com.github.houbb.checksum.api.checksum.IChecksumContext;
import com.github.houbb.checksum.api.checksum.IChecksumResult;
import com.github.houbb.checksum.api.secret.ISecret;
import com.github.houbb.checksum.api.secret.ISecretContext;
import com.github.houbb.checksum.api.sort.ISort;
import com.github.houbb.checksum.support.secret.DefaultSecretContext;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.reflect.exception.ReflectRumtionException;
import com.github.houbb.heaven.reflect.util.Classes;
import com.github.houbb.heaven.support.cache.ICache;
import com.github.houbb.heaven.support.filter.IFilter;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.heaven.util.util.Optional;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 验签的默认实现
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class DefaultChecksum implements IChecksum {

    @Override
    public IChecksumResult checksum(IChecksumContext context) {
        final Object target = context.target();
        final ISecret secret = context.secret();
        final ISort sort = context.sort();
        final ICache<Class, List<IField>> cache = context.cache();

        // 获取字段信息
        final Class clazz = target.getClass();
        List<IField> fieldList = cache.get(clazz);
        if(CollectionUtil.isEmpty(fieldList)) {
            fieldList = Classes.getFields(clazz);
            cache.set(clazz, fieldList);
        }

        // 执行一次过滤，只有 @CheckField 对应的字段才会被传入
        List<IField> checkFieldList = CollectionUtil.filterList(fieldList, new IFilter<IField>() {
            @Override
            public boolean filter(IField iField) {
                final Field field = iField.field();
                return field.isAnnotationPresent(Checksum.class);
            }
        });
        // 执行排序
        if(CollectionUtil.isNotEmpty(checkFieldList)) {
            sort.sort(checkFieldList);
        }

        // 执行值初始化
        Classes.initFieldValue(target, fieldList);

        // 执行加签
        ISecretContext secretContext = DefaultSecretContext
                .newInstance()
                .target(target)
                .fields(checkFieldList);
        final String checksum = secret.secret(secretContext);

        return DefaultChecksumResult
                .newInstance()
                .checksum(checksum)
                .fields(fieldList)
                .target(target);
    }

    @Override
    public void fill(IChecksumContext context) {
        final IChecksumResult checkSumResult = this.checksum(context);

        final String checksum = checkSumResult.checksum();
        final List<IField> fieldList = checkSumResult.fields();

        //这里也可以添加缓存。
        Optional<Field> fieldOptional = getCheckSumFieldOpt(fieldList);

        if(fieldOptional.isPresent()) {
            Field field = fieldOptional.get();
            try {
                field.set(context.target(), checksum);
            } catch (IllegalAccessException e) {
                throw new ReflectRumtionException(e);
            }
        }
    }

    /**
     * 获取验签字段
     * @param fieldList 字段列表信息
     * @return field optional
     */
    private Optional<Field> getCheckSumFieldOpt(List<IField> fieldList) {
        for(IField field : fieldList) {
            Optional<Annotation> annotationOpt = field.annotationOpt(Checksum.class);
            if(annotationOpt.isPresent()) {
                return Optional.ofNullable(field.field());
            }
        }
        return Optional.empty();
    }

}
