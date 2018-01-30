package com.xmwy.aop_master.aspectj;

import android.content.Intent;

import com.xmwy.aop_master.App;
import com.xmwy.aop_master.LoginActivity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * desc：检测登录切片
 * author：haojie
 * date：2017/10/29
 */
@Aspect
public class CheckLoginAspect {
    private final static String POINT_CUT_ASPECT = "execution(@com.xmwy.aop_master.annotation.CheckLoginTrace * *(..))";

    @Pointcut("execution(@com.xmwy.aop_master.annotation.CheckLoginTrace * *(..))")
    public void methodAnnotated() {
    }


    @Before("methodAnnotated()")
    public void aroundJoinPoint(JoinPoint joinPoint) throws Throwable {

        boolean notLogin = true;

        if (notLogin){
            Intent t = new Intent(App.getAppContext(), LoginActivity.class);
            App.getAppContext().startActivity(t);
        }

    }
}

