package com.example.educationalvideo.dao;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author cui
 * @data 2020/5/21
 * Description:
 */
@Entity
public class CollectVideoBean {
    @Id
    private Long Id;

    private String userName;
    private int userId;
    private String videoUrls;
    private String videoTitles;
    private String videoPosters;
    private String collectId;
    private Boolean isCollect;
    @Generated(hash = 1942835586)
    public CollectVideoBean(Long Id, String userName, int userId, String videoUrls,
            String videoTitles, String videoPosters, String collectId,
            Boolean isCollect) {
        this.Id = Id;
        this.userName = userName;
        this.userId = userId;
        this.videoUrls = videoUrls;
        this.videoTitles = videoTitles;
        this.videoPosters = videoPosters;
        this.collectId = collectId;
        this.isCollect = isCollect;
    }
    @Generated(hash = 1563272852)
    public CollectVideoBean() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getVideoUrls() {
        return this.videoUrls;
    }
    public void setVideoUrls(String videoUrls) {
        this.videoUrls = videoUrls;
    }
    public String getVideoTitles() {
        return this.videoTitles;
    }
    public void setVideoTitles(String videoTitles) {
        this.videoTitles = videoTitles;
    }
    public String getVideoPosters() {
        return this.videoPosters;
    }
    public void setVideoPosters(String videoPosters) {
        this.videoPosters = videoPosters;
    }
    public String getCollectId() {
        return this.collectId;
    }
    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }
    public Boolean getIsCollect() {
        return this.isCollect;
    }
    public void setIsCollect(Boolean isCollect) {
        this.isCollect = isCollect;
    }

}
