package com.ylx.kotlineprojectdemo.ui.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.AdapterView
import com.ylx.kotlineprojectdemo.R
import com.ylx.kotlineprojectdemo.adapter.FindAdapter
import com.ylx.kotlineprojectdemo.mvp.contract.FindContract
import com.ylx.kotlineprojectdemo.mvp.model.bean.FindBean
import com.ylx.kotlineprojectdemo.mvp.presenter.FindPresenter
import com.ylx.kotlineprojectdemo.ui.FindDetailActivity
import kotlinx.android.synthetic.main.find_fragment.*

/**
 * Created by lvruheng on 2017/7/4.
 */
class FindFragment : BaseFragment(),FindContract.View {
    var mPresenter: FindPresenter? = null
    var mAdapter : FindAdapter? = null
    var mList : MutableList<FindBean>? = null
    override fun setData(beans: MutableList<FindBean>) {
        mAdapter?.mList = beans
        mList = beans
        mAdapter?.notifyDataSetChanged()
    }

    override fun getLayoutResources(): Int {
        return R.layout.find_fragment
    }

    override fun initView() {
        mPresenter = FindPresenter(context,this)
        mPresenter?.start()
        mAdapter = FindAdapter(context,mList)
        gv_find.adapter = mAdapter
        gv_find.setOnItemClickListener { parent, view, position, id ->
            var bean = mList?.get(position)
            var name = bean?.name
            var intent : Intent = Intent(context,FindDetailActivity::class.java)
            intent.putExtra("name",name)
            startActivity(intent)

        }
    }

}