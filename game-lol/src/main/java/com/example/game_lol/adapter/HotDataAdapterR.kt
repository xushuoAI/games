package com.example.game_lol.adapter

import android.content.Context
import android.view.ViewGroup
import com.example.game_common.base.RecycleViewAdapter
import com.example.game_lol.data.HotItemData
import com.example.game_lol.databinding.ItemHotDataBinding

/**
 * @ClassNameDescription
 *
 * @Author xushuo
 * @Date 2021-04-07
 * @Description
 */
class HotDataAdapterR(val mContext: Context): RecycleViewAdapter<HotItemData, RecycleViewAdapter.Companion.XViewHolder>(mContext) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Companion.XViewHolder {
        val view = ItemHotDataBinding.inflate(mLayoutInflater, parent, false)
        return Companion.XViewHolder(view)
    }

    override fun onBindViewHolder(holder: Companion.XViewHolder, position: Int) {
        val binding = holder.viewBinding as ItemHotDataBinding
        binding.data = getItem(position)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }
}