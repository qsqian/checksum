package com.github.houbb.checksum.support.sort;

import com.github.houbb.checksum.api.sort.ISort;
import com.github.houbb.heaven.support.instance.impl.InstanceFactory;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class Sorts {

    private Sorts(){}

    /**
     * 字段名称升序排列
     * @return 字段名称升序排列
     */
    public static ISort nameAscSort() {
        return InstanceFactory.getInstance().singleton(NameAscSort.class);
    }

}
