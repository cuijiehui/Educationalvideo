package com.example.educationalvideo.dao

/**
 * @author cui
 * @data 2020/5/21
 * Description:
 */
class DaoFactory {
    companion object{
        private var instance :DaoFactory? =null
        fun getInstance():DaoFactory?{
            if (instance==null) {
                synchronized(DaoFactory::class.java){
                    if (instance==null) {
                        instance = DaoFactory()
                    }
                }
            }
            return instance
        }
    }
    fun getVideoDb():Videoable{
        return VideoImpl()
    }
    fun getCollectVideo():CollectVideoAble{
        return CollectVideoImpl()
    }
}