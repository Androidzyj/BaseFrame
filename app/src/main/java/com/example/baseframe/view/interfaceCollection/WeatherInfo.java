package com.example.baseframe.view.interfaceCollection;

import com.example.baseframe.model.WeatherBean;

/**
 * Created by Administrator on 2019/9/6 0006
 */
public interface WeatherInfo {
    void getWeatherInfo(WeatherBean weatherBean);
    void getWeatherInfoFailed(int code,String msg);
}
