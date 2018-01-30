package com.xmwy.aop_master.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * desc：检测登录
 * author：wzw
 * date：2017/10/29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface CheckLoginTrace {
    String value();
}
