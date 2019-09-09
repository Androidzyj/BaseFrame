package com.example.baseframe.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2019/9/9 0009
 */
public class FixedFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragments = null;
    private String[] mTitles = null;

    //类型后面接三个点是什么意思
    public void setFragments(Fragment... mFragments) {
        this.mFragments = mFragments;
        notifyDataSetChanged();
    }

    public void setTitles(String[] mTitles) {
        this.mTitles = mTitles;
    }

    public FixedFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0:mFragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null && mTitles.length == getCount()){
           return mTitles[position];
        }

        Fragment fragment = mFragments[position];

        if (fragment instanceof  PageTitle){
            PageTitle pageTitle = (PageTitle) fragment;
            return pageTitle.getPageTitle();
        }
        return "";
    }

    public interface PageTitle {
        CharSequence getPageTitle();
    }
}
