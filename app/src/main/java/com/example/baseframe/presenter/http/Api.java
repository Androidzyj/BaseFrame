package com.example.baseframe.presenter.http;

import com.example.baseframe.model.WeatherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2019/9/4 0004
 */
public interface Api {
    //查询单个
    @GET("weatherApi")
    Observable<HttpResult<WeatherBean>>getWeatherInfo(@Query("city")String city);


}
