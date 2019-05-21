package com.github.houbb.checksum.annotation;

/**
 * 用来指定验签的结果字段
 * 为了处理的便利性。约定如下：
 * 1. 如果没有指定这个值，则不进行设置
 * 2. 如果设置了多个这个注解，则只以找到的第一个为准。
 * @author binbin.hou
 * @since 1.0.0
 */
public @interface CheckSum {
}
