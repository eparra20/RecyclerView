package com.example.recyclerview.controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.recyclerview.config.AppDatabase;
import com.example.recyclerview.dao.AnimalDao;
import com.example.recyclerview.dao.AnimalDaoFirebase;
import com.example.recyclerview.dao.AnimalDaoRoom;
import com.example.recyclerview.model.Animal;
import com.example.recyclerview.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

/**
 * El Controller es quien toma las decisiones.
 */
public class AnimalController {


    private AnimalDaoFirebase animalDaoFirebase;
    private AnimalDaoRoom animalDaoRoom;
    private Context context;

    public AnimalController(Context context) {
        this.context = context;
        this.animalDaoFirebase = new AnimalDaoFirebase();
        this.animalDaoRoom = AppDatabase.getInstance(context).animalDaoRoom();
    }

    public void getAnimals(ResultListener<List<Animal>> resultListenerDeLaView) {

        if (hayInternet()) {
            //los busco en el AnimalDao que esta estatico.
            animalDaoFirebase.getAnimales(new ResultListener<List<Animal>>() {
                @Override
                public void onFinish(List<Animal> result) {
                    animalDaoRoom.insertAll(result);
                    resultListenerDeLaView.onFinish(result);
                }

                @Override
                public void onError(String message) {
                    resultListenerDeLaView.onError(message);
                }
            });

        } else {

            List<Animal> animals = animalDaoRoom.getAnimals();
            resultListenerDeLaView.onFinish(animals);

        }


    }

    public boolean hayInternet() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
