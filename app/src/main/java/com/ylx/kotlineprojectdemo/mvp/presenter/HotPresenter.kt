package com.ylx.kotlineprojectdemo.mvp.presenter

import android.content.Context
import com.ylx.kotlineprojectdemo.mvp.contract.FindContract
import com.ylx.kotlineprojectdemo.mvp.contract.HotContract
import com.ylx.kotlineprojectdemo.mvp.model.FindModel
import com.ylx.kotlineprojectdemo.mvp.model.HotModel
import com.ylx.kotlineprojectdemo.mvp.model.bean.FindBean
import com.ylx.kotlineprojectdemo.mvp.model.bean.HotBean
import com.ylx.kotlineprojectdemo.utils.applySchedulers
import io.reactivex.BackpressureOverflowStrategy
import io.reactivex.Observable

/**
 * Created by lvruheng on 2017/7/7.
 */
class HotPresenter(context: Context,view: HotContract.View) : HotContract.Presenter{


    var mContext : Context? = null
    var mView : HotContract.View? = null
    val mModel : HotModel by lazy {
        HotModel()
    }
    init {
        mView = view
        mContext = context
    }
    override fun start() {

    }
    override fun requestData(strategy: String) {
        val observable : Observable<HotBean>? = mContext?.let { mModel.loadData(mContext!!,strategy) }
        observable?.applySchedulers()?.subscribe { bean : HotBean ->
            mView?.setData(bean)
        }
    }

}