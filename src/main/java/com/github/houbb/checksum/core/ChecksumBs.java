package com.github.houbb.checksum.core;

import com.github.houbb.checksum.annotation.Checksum;
import com.github.houbb.checksum.api.checksum.IChecksum;
import com.github.houbb.checksum.api.checksum.IChecksumContext;
import com.github.houbb.checksum.api.secret.ISecret;
import com.github.houbb.checksum.api.sort.ISort;
import com.github.houbb.checksum.support.cache.Caches;
import com.github.houbb.checksum.support.checksum.DefaultChecksum;
import com.github.houbb.checksum.support.checksum.DefaultChecksumContext;
import com.github.houbb.checksum.support.secret.Secrets;
import com.github.houbb.checksum.support.sort.Sorts;
import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.support.cache.ICache;
import com.github.houbb.heaven.support.instance.impl.InstanceFactory;
import com.github.houbb.heaven.util.common.ArgUtil;

import java.util.List;

/**
 * 验签引导类
 * @author binbin.hou
 * @since 0.0.1
 */
@NotThreadSafe
public final class ChecksumBs {

    /**
     * 代处理的对象
     */
    private Object target;

    /**
     * 加签的实现
     */
    private ISecret secret = Secrets.defaultMd5Secret();

    /**
     * 排序的实现
     */
    private ISort sort = Sorts.nameAscSort();

    /**
     * 待参与加签字段列表缓存策略
     */
    private ICache<Class, List<IField>> cache = Caches.defaultFieldListCache();

    /**
     * 加签的处理类
     * 1. 暂时不开放这个类
     */
    private IChecksum checkSum = InstanceFactory.getInstance().singleton(DefaultChecksum.class);

    private ChecksumBs(){}

    /**
     * 创建引导类示例
     * @return 引导类新实例
     */
    public static ChecksumBs newInstance() {
        return new ChecksumBs();
    }

    /**
     * 创建引导类示例
     * @param target 待处理的对象
     * @return 引导类新实例
     */
    public static ChecksumBs newInstance(final Object target) {
        ArgUtil.notNull(target, "target");

        ChecksumBs checkSumBs = new ChecksumBs();
        checkSumBs.target(target);
        return checkSumBs;
    }

    /**
     * 指定目标对象
     * @param target 目标对象
     * @return this
     */
    public ChecksumBs target(Object target) {
        ArgUtil.notNull(target, "target");

        this.target = target;
        return this;
    }

    /**
     * 指定加签实现
     * @param secret 加签策略
     * @return this
     */
    public ChecksumBs secret(ISecret secret) {
        ArgUtil.notNull(secret, "secret");

        this.secret = secret;
        return this;
    }

    /**
     * 指定加签实现
     * @param sort 排序策略
     * @return this
     */
    public ChecksumBs sort(ISort sort) {
        ArgUtil.notNull(sort, "sort");

        this.sort = sort;
        return this;
    }

    /**
     * 设置待检查字段的缓存信息
     * @param cache 缓存实现
     * @return this
     */
    public ChecksumBs cache(ICache<Class, List<IField>> cache) {
        ArgUtil.notNull(cache, "checkFieldsCache");

        this.cache = cache;
        return this;
    }

    /**
     * 获取加签结果
     * 1. 不会将这个值放在对象中
     * @return 加签结果
     */
    public String checksum() {
        IChecksumContext context = DefaultChecksumContext
                .newInstance()
                .secret(secret)
                .target(target)
                .cache(cache)
                .sort(sort);

        return this.checkSum.checksum(context).checksum();
    }

    /**
     * 填充 checkSum 字段信息
     * @see Checksum 标识加签的字段注解
     */
    public void fill() {
        IChecksumContext context = DefaultChecksumContext
                .newInstance()
                .secret(secret)
                .target(target)
                .cache(cache)
                .sort(sort);

        this.checkSum.fill(context);
    }

}
