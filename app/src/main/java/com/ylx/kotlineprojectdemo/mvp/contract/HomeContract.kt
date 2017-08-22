package com.ylx.kotlineprojectdemo.mvp.contract

import com.ylx.kotlineprojectdemo.base.BasePresenter
import com.ylx.kotlineprojectdemo.base.BaseView
import com.ylx.kotlineprojectdemo.mvp.model.bean.HomeBean

/**
 * Created by lvruheng on 2017/7/5.
 */
interface HomeContract{
    interface View : BaseView<Presenter> {
        fun setData(bean : HomeBean)
    }
    interface Presenter : BasePresenter {
        fun requestData()
    }
}