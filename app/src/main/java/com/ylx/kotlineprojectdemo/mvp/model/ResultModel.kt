package com.ylx.kotlineprojectdemo.mvp.model

import android.content.Context
import com.ylx.kotlineprojectdemo.mvp.model.bean.HotBean
import com.ylx.kotlineprojectdemo.network.ApiService
import com.ylx.kotlineprojectdemo.network.RetrofitClient
import io.reactivex.Observable

/**
 * Created by lvruheng on 2017/7/11.
 */
class ResultModel {
    fun loadData(context: Context, query: String, start: Int): Observable<HotBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getSearchData(10, query, start)

    }
}
