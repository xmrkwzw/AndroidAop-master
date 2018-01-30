package com.xmwy.aop_master.aspectj;

import android.util.Log;

import com.xmwy.aop_master.annotation.CheckPermissionTrace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * desc：异步切片
 * author：haojie
 * date：2017/11/2
 */
@Aspect
public class CheckPermissionAspect {
    private final static String POINT_CUT= "execution(@com.xmwy.aop_master.annotation.CheckPermissionTrace * *(..))||" +
            "@annotation(com.xmwy.aop_master.annotation.CheckPermissionTrace)";


    @Pointcut(POINT_CUT)
    public void checkPermission() {
    }

    @Before("checkPermission()")
    public void check(JoinPoint joinPoint) throws Throwable {
        //从注解信息中获取声明的权限。
        // 当前执行的内容是那个类里面的
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 当前执行了什么样的功能
        CheckPermissionTrace checkLoginTrace = methodSignature.getMethod().getAnnotation(CheckPermissionTrace.class);
        //  String neededPermission = checkPermission.value();
        Log.d("CheckPermissionAspect", joinPoint.toShortString());
        Log.d("CheckPermissionAspect", "\tneeded permission is " + "--" + checkLoginTrace.value());
    }
}
