//package com.example.educationalvideo.adapter
//
//import android.content.Context
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import com.example.educationalvideo.R
//
///**
// * @author cui
// * @data 2020/3/26
// * Description:
// */
//class MainDataAdapter(var mContext : Context ,var items:List<String>) : RecyclerView.Adapter<MainDataAdapter.MyViewHodel>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHodel {
//        return MyViewHodel(LayoutInflater.from(mContext).inflate(R.layout.main_data_item,parent))
//    }
//
//    override fun getItemCount(): Int =items.size
//
//    override fun onBindViewHolder(holder: MyViewHodel, position: Int) {
//        holder.textView!!.text = items[position]
//    }
//
//    class MyViewHodel : RecyclerView.ViewHolder {
//        var textView :TextView ?= null
//
//        constructor(itemView :View):super(itemView){
//            textView =  itemView.findViewById<TextView>(R.id.tv_name)
//
//        }
//    }
//
//}