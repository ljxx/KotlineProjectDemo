package com.ylx.kotlineprojectdemo.mvp.contract

import com.ylx.kotlineprojectdemo.base.BasePresenter
import com.ylx.kotlineprojectdemo.base.BaseView
import com.ylx.kotlineprojectdemo.mvp.model.bean.FindBean
import com.ylx.kotlineprojectdemo.mvp.model.bean.HomeBean

/**
 * Created by lvruheng on 2017/7/6.
 */
interface FindContract{
    interface View : BaseView<Presenter> {
        fun setData(beans : MutableList<FindBean>)
    }
    interface Presenter : BasePresenter {
        fun requestData()
    }
}