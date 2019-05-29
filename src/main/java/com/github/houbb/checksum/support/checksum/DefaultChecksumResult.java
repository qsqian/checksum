package com.github.houbb.checksum.support.checksum;

import com.github.houbb.checksum.api.checksum.IChecksumResult;
import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.heaven.reflect.api.IField;

import java.util.List;

/**
 * 默认的加签结果信息
 * @author binbin.hou
 * @since 0.0.1
 */
@NotThreadSafe
public class DefaultChecksumResult implements IChecksumResult {

    /**
     * 加签结果
     */
    private String checksum;

    /**
     * 目标对象
     */
    private Object target;

    /**
     * 字段信息
     */
    private List<IField> fields;

    public static DefaultChecksumResult newInstance() {
        return new DefaultChecksumResult();
    }

    @Override
    public String checksum() {
        return checksum;
    }

    public DefaultChecksumResult checksum(String checksum) {
        this.checksum = checksum;
        return this;
    }

    @Override
    public Object target() {
        return target;
    }

    public DefaultChecksumResult target(Object target) {
        this.target = target;
        return this;
    }

    @Override
    public List<IField> fields() {
        return fields;
    }

    public DefaultChecksumResult fields(List<IField> fields) {
        this.fields = fields;
        return this;
    }

}
