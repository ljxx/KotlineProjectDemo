package com.ylx.kotlineprojectdemo.mvp.presenter

import android.content.Context
import com.ylx.kotlineprojectdemo.mvp.contract.FindContract
import com.ylx.kotlineprojectdemo.mvp.contract.FindDetailContract
import com.ylx.kotlineprojectdemo.mvp.contract.HotContract
import com.ylx.kotlineprojectdemo.mvp.model.FindDetailModel
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
class FindDetailPresenter(context: Context, view: FindDetailContract.View) : FindDetailContract.Presenter {


    var mContext: Context? = null
    var mView: FindDetailContract.View? = null
    val mModel: FindDetailModel by lazy {
        FindDetailModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {

    }

    override fun requestData(categoryName: String, strategy: String) {
        val observable: Observable<HotBean>? = mContext?.let { mModel.loadData(mContext!!, categoryName, strategy) }
        observable?.applySchedulers()?.subscribe { bean: HotBean ->
            mView?.setData(bean)
        }
    }

    fun requesMoreData(start: Int, categoryName: String, strategy: String) {
        val observable: Observable<HotBean>? = mContext?.let { mModel.loadMoreData(mContext!!, start, categoryName, strategy) }
        observable?.applySchedulers()?.subscribe { bean: HotBean ->
            mView?.setData(bean)
        }
    }

}