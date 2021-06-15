package com.mingh.learn.reflect.annotation;

import java.lang.annotation.*;

/**
 * @ClassName LogString
 * @Author Hai.Ming
 * @Date 2021/6/15 16:44
 * @Description 自定义的日志注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface LogString {

    String params() default "this method has no params";

    String result() default "this method has no return value";
}
