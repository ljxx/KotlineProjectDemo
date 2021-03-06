package com.ylx.kotlineprojectdemo.mvp.model

import android.content.Context
import android.util.Log
import com.ylx.kotlineprojectdemo.mvp.model.bean.HomeBean
import com.ylx.kotlineprojectdemo.mvp.model.bean.HotBean
import com.ylx.kotlineprojectdemo.network.ApiService
import com.ylx.kotlineprojectdemo.network.RetrofitClient
import io.reactivex.Observable
import java.net.URLEncoder

/**
 * Created by lvruheng on 2017/7/7.
 */
class FindDetailModel {
    fun loadData(context: Context, categoryName: String, strategy: String?): Observable<HotBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindDetailData(categoryName, strategy!!, "26868b32e808498db32fd51fb422d00175e179df", 83)
    }
    fun loadMoreData(context: Context,start : Int, categoryName: String, strategy: String?): Observable<HotBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindDetailMoreData(start,10,categoryName, strategy!!)
    }
}