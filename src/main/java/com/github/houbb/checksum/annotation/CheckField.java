package com.github.houbb.checksum.annotation;

import java.lang.annotation.*;

/**
 * 参与验签的字段
 * @author binbin.hou
 * @since 0.0.1
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckField {

    /**
     * 是否需要当前字段
     * @return 默认为 false
     */
    boolean require() default false;

}
