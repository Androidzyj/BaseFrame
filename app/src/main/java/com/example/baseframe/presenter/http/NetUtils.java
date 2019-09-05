package com.example.baseframe.presenter.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2019/9/4 0004
 * 判断网络状态
 */
public class NetUtils {
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
             .getSystemService(Context.CONNECTIVITY_SERVICE);
             NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                 return mNetworkInfo.isAvailable();
                 }
             }
         return false;
        }
}
