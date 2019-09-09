package com.example.baseframe.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baseframe.R;
import com.example.baseframe.view.custom.CustomLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/9/9 0009
 */
public class HomeFragment extends Fragment {

    public static  HomeFragment create(){return new HomeFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBanner(view);
    }

    //初始化Banner图
    private void initBanner(View view){
        Banner mTopBanner = view.findViewById(R.id.top_banner);
        ArrayList<String> topBannerList = new ArrayList<>();
        topBannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566380167579&di=b3e3762db1ed4b5417084c4ec13fe2b0&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201212%2F04%2F20121204154327_YyXJn.jpeg");
        topBannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566380167579&di=b3e3762db1ed4b5417084c4ec13fe2b0&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201212%2F04%2F20121204154327_YyXJn.jpeg");
        topBannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566380167579&di=b3e3762db1ed4b5417084c4ec13fe2b0&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201212%2F04%2F20121204154327_YyXJn.jpeg");
        topBannerList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566380064392&di=d9af96c2b67cbb128535568a592d5176&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201212%2F04%2F20121204154327_YyXJn.jpeg");

        mTopBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mTopBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mTopBanner.setImageLoader(new CustomLoader());
        mTopBanner.setBannerAnimation(Transformer.Default);
        mTopBanner.setDelayTime(3000);
        mTopBanner.isAutoPlay(true);
        mTopBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mTopBanner.setImages(topBannerList).start();

        setBannerListener(mTopBanner);

    }

    //设置轮播图监听器
    private void setBannerListener(Banner banner){
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
    }
}
