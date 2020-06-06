package com.example.educationalvideo.dao

import com.example.educationalvideo.greendao.gen.VideoDao

/**
 * @author cui
 * @data 2020/5/21
 * Description:
 */
class VideoImpl : Videoable{
    private var db :VideoDao?=null
    init {
        db =  MyDbManeger.getDaoSessionNormal()!!.videoDao
    }
    override fun insert(bean: Video) {
        db!!.insert(bean)
    }

    override fun insertList(beanList: List<Video>) {
        db!!.insertInTx(beanList)
    }

    override fun delete() {
        db!!.deleteAll()
    }

    override fun findVideoDataAll(): List<Video> {
        return db!!.queryBuilder().list()
    }

    override fun updateVideoData(bean: Video) {
        db!!.insertOrReplace(bean)
    }
}