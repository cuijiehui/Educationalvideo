package com.example.educationalvideo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author cui
 * @data 2020/5/20
 * Description:
 */
@Entity
public class Video {
    //@Id：通过这个注解标记的字段必须是Long类型的，这个字段在数据库中表示它就是主键，并且它默认就是自增的
    @Id
    private Long Id;
    private String UserName;
    private String Title;
    private String VideoUrl;
    private String ImageUrl;
    @Generated(hash = 387012502)
    public Video(Long Id, String UserName, String Title, String VideoUrl,
            String ImageUrl) {
        this.Id = Id;
        this.UserName = UserName;
        this.Title = Title;
        this.VideoUrl = VideoUrl;
        this.ImageUrl = ImageUrl;
    }
    @Generated(hash = 237528154)
    public Video() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getUserName() {
        return this.UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public String getTitle() {
        return this.Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getVideoUrl() {
        return this.VideoUrl;
    }
    public void setVideoUrl(String VideoUrl) {
        this.VideoUrl = VideoUrl;
    }
    public String getImageUrl() {
        return this.ImageUrl;
    }
    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

}
