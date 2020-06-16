package com.example.recyclerview.controller;

import com.example.recyclerview.dao.PhotoDao;
import com.example.recyclerview.model.Photo;
import com.example.recyclerview.util.ResultListener;

public class PhotoController {

    private PhotoDao photoDao;

    public PhotoController() {
        this.photoDao = new PhotoDao();
    }

    public void getPhoto(String id, final ResultListener<Photo> photoResultListenerFromView){

        this.photoDao.getPhoto(id, new ResultListener<Photo>() {
            @Override
            public void onFinish(Photo result) {
                photoResultListenerFromView.onFinish(result);
            }

            @Override
            public void onError(String message) {

            }
        });
    }
}
