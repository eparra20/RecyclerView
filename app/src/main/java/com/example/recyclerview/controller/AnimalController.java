package com.example.recyclerview.controller;

import com.example.recyclerview.dao.AnimalDao;
import com.example.recyclerview.dao.AnimalDaoFirebase;
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

    public AnimalController() {
        this.animalDaoFirebase = new AnimalDaoFirebase();
    }

    public void getAnimals(ResultListener<List<Animal>> resultListenerDeLaView) {

        if (hayInternet()) {
            //ir a internet y buscar los animales.
             new ArrayList<>();
        } else {
            //los busco en el AnimalDao que esta estatico.
            animalDaoFirebase.getAnimales(new ResultListener<List<Animal>>() {
                @Override
                public void onFinish(List<Animal> result) {
                    resultListenerDeLaView.onFinish(result);
                }

                @Override
                public void onError(String message) {
                    resultListenerDeLaView.onError(message);
                }
            });

        }


    }

    public boolean hayInternet() {
        return false;
    }
}
