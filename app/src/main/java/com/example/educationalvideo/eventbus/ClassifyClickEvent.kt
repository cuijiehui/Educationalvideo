package com.example.educationalvideo.eventbus

/**
 * @author cui
 * @data 2020/5/18
 * Description: eventbus事件
 *                  视频分类点击事件
 */
class ClassifyClickEvent(position:Int,oldPosition:Int,classifyName:String) {
    var position :Int = position
    var oldPosition :Int = oldPosition
    var classifyName : String = classifyName
}