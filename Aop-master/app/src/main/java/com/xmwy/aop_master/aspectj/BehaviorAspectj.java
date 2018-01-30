package com.xmwy.aop_master.aspectj;

import android.util.Log;

import com.xmwy.aop_master.annotation.BehaviorTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by Administrator on 2018/1/29.
 */

@Aspect
public class BehaviorAspectj {

    private static final String TAG ="BehaviorAspectj";
    private static final String POINT_CUT = "execution(@com.xmwy.aop_master.annotation.BehaviorTrace * *(..))";

    @Pointcut(POINT_CUT)
    public void methodAnnotatedWithBehaviorTrace() {
    }

    /*@before 在切入点前执行
    * @after 在切入点后执行
    * @Around 在切入点前后都要执行
    */
    @Around("methodAnnotatedWithBehaviorTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        // 当前执行的内容是那个类里面的
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        // 当前执行的是哪个方法
        String method = methodSignature.getName();
        // 当前执行了什么样的功能
        BehaviorTrace behaviorTrace = methodSignature.getMethod().getAnnotation(BehaviorTrace.class);
        String funName = behaviorTrace.value();

        long begin = System.currentTimeMillis();

        //表示方法中真正完成的功能
        Object object = joinPoint.proceed();

        long duration = System.currentTimeMillis() - begin;

        Log.d(TAG, String.format("执行类%s--执行方法%s--执行功能%s--执行时间%dms", className, method, funName, duration));

        return object;


    }
}
