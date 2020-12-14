package com.cjh.relax.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cjh.relax.R;
import com.cjh.relax.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAllowScreenRotation(false);
        setShowTitleBar(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
}