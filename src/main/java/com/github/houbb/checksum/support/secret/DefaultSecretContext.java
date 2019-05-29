package com.github.houbb.checksum.support.secret;

import com.github.houbb.checksum.api.secret.ISecretContext;
import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.heaven.reflect.api.IField;

import java.util.List;

/**
 * 默认的加签上下文
 * @author binbin.hou
 * @since 0.0.1
 */
@NotThreadSafe
public class DefaultSecretContext implements ISecretContext {

    /**
     * 目标对象
     */
    private Object target;

    /**
     * 字段信息
     */
    private List<IField> fields;

    /**
     * 创建加密上下文新的实例
     * @return 上下文新的实例
     */
    public static DefaultSecretContext newInstance() {
        return new DefaultSecretContext();
    }

    @Override
    public Object target() {
        return target;
    }

    public DefaultSecretContext target(Object target) {
        this.target = target;
        return this;
    }

    @Override
    public List<IField> fields() {
        return fields;
    }

    public DefaultSecretContext fields(List<IField> fields) {
        this.fields = fields;
        return this;
    }

}
