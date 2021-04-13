package com.example.games

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.game_common.utils.Tips
import com.example.game_lol.LoLMainActivity

import com.example.games.adapter.AnimationAdapter
import com.example.games.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter:AnimationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // 对item布局大小固定，不用重新计算
        mBinding.rvList.setHasFixedSize(true)
        //
        mBinding.rvList.layoutManager = LinearLayoutManager(this)
        initView()
        initAdapter()


    }



    private fun initAdapter() {
        mAdapter = AnimationAdapter(this)
        // 打开动画
        mAdapter.animationEnable = true
        //init firstOnly state
        mAdapter.isAnimationFirstOnly = false
        mAdapter.addChildClickViewIds(R.id.img, R.id.tweetName, R.id.tweetText);
        mAdapter.setOnItemChildClickListener{ _, _, p ->
            Tips.show("$p")
        }
        mBinding.rvList.adapter = mAdapter

    }

    private fun initView() {
        mBinding.imgBack.setOnClickListener {
            finish()
        }

    }


}