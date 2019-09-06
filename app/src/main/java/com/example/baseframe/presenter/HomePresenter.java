package com.example.baseframe.presenter;

import android.content.Context;
import android.util.Log;
import com.example.baseframe.model.WeatherBean;
import com.example.baseframe.presenter.http.HttpObserver;
import com.example.baseframe.presenter.http.HttpThrowable;
import com.example.baseframe.presenter.http.RetrofitUtils;
import com.example.baseframe.view.LifeCycleEvent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2019/9/5 0005
 */
public class HomePresenter extends BasePresenter {
    public static final String TAG = "HomePresenter";
    private Context context;
    private PublishSubject<LifeCycleEvent> lifecycleSubject;
    private RetrofitUtils retrofitUtils;

    public HomePresenter(Context context, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        this.context = context;
        this.lifecycleSubject = lifecycleSubject;
    }

    public void setLifeCycleListener(){
        Log.d(TAG, "setLifeCycleListener: ----------111111");
        retrofitUtils = new RetrofitUtils(context);

        //得到负责网络请求的Observable
        Observable<com.example.baseframe.presenter.http.HttpResult<WeatherBean>> observable = retrofitUtils.getApiService().getWeatherInfo("成都");

        //得到负责在页面销毁时发射事件的Observable
        Observable<LifeCycleEvent> observableLife = lifecycleSubject.filter(new Predicate<LifeCycleEvent>() {
            @Override
            public boolean test(LifeCycleEvent lifeCycleEvent) throws Exception {
                return lifeCycleEvent.equals(LifeCycleEvent.ON_DESTROY);
            }
        }).take(1);

        //创建Observer对象,得到回调方法
        HttpObserver<WeatherBean> observer = new HttpObserver<WeatherBean>() {
            @Override
            public void onNext(String code, WeatherBean weatherBean) {
                Log.d(TAG, "onNext: ---------success "+code);
                Log.d(TAG, "onNext: ---------"+weatherBean.getCity());

            }

            @Override
            public void onError(HttpThrowable httpThrowable) {
                Log.d(TAG, "onError: ---------error!");

            }
        };

        observable.takeUntil(observableLife)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
