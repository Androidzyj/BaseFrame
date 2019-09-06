package com.example.baseframe.view;

import android.os.Bundle;
import android.util.Log;
import com.example.baseframe.R;
import com.example.baseframe.model.WeatherBean;
import com.example.baseframe.presenter.HomePresenter;
import com.example.baseframe.view.interfaceCollection.WeatherInfo;
import com.tencent.bugly.crashreport.CrashReport;



public class MainActivity extends BaseActivity implements WeatherInfo {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
