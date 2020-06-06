package com.example.educationalvideo.dao

import com.example.educationalvideo.greendao.gen.CollectVideoBeanDao
import org.greenrobot.greendao.query.WhereCondition

/**
 * @author cui
 * @data 2020/5/21
 * Description:
 */
class CollectVideoImpl :CollectVideoAble {
    private var db : CollectVideoBeanDao?=null
    init {
        db =  MyDbManeger.getDaoSessionNormal()!!.collectVideoBeanDao
    }
    override fun insert(bean: CollectVideoBean) {
        db!!.insert(bean)
    }

    override fun insertList(beanList: List<CollectVideoBean>) {
        db!!.insertInTx(beanList)
    }

    override fun delete() {
        db!!.deleteAll()
    }

    override fun findVideoDataAll(): List<CollectVideoBean> {
        return db!!.queryBuilder().list()
    }
    fun findData(cond :WhereCondition ,vararg condMore: WhereCondition ){
        for (whereCondition in condMore) {
            db!!.queryBuilder().where(cond,whereCondition)

        }
    }
    override fun updateVideoData(bean: CollectVideoBean) {
        db!!.insertOrReplace(bean)
    }
}