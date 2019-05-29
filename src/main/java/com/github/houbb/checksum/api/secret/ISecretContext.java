package com.github.houbb.checksum.api.secret;

import com.github.houbb.heaven.reflect.api.IField;

import java.util.List;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public interface ISecretContext {

    /**
     * 目标对象
     * @return 对象
     */
    Object target();

    /**
     * 字段信息列表
     * 1. 每个字段中是包含值的。
     * @return 字段信息列表
     */
    List<IField> fields();

}
