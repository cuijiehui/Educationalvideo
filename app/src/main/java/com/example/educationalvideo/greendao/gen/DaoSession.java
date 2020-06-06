package com.example.educationalvideo.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.educationalvideo.dao.Video;
import com.example.educationalvideo.dao.CollectVideoBean;

import com.example.educationalvideo.greendao.gen.VideoDao;
import com.example.educationalvideo.greendao.gen.CollectVideoBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig videoDaoConfig;
    private final DaoConfig collectVideoBeanDaoConfig;

    private final VideoDao videoDao;
    private final CollectVideoBeanDao collectVideoBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        videoDaoConfig = daoConfigMap.get(VideoDao.class).clone();
        videoDaoConfig.initIdentityScope(type);

        collectVideoBeanDaoConfig = daoConfigMap.get(CollectVideoBeanDao.class).clone();
        collectVideoBeanDaoConfig.initIdentityScope(type);

        videoDao = new VideoDao(videoDaoConfig, this);
        collectVideoBeanDao = new CollectVideoBeanDao(collectVideoBeanDaoConfig, this);

        registerDao(Video.class, videoDao);
        registerDao(CollectVideoBean.class, collectVideoBeanDao);
    }
    
    public void clear() {
        videoDaoConfig.clearIdentityScope();
        collectVideoBeanDaoConfig.clearIdentityScope();
    }

    public VideoDao getVideoDao() {
        return videoDao;
    }

    public CollectVideoBeanDao getCollectVideoBeanDao() {
        return collectVideoBeanDao;
    }

}
