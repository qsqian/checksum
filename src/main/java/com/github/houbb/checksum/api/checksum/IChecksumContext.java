package com.github.houbb.checksum.api.checksum;

import com.github.houbb.checksum.api.secret.ISecret;
import com.github.houbb.checksum.api.sort.ISort;
import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.support.cache.ICache;

import java.util.List;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IChecksumContext {

    /**
     * 目标对象
     * @return 目标对象
     */
    Object target();

    /**
     * 排序实现
     * @return 排序实现
     */
    ISort sort();

    /**
     * 加密实现
     * @return 加密实现
     */
    ISecret secret();

    /**
     * 缓存实现
     * @return 缓存实现
     */
    ICache<Class, List<IField>> cache();

}
