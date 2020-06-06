package com.example.educationalvideo.dao

/**
 * @author cui
 * @data 2020/5/21
 * Description:
 */
interface Videoable {
    /**
     * 插入单个数据
     * @param bean Video
     */
    fun insert(bean :Video)

    /**
     * 批量插入
     * @param beanList List<Video>
     */
    fun insertList(beanList:List<Video>)

    /**
     * 删除所有的数据
     */
    fun delete()

    /**
     * 查询所有的数据
     * @return List<Video>
     */
    fun findVideoDataAll():List<Video>

    /**
     * 改数据
     * @param bean Video
     */
    fun updateVideoData(bean : Video)

}