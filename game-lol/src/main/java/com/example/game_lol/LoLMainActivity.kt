package com.example.game_lol

import android.content.Context
import android.content.Intent

import android.os.Bundle

import androidx.databinding.DataBindingUtil
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.game_common.base.BaseAppCompatActivity
import com.example.game_common.network.RetrofitHttp
import com.example.game_common.utils.SpinnerItems

import com.example.game_lol.adapter.HotDataAdapterR
import com.example.game_lol.databinding.ActivityLolMainBinding
import com.example.game_net.network.ResponseData
import com.example.game_net.network.ResponseObserver


class LoLMainActivity : BaseAppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var mBinding: ActivityLolMainBinding
    private lateinit var mAdapter: HotDataAdapterR
    private var mHodDataFrom = SpinnerItems.ZHIHU.key


    companion object {
        fun lunch(context: Context) {
            val intent = Intent(context, LoLMainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lol_main)
        initView()
        initMenu()
    }

    private fun initView() {
        mBinding.imgBack.setOnClickListener {
            finish()
        }
        mAdapter = HotDataAdapterR(this)
        mBinding.rvList.adapter = mAdapter
        initData()
    }

    private fun initMenu() {

        // 下拉菜单设置选项数据
        mBinding.spinner.setItems(
            SpinnerItems.ZHIHU.values,
            SpinnerItems.WEIBO.values,
            SpinnerItems.TOUTIAO.values,
            SpinnerItems.WY163.values,
            SpinnerItems.CSDN.values,
            SpinnerItems.JUEJIN.values,
            SpinnerItems.DOUYIN.values
        )

        mBinding.spinner.setOnItemSelectedListener { _, position, _, i ->
            mHodDataFrom = SpinnerItems.getKeyByValues(i as String)
            onRefresh()
        }


    }

    private fun initData() {

        val observable = RetrofitHttp.getService().getHotDataList(mHodDataFrom)
        RetrofitHttp.execute(observable, object : ResponseObserver<ResponseData>() {
            override fun onSuccess(result: ResponseData?) {
                result?.let {
                    it.data?.list?.let { it1 -> mAdapter.setDataList(it1) }
                }
            }

            override fun onFailure(msg: String) {
                showToast(msg)
            }

        })


    }

    override fun onRefresh() {
        initData()
    }


}