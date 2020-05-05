package com.example.recyclerview.controller;

import com.example.recyclerview.dao.AnimalDao;
import com.example.recyclerview.model.Animal;
import com.example.recyclerview.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

/**
 * El Controller es quien toma las decisiones.
 */
public class AnimalController {

    public void getAnimals(ResultListener<List<Animal>> resultListenerDeLaView) {

        //va a internet, y la respuesta tarda 5 seg
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }

        if (hayInternet()) {
            //ir a internet y buscar los animales.
             new ArrayList<>();
        } else {
            //los busco en el AnimalDao que esta estatico.
            resultListenerDeLaView.onFinish(AnimalDao.getAnimales());
        }


    }

    public boolean hayInternet() {
        return false;
    }
}
