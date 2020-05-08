package com.example.recyclerview.service;

import com.example.recyclerview.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Aca tenemos los servicios de PHOTOS.
 */
public interface PhotosService {

    //https://jsonplaceholder.typicode.com/photos/1
    //devuelve una unica foto.
    @GET("photos/{id}")
    Call<Photo> getPhoto(@Path("id") String id);

    //esto devuelve un listado de fotos
    @GET("photos")
    Call<List<Photo>> getPhotos();
}
