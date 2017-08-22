package com.ylx.kotlineprojectdemo.mvp.model

import android.content.Context
import com.ylx.kotlineprojectdemo.mvp.contract.FindContract
import com.ylx.kotlineprojectdemo.mvp.model.bean.FindBean
import com.ylx.kotlineprojectdemo.mvp.model.bean.HomeBean
import com.ylx.kotlineprojectdemo.network.ApiService
import com.ylx.kotlineprojectdemo.network.RetrofitClient
import io.reactivex.Observable

/**
 * Created by lvruheng on 2017/7/6.
 */
class FindModel() {
    fun loadData(context: Context): Observable<MutableList<FindBean>>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindData()
    }
}