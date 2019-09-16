package com.example.baseframe.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.baseframe.R;
import com.example.baseframe.adapter.NewsFragmentPageAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/9 0009
 */
public class NewsFragment extends Fragment {
    private ViewPager mViewPager;
    private SlidingTabLayout mTabLayout;
    private List<Fragment> mFragments = new ArrayList<>();

    public static NewsFragment create(){return new NewsFragment();}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = view.findViewById(R.id.news_vp);
        mTabLayout = view.findViewById(R.id.sliding_tab);

        mFragments.add(new CommonFragments());
        mFragments.add(new CommonFragments());

        FragmentManager fragmentManager = getChildFragmentManager();
        NewsFragmentPageAdapter adapter = new NewsFragmentPageAdapter(fragmentManager,mFragments);
        mViewPager.setAdapter(adapter);

        String[] title = {"热门","自学"};
        mTabLayout.setViewPager(mViewPager,title);

    }
}
