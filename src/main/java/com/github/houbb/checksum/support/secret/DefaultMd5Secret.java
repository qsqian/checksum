package com.github.houbb.checksum.support.secret;

import com.github.houbb.checksum.api.secret.ISecret;
import com.github.houbb.checksum.api.secret.ISecretContext;
import com.github.houbb.checksum.constant.ChecksumConst;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.secrect.Md5Util;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.util.List;

/**
 * 默认的加密算法
 *
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class DefaultMd5Secret implements ISecret {

    @Override
    public String secret(ISecretContext context) {
        final List<IField> fieldList = context.fields();
        if (CollectionUtil.isEmpty(fieldList)) {
            return ChecksumConst.DEFAULT_CHECK_SUM;
        }

        // 后期可以拓展：每个字段都有一个 convertToStr()
        //null 字段使用 "" 字符串
        StringBuilder stringBuilder = new StringBuilder();
        for(IField iField : fieldList) {
            final String fieldString = StringUtil.objectToString(iField.value(), StringUtil.EMPTY);
            stringBuilder.append(fieldString);
        }

        // 使用 md5
        return Md5Util.md5(stringBuilder.toString());
    }

}
