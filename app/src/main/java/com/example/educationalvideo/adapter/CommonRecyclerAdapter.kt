package com.example.educationalvideo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author cui
 * @data 2020/4/1
 * Description:
 */
class CommonRecyclerAdapter<T>(context: Context,
                               layoutInflater: LayoutInflater
                               ) : RecyclerView.Adapter<CommonRecyclerAdapter.CommonViewHolder<T>>() {
    lateinit var context : Context
    lateinit var layoutInflater: LayoutInflater
    var layoutId :Int = 0
    var variableId :Int = 0
    var lists : List<T> = ArrayList<T>()
    init {
        this.context = context
        this.layoutInflater= layoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<T> {
        var viewDatabinding =DataBindingUtil.inflate<ViewDataBinding>(layoutInflater,layoutId,parent,false)
        var viewHolder = CommonViewHolder<T>(viewDatabinding.root.rootView)
        viewHolder.viewDataBinding=viewDatabinding
        return viewHolder
    }

    override fun onBindViewHolder(holder: CommonRecyclerAdapter.CommonViewHolder<T>, position:Int){
        holder.setContent(variableId,lists[position])
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    class CommonViewHolder<T>(itemView :View) : RecyclerView.ViewHolder(itemView){
        var viewDataBinding:ViewDataBinding ?= null
        fun setContent(variableId :Int ,t: T){
            viewDataBinding!!.setVariable(variableId,t)
            viewDataBinding!!.executePendingBindings()
        }
    }
}