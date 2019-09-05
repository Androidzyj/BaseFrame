package com.example.baseframe.base;

import android.content.Context;

import com.example.baseframe.base.MvpView;

/**
 * Created by Administrator on 2019/9/4 0004
 */
public abstract class MvpPresenter <V extends MvpView>{
    protected Context context;
    private V baseView;

    public void onCreate(V baseView){
        this.baseView = baseView;
        context = baseView.getContext();
    }

    public void onDestroy(){
        baseView = null;
        context = null;
    }

    public V getBaseView(){return baseView;}

    public boolean isAttachView(){return baseView != null;}

    public Context getContext(){return  context;}
}
