package com.example.baseframe.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.example.baseframe.R;
import com.example.baseframe.adapter.FixedFragmentPagerAdapter;
import com.example.baseframe.model.WeatherBean;
import com.example.baseframe.presenter.HomePresenter;
import com.example.baseframe.view.fragments.HomeFragment;
import com.example.baseframe.view.fragments.MineFragment;
import com.example.baseframe.view.fragments.NewsFragment;
import com.example.baseframe.view.fragments.ProgramFragment;
import com.example.baseframe.view.interfaceCollection.WeatherInfo;
import com.tencent.bugly.crashreport.CrashReport;



public class MainActivity extends BaseActivity implements WeatherInfo, ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager viewPager;
    private ImageView mHomeView,mNewsView,mProgramView,mMineView;
    private LinearLayout home_ll,news_ll,program_ll,mine_ll;
    private FixedFragmentPagerAdapter mPageAdapter;
    private static Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        viewPager = findViewById(R.id.vp);
        mHomeView = findViewById(R.id.home_iv);
        mNewsView = findViewById(R.id.news_iv);
        mProgramView = findViewById(R.id.program_iv);
        mMineView = findViewById(R.id.mine_iv);

        home_ll = findViewById(R.id.home_ll);
        news_ll = findViewById(R.id.news_ll);
        program_ll = findViewById(R.id.program_ll);
        mine_ll = findViewById(R.id.mine_ll);

        home_ll.setOnClickListener(this);
        news_ll.setOnClickListener(this);
        program_ll.setOnClickListener(this);
        mine_ll.setOnClickListener(this);


        initView();

        Log.d("HomePresenter", "onCreate: ");
        HomePresenter presenter = new HomePresenter(this,getLifecycleSubject());
        presenter.setLifeCycleListener();
        CrashReport.initCrashReport(getApplicationContext(),"a6b0fe70cd",false);
    }

    @Override
    public void getWeatherInfo(WeatherBean weatherBean) {
        Log.d("HomePresenter", "getWeatherInfo: --------"+weatherBean.getCity());

    }

    @Override
    public void getWeatherInfoFailed(int code, String msg) {

    }



    private void initView(){
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(3);
        mPageAdapter = new FixedFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mPageAdapter);

        mPageAdapter.setFragments(
                HomeFragment.create(),
                NewsFragment.create(),
                ProgramFragment.create(),
                MineFragment.create()
        );

        viewPager.setCurrentItem(0);
        onPageSelected(viewPager.getCurrentItem());
    }




    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mHomeView.setImageResource(R.mipmap.icon_home_page);
        mNewsView.setImageResource(R.mipmap.icon_news);
        mProgramView.setImageResource(R.mipmap.icon_program);
        mMineView.setImageResource(R.mipmap.icon_mine);
        switch (position){
            default:
                break;
            case 0:
                mHomeView.setImageResource(R.mipmap.icon_home_page_selected);
                break;
            case 1:
                mNewsView.setImageResource(R.mipmap.icon_news_selected);
                break;
            case 2:
                mProgramView.setImageResource(R.mipmap.icon_program_selected);
                break;
            case 3:
                mMineView.setImageResource(R.mipmap.icon_mine_selected);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
         switch (view.getId()){
            default:
                break;
             case R.id.home_ll:
                 viewPager.setCurrentItem(0);
                 break;
             case R.id.news_ll:
                 viewPager.setCurrentItem(1);
                 break;
             case R.id.program_ll:
                 viewPager.setCurrentItem(2);
                 break;
             case R.id.mine_ll:
                 viewPager.setCurrentItem(3);
                 break;
         }

    }

    //全局获取Context
    public static Context getContext(){
        return mContext;
    }
}
