package com.github.houbb.checksum.api.secret;

/**
 * 1. 为了简化结果，所有的签名都约定为字符串。
 * 2. 加密策略
 * @author binbin.hou
 * @since 0.0.1
 */
public interface ISecret {

    /**
     * 根据上下文生产加签名结果
     * 1. 如果没有参与加签的字段，则直接返回 null
     * @param context 上下文
     * @return 结果
     */
    String secret(final ISecretContext context);

}
