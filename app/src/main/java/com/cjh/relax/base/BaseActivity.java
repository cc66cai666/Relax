package com.cjh.relax.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Spliterators;

public abstract class BaseActivity extends AppCompatActivity {

    //获取TAG
    public final String TAG = this.getClass().getSimpleName();
    //设置是否显示标题栏
    private boolean isShowTitleBar = true;
    //是否显示状态栏
    private boolean isShowStateBar = true;
    //是否将状态栏透明化
    private boolean isTransparencyStateBar = true;
    //是否支持旋转屏幕
    private boolean isAllowScreenRotation = true;
    //设置Toast
    private Toast toast;
    //获取当前上下文
    public Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);

        context = this;

        //不显示标题栏
        if (!isShowTitleBar){
            getSupportActionBar().hide();
        }

        //显示状态栏
        if (isShowStateBar){
            //将状态栏透明化
            if (isTransparencyStateBar){
                //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//半透明
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    View decorView = getWindow().getDecorView();
                    //View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE 两个同时使用表示让主体覆盖状态栏
                    int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);

                }
            }
        }else {
            //不显示状态栏(全屏)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }



        //初始化布局
        setContentView(initLayout());

        //初始化控件
        initView();

        //初始化数据
        initData();

        if (!isAllowScreenRotation){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }


    }


    /**
     * 设置是否显示标题栏
     * @param isShowTitle
     */
    public void setShowTitleBar(boolean isShowTitle){

        this.isShowTitleBar = isShowTitle;

    }

    /**
     * 设置是否显示状态栏
     * @param isShowState
     */
    public void setShowStateBar(boolean isShowState){

        this.isShowStateBar = isShowState;

    }

    /**
     * 设置是否将状态栏透明化
     * @param isTransparencyState
     */
    public void setTransparencyStateBar(boolean isTransparencyState){

        this.isTransparencyStateBar = isTransparencyState;

    }

    /**
     * 设置是否允许屏幕旋转
     * @param isAllowScreenRotation
     */
    public void setAllowScreenRotation(boolean isAllowScreenRotation){

        this.isAllowScreenRotation = isAllowScreenRotation;

    }

    /**
     * 显示键盘
     */
    public void setShowKeyboard(){

        InputMethodManager imm = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);

        if (getCurrentFocus() != null && imm != null){

            imm.showSoftInputFromInputMethod(getCurrentFocus().getWindowToken(),0);

        }

    }

    public void setHideKeyboard(){

        InputMethodManager imm = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);

        if (getCurrentFocus() != null && imm != null){

            imm.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(),0);

        }

    }


    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化视图布局
     * @return
     */
    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }
}
