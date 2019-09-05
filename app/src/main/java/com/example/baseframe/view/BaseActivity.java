package com.example.baseframe.view;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2019/9/5 0005
 */
public abstract class BaseActivity extends AppCompatActivity {
    PublishSubject<LifeCycleEvent> lifecycleSubject = PublishSubject.create();

    public PublishSubject<LifeCycleEvent> getLifecycleSubject(){
        return lifecycleSubject;
    }

    @Override
    protected void onDestroy() {
        lifecycleSubject.onNext(LifeCycleEvent.ON_DESTROY);
        super.onDestroy();
    }

}
