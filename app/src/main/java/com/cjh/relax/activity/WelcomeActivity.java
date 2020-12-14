package com.cjh.relax.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.cjh.relax.R;
import com.cjh.relax.base.ActivityController;
import com.cjh.relax.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    private Log log;
    private static final int runTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setShowStateBar(false);
        setShowTitleBar(false);
        setAllowScreenRotation(false);
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                Log.i("WelcomeActivity:","222222");
            }
        },runTime);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_welcome;
    }
}