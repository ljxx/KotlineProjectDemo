package com.ylx.kotlineprojectdemo.mvp.contract

import com.ylx.kotlineprojectdemo.base.BasePresenter
import com.ylx.kotlineprojectdemo.base.BaseView
import com.ylx.kotlineprojectdemo.mvp.model.bean.HomeBean
import com.ylx.kotlineprojectdemo.mvp.model.bean.HotBean

/**
 * Created by lvruheng on 2017/7/5.
 */
interface FindDetailContract {
    interface View : BaseView<Presenter> {
        fun setData(bean: HotBean)
    }

    interface Presenter : BasePresenter {
        fun requestData(categoryName: String, strategy: String)
    }
}