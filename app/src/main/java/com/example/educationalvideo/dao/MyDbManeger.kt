package com.example.educationalvideo.dao

import android.annotation.SuppressLint
import android.content.Context
import com.example.educationalvideo.greendao.gen.DaoMaster
import com.example.educationalvideo.greendao.gen.DaoSession
import org.greenrobot.greendao.query.QueryBuilder

/**
 * @author cui
 * @data 2020/5/20
 * Description:
 */
class MyDbManeger {
    companion object {
        private val DEFAULT_DB_NAME = "educational_dao.db"
        @SuppressLint("StaticFieldLeak")
        private var mContext: Context? = null
        private var mDbName: String? = null
        private var mDaoMaster: DaoMaster? = null
        private var mDaoSession : DaoSession? =null
        @SuppressLint("StaticFieldLeak")
        private var mHelper : DaoMaster.DevOpenHelper?=null
        fun init(context:Context){
            init(context, DEFAULT_DB_NAME)
        }
        fun init(context: Context,dbName:String){
            mContext= context.applicationContext
            mDbName=dbName
            enableQueryBuilderLog()
        }

        /**
         * 得到数据库的管理类
         * @return DaoMaster?
         */
        private fun getDaoMasterNormal():DaoMaster?{
            if (mHelper==null) {
                mHelper = DaoMaster.DevOpenHelper(mContext, mDbName,null)
            }
            if (mDaoMaster==null) {
                mDaoMaster = DaoMaster(mHelper!!.writableDatabase)
            }
            return mDaoMaster
        }
        fun getDaoSessionNormal():DaoSession?{
            if (mDaoSession==null) {
                if (mDaoMaster==null) {
                    mDaoMaster= getDaoMasterNormal()
                }
                mDaoSession= mDaoMaster!!.newSession()
            }
            return mDaoSession
        }
        fun enableQueryBuilderLog(){
            QueryBuilder.LOG_SQL=true
            QueryBuilder.LOG_VALUES=true
        }
    }
}