package com.example.baseframe.view;

import android.os.Bundle;
import android.util.Log;
import com.example.baseframe.R;
import com.example.baseframe.presenter.HomePresenter;
import com.tencent.bugly.crashreport.CrashReport;



public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("HomePresenter", "onCreate: ");
        HomePresenter presenter = new HomePresenter(getApplicationContext(),getLifecycleSubject());
        presenter.setLifeCycleListener();
        CrashReport.initCrashReport(getApplicationContext(),"a6b0fe70cd",false);
    }
}
