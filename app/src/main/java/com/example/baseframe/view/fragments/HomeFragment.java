package com.example.baseframe.view.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseframe.R;
import com.example.baseframe.adapter.HomeRecycleViewAdapter;
import com.example.baseframe.model.HomeBean;
import com.example.baseframe.view.MainActivity;
import com.example.baseframe.view.custom.CustomLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

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
        initRecycleView(view);
        loadDataListener(view);
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


    //初始化RecycleView
    @SuppressLint("WrongConstant")
    private void initRecycleView(View view){
        List<HomeBean> list = new ArrayList<>();
        // TODO: 2019/9/9 0009  获取数据以及添加数据,Context的获取有问题，导致布局错乱
        for (int i = 0;i <10;i++){
            list.add(new HomeBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566380167579&di=b3e3762db1ed4b5417084c4ec13fe2b0&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201212%2F04%2F20121204154327_YyXJn.jpeg",
                    "这不是一条真标题","这也不是真内容"));
        }

        RecyclerView recyclerView = view.findViewById(R.id.home_rec);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.getContext()) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        HomeRecycleViewAdapter adapter = new HomeRecycleViewAdapter(MainActivity.getContext(),list);
        recyclerView.setAdapter(adapter);
    }


    //设置上拉和下拉监听
    private void loadDataListener(View view){
        SmartRefreshLayout refreshLayout = view.findViewById(R.id.smart_refresh);

        //下拉刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Log.d("HomePresenter", "onRefresh: --------");
                refreshLayout.finishRefresh(2000);
            }
        });

        //上拉加载更多
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Log.d("HomePresenter", "onLoadMore:-------- ");
                refreshLayout.finishLoadMore(2000);
            }
        });
    }

}
