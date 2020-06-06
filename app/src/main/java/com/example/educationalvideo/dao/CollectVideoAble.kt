package com.example.educationalvideo.dao

/**
 * @author cui
 * @data 2020/5/21
 * Description:
 */
interface CollectVideoAble {
    /**
     * 插入单个数据
     * @param bean CollectVideoBean
     */
    fun insert(bean :CollectVideoBean)

    /**
     * 批量插入
     * @param beanList List<CollectVideoBean>
     */
    fun insertList(beanList:List<CollectVideoBean>)

    /**
     * 删除所有的数据
     */
    fun delete()

    /**
     * 查询所有的数据
     * @return List<CollectVideoBean>
     */
    fun findVideoDataAll():List<CollectVideoBean>


    /**
     * 改数据
     * @param bean CollectVideoBean
     */
    fun updateVideoData(bean : CollectVideoBean)
}