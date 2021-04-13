package com.example.game_common.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassNameDescription
 *
 * @Author xushuo
 * @Date 2021-04-07
 * @Description
 */
abstract class RecycleViewAdapter<E, T : RecycleViewAdapter.Companion.XViewHolder>(val context: Context) : RecyclerView.Adapter<T>() {
    protected var mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
    protected var mDataList: MutableList<E> = mutableListOf()

    companion object {
        class XViewHolder(view: ViewDataBinding) : RecyclerView.ViewHolder(view.root) {
                val viewBinding = view

        }
    }


    fun setDataList(data: List<E>) {
        mDataList = data as MutableList<E>
        notifyDataSetChanged()
    }

    fun getDataList(): List<E> {
        return mDataList
    }

    fun addDataList(data: E) {
        val pos = itemCount
        mDataList.add(data)
        notifyItemInserted(pos)
    }


    fun getItem(pos: Int) = mDataList[pos]


    override fun getItemCount() = mDataList.size
}