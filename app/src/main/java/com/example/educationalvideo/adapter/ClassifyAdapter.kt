package com.example.educationalvideo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.educationalvideo.R
import com.example.educationalvideo.eventbus.ClassifyClickEvent
import kotlinx.android.synthetic.main.item_classify.view.*
import org.greenrobot.eventbus.EventBus

/**
 * @author cui
 * @data 2020/5/15
 * Description:视频分类的适配器
 */
class ClassifyAdapter<T>(context: Context,
                         layoutInflater: LayoutInflater,
                         listData:ArrayList<T>,
                         variableId:Int
) :RecyclerView.Adapter<ClassifyAdapter.MyViewHolder<T>>(){
    private var layoutInflater :LayoutInflater = layoutInflater
    private var context :Context = context
    private var listData:ArrayList<T> = listData
    private var variableId:Int=variableId
    private var oldPosition:Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<T> {
        var viewDatabinding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater,R.layout.item_classify,parent,false)
        var myViewHolder = MyViewHolder<T>(viewDatabinding.root)
        myViewHolder.viewDataBinding = viewDatabinding
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder<T>, position: Int) {
        holder.setContent(variableId,listData[position])
        holder.viewDataBinding!!.root.classify_click.setOnClickListener { run {
            EventBus.getDefault().post(ClassifyClickEvent(position,oldPosition,"1"))
            oldPosition=position
        } }
    }

    public class MyViewHolder<T>(itemView : View) : RecyclerView.ViewHolder(itemView){
        var viewDataBinding: ViewDataBinding?= null
        fun setContent(variableId :Int ,t: T){
            viewDataBinding!!.setVariable(variableId,t)
            viewDataBinding!!.executePendingBindings()
        }
    }
}