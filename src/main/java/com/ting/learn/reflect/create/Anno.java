package com.ting.learn.reflect.create;

import java.lang.annotation.*;

/**
 * 测试
 *
 * @author ting
 * @version 1.0
 * @date 2020/11/27
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anno {
    String value() default "list";
}
