package com.example.recyclerview.dao;

import com.example.recyclerview.model.Photo;
import com.example.recyclerview.service.PhotosService;
import com.example.recyclerview.util.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoDao {

    private static String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private Retrofit retrofit;
    private PhotosService photosService;


    public PhotoDao() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //asocio GSON con Retrofit.
                .build();

        //retrofit generame la implementacion de mi servicio
        this.photosService = retrofit.create(PhotosService.class);
    }


    public void getPhoto(String id, final ResultListener<Photo> resultListenerFromController) {


        Call<Photo> photoCall = photosService.getPhoto(id);

        photoCall.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if (response.isSuccessful()) {
                    Photo photo = response.body();
                    resultListenerFromController.onFinish(photo);
                }else{
                    //tomar desicion en caso de error.
                    //time out
                    System.out.println("hubo un error");
                }
            }

            //cuando directamente no se hjace la peticion
            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                t.printStackTrace();
            }
        });

        System.out.println("ALGO");

    }
}
