package com.ylx.kotlineprojectdemo.mvp.presenter

import android.content.Context
import com.ylx.kotlineprojectdemo.mvp.contract.FindContract
import com.ylx.kotlineprojectdemo.mvp.contract.HotContract
import com.ylx.kotlineprojectdemo.mvp.contract.ResultContract
import com.ylx.kotlineprojectdemo.mvp.model.FindModel
import com.ylx.kotlineprojectdemo.mvp.model.HotModel
import com.ylx.kotlineprojectdemo.mvp.model.ResultModel
import com.ylx.kotlineprojectdemo.mvp.model.bean.FindBean
import com.ylx.kotlineprojectdemo.mvp.model.bean.HotBean
import com.ylx.kotlineprojectdemo.utils.applySchedulers
import io.reactivex.BackpressureOverflowStrategy
import io.reactivex.Observable

/**
 * Created by lvruheng on 2017/7/7.
 */
class ResultPresenter(context: Context, view: ResultContract.View) : ResultContract.Presenter {


    var mContext: Context? = null
    var mView: ResultContract.View? = null
    val mModel: ResultModel by lazy {
        ResultModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {

    }

    override fun requestData(query: String, start: Int) {
        val observable: Observable<HotBean>? = mContext?.let { mModel.loadData(mContext!!, query, start) }
        observable?.applySchedulers()?.subscribe { bean: HotBean ->
            mView?.setData(bean)
        }
    }

}