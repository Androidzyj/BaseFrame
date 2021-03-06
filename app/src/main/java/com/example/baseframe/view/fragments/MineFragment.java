package com.example.baseframe.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baseframe.R;
import com.example.baseframe.view.LoginActivity;
import com.example.baseframe.view.MainActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by Administrator on 2019/9/9 0009
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    public static MineFragment create(){return new MineFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    //初始化控件
    private void initView(View view){
        RelativeLayout user_info_rl = view.findViewById(R.id.user_info_rl);
        RelativeLayout my_coin_rl = view.findViewById(R.id.my_coin_rl);
        RelativeLayout my_collection_rl = view.findViewById(R.id.my_collection_rl);
        RelativeLayout read_later_rl = view.findViewById(R.id.read_later_rl);
        RelativeLayout open_program_rl = view.findViewById(R.id.open_program_rl);
        RelativeLayout about_author = view.findViewById(R.id.about_author_rl);
        RelativeLayout system_setting = view.findViewById(R.id.system_setting_rl);
        SmartRefreshLayout refreshLayout = view.findViewById(R.id.smart_refresh_mine);

        user_info_rl.setOnClickListener(this);
        my_coin_rl.setOnClickListener(this);
        my_collection_rl.setOnClickListener(this);
        read_later_rl.setOnClickListener(this);
        open_program_rl.setOnClickListener(this);
        about_author.setOnClickListener(this);
        system_setting.setOnClickListener(this);

        loadData(refreshLayout);
    }

    //初始化下拉监听
    private void loadData(SmartRefreshLayout refreshLayout){
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }
        });
    }
    // TODO: 2019/9/11 0011  第一次注册之后就将Token值保存下来

    // TODO: 2019/9/11 0011  通过保存token值，来登陆，且不需要保存密码，当token值过期后，重新输入密码即可


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            default:
                break;
            case R.id.user_info_rl:
                Intent intent = new Intent(MainActivity.getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MainActivity.getContext().startActivity(intent);
                break;
            case R.id.my_coin_rl:
                break;
            case R.id.my_collection_rl:
                break;
            case R.id.read_later_rl:
                break;
            case R.id.open_program_rl:
                break;
            case R.id.about_author_rl:
                break;
            case R.id.system_setting_rl:
                break;
        }

    }
}
