package com.xmwy.aop_master;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.xmwy.aop_master.annotation.BehaviorTrace;
import com.xmwy.aop_master.annotation.CheckLoginTrace;
import com.xmwy.aop_master.annotation.CheckPermissionTrace;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_yao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShake();
            }
        });
        findViewById(R.id.btn_touch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTouch();
            }
        });
        findViewById(R.id.btn_voice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVoice();
            }
        });
        findViewById(R.id.btn_vedio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVideo();
            }
        });


    }

    @BehaviorTrace("摇一摇")

    private void mShake() {
        SystemClock.sleep(new Random().nextInt(2000));

    }

    @CheckLoginTrace("touch")
    private void mTouch() {
        SystemClock.sleep(new Random().nextInt(2000));

    }

    @BehaviorTrace("语音消息")
    private void mVoice() {
        SystemClock.sleep(new Random().nextInt(2000));

    }

    @CheckPermissionTrace("android.permission.CAMERA")
    private void mVideo() {
        Log.i("CheckPermissionAspect","request permission successfully");
    }
}
