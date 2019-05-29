package com.github.houbb.checksum.support.cache;

import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.support.cache.ICache;
import com.github.houbb.heaven.support.cache.impl.DefaultFieldListCache;
import com.github.houbb.heaven.support.instance.impl.InstanceFactory;

import java.util.List;

/**
 * 缓存工具类
 * @author binbin.hou
 * @since 0.0.1
 */
public final class Caches {

    private Caches(){}

    /**
     * 验签字段列表分组
     */
    private static final String CHECK_SUM_FIELD_LIST_GROUP = "csflg";

    /**
     * 默认的字段缓存
     * @return 缓存
     */
    public static ICache<Class, List<IField>> defaultFieldListCache() {
        return InstanceFactory.getInstance()
                .singleton(DefaultFieldListCache.class, CHECK_SUM_FIELD_LIST_GROUP);
    }
}
