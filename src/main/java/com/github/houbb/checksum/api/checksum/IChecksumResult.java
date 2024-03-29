package com.github.houbb.checksum.api.checksum;

import com.github.houbb.heaven.reflect.api.IField;

import java.util.List;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IChecksumResult {

    /**
     * 返回验签结果
     * @return 返回验签结果
     */
    String checksum();

    /**
     * 目标对象
     * @return 目标对象
     */
    Object target();

    /**
     * 字段信息列表
     * @return 字段信息列表
     */
    List<IField> fields();

}
