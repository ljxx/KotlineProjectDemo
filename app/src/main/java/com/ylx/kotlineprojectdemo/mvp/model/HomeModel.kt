package com.ylx.kotlineprojectdemo.mvp.model

import android.content.Context
import com.ylx.kotlineprojectdemo.mvp.model.bean.HomeBean
import com.ylx.kotlineprojectdemo.network.ApiService
import com.ylx.kotlineprojectdemo.network.RetrofitClient
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by lvruheng on 2017/7/5.
 */
class HomeModel{
    fun loadData(context: Context,isFirst: Boolean,data: String?): Observable<HomeBean>? {
        val retrofitClient = RetrofitClient.getInstance(context,ApiService.BASE_URL)
        val apiService  = retrofitClient.create(ApiService::class.java)
        when(isFirst) {
            true -> return apiService?.getHomeData()

            false -> return apiService?.getHomeMoreData(data.toString(), "2")
        }
    }
}