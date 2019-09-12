package com.example.baseframe.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.example.baseframe.R;
import com.example.baseframe.view.custom.CustomVideoView;

public class LoginActivity extends BaseActivity {
    private CustomVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    //初始化
    private void initView(){
        videoView = findViewById(R.id.video_view);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.login_background_2));
        videoView.start();


        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //暂时设置为静音
                mediaPlayer.setVolume(0f,0f);
                //恢复
               /* mediaPlayer.setVolume(1f,1f);*/

                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
                        if (i == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                            videoView.setBackgroundColor(Color.TRANSPARENT);
                            return true;
                    }
                });

            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });
    }



}
