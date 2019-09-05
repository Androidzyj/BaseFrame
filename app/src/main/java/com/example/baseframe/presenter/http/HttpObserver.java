package com.example.baseframe.presenter.http;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2019/9/4 0004
 * observer封装
 */
public abstract class HttpObserver<T> implements Observer<HttpResult<T>> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable throwable) {
        if (throwable instanceof  Exception){
            onError(ThrowableHandler.handleThrowable(throwable));
        }else {
            onError(new HttpThrowable(HttpThrowable.UNKNOWN,"未知错误",throwable));
        }

    }

    @Override
    public void onNext(HttpResult<T> httpResult) {
        onNext(httpResult.getMessage(),httpResult.getSubjects());
        Log.d("HomePresenter", "onNext: --------object"+httpResult.getSubjects());

    }

    //具体实现下面两个方法，便可从中得到更直接详细的信息
    public abstract void onNext(String code, T t);
    public abstract void onError(HttpThrowable httpThrowable);
}
