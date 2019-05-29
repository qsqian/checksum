package com.github.houbb.checksum.annotation;

import java.lang.annotation.*;

/**
 * 参与验签的字段
 * 1. 只对设置了这个注解的字段进行处理。
 * 2. 只处理第一层，如果想递归处理。参见 {@link CheckEntry}
 * @author binbin.hou
 * @since 0.0.1
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckField {
}
