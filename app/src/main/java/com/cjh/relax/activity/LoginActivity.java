package com.cjh.relax.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.cjh.relax.R;
import com.cjh.relax.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setAllowScreenRotation(false);
        setShowTitleBar(false);
        //setTransparencyStateBar(true);
        setShowStateBar(false);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        videoView = findViewById(R.id.viewVideo);
        initViewVideo();

    }

    private void initViewVideo() {

        //获取视频文件
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.chuyin));
        //开始播放
        videoView.start();
        //当视频播放完毕后继续重新播放
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
        //错误监听
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return true;//防止错误弹窗
            }
        });

    }

    @Override
    protected void onRestart() {
        initViewVideo();//从其他页面返回该登录页面时重新加载视频
        super.onRestart();
    }

    @Override
    protected void onStop() {
        videoView.stopPlayback();
        super.onStop();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }
}