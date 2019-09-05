package com.example.baseframe.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by Administrator on 2019/9/5 0005
 * 生命周期监听
 */
public enum  LifeCycleEvent{
    ON_CREATE,
    ON_START,
    ON_RESUME,
    ON_PAUSE,
    ON_STOP,
    ON_DESTROY
}
