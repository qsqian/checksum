package com.github.houbb.checksum.support.sort;

import com.github.houbb.checksum.api.sort.ISort;
import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.api.IField;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 字段名称升序排列
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public class NameAscSort implements ISort {

    @Override
    public void sort(List<IField> fieldList) {
        Collections.sort(fieldList, new Comparator<IField>() {
            @Override
            public int compare(IField o1, IField o2) {
                return o1.name().compareTo(o2.name());
            }
        });
    }
    
}
