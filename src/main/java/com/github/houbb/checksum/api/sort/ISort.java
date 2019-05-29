package com.github.houbb.checksum.api.sort;

import com.github.houbb.heaven.reflect.api.IField;

import java.util.List;

/**
 * 排序接口
 * @author binbin.hou
 * @since 0.0.1
 */
public interface ISort {

    /**
     * 字段排序
     * @param fieldList 字段列表
     */
    void sort(final List<IField> fieldList);

}
