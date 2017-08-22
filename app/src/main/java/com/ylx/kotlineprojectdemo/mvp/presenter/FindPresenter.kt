package com.ylx.kotlineprojectdemo.mvp.presenter

import android.content.Context
import android.util.Log
import com.ylx.kotlineprojectdemo.mvp.contract.FindContract
import com.ylx.kotlineprojectdemo.mvp.contract.HomeContract
import com.ylx.kotlineprojectdemo.mvp.model.FindModel
import com.ylx.kotlineprojectdemo.mvp.model.HomeModel
import com.ylx.kotlineprojectdemo.mvp.model.bean.FindBean
import com.ylx.kotlineprojectdemo.mvp.model.bean.HomeBean
import com.ylx.kotlineprojectdemo.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by lvruheng on 2017/7/6.
 */
class FindPresenter(context: Context, view : FindContract.View) : FindContract.Presenter{
    var mContext : Context? = null
    var mView : FindContract.View? = null
    val mModel : FindModel by lazy {
        FindModel()
    }
    init {
        mView = view
        mContext = context
    }
    override fun start() {
        requestData()
    }

    override fun requestData() {
        val observable : Observable<MutableList<FindBean>>? = mContext?.let { mModel.loadData(mContext!!) }
        observable?.applySchedulers()?.subscribe { beans : MutableList<FindBean> ->
            mView?.setData(beans)
        }
    }



}