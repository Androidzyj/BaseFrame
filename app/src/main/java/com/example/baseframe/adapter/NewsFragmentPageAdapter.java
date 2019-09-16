package com.example.baseframe.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.baseframe.view.fragments.CommonFragments;

import java.util.List;

/**
 * Created by Administrator on 2019/9/12 0012
 */
public class NewsFragmentPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public NewsFragmentPageAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
