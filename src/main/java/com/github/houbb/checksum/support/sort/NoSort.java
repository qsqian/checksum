package com.github.houbb.checksum.support.sort;

import com.github.houbb.checksum.api.sort.ISort;
import com.github.houbb.heaven.reflect.api.IField;

import java.util.List;

/**
 * 不进行排序操作
 * @author binbin.hou
 * @since 0.0.1
 */
public class NoSort implements ISort {

    @Override
    public void sort(List<IField> fieldList) {

    }

}
