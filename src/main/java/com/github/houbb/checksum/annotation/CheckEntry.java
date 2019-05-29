package com.github.houbb.checksum.annotation;

import java.lang.annotation.*;

/**
 * 参与递归验签的对象
 * 1. 可以放在 集合/列表/对象 上。
 * @author binbin.hou
 * @since 0.0.1
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckEntry {
}
