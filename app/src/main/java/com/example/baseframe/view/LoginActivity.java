package com.example.baseframe.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.baseframe.R;
import com.example.baseframe.presenter.commonUtils.CommonUtils;
import com.example.baseframe.view.custom.CustomVideoView;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private CustomVideoView videoView;
    private EditText mPhoneNumberInput;
    private EditText mVerifyCodeInput;
    private TextView mGetVerifyCode;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        mPhoneNumberInput = findViewById(R.id.user_count_input_et);
        mVerifyCodeInput = findViewById(R.id.user_password_input_et);
        mGetVerifyCode = findViewById(R.id.get_verify_code_tv);
        mLogin = findViewById(R.id.login_in_bt);

        mGetVerifyCode.setOnClickListener(this);
        mLogin.setOnClickListener(this);

        changeTextSize();

    }

    //VideoView初始化
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

    //改变EditText输入字体的大小
    private void changeTextSize(){
        CommonUtils utils = new CommonUtils(this);
        utils.setEditTextSize(mPhoneNumberInput,12,20);
        utils.setEditTextSize(mVerifyCodeInput,12,20);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.get_verify_code_tv:
                break;
            case R.id.login_in_bt:
                break;
        }

    }
}
