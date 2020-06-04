package com.example.recyclerview.dao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Animal;
import com.example.recyclerview.model.Direccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Clase que va a proveer de el listado de animales
 * DAO
 * Data Access Object
 */
public abstract class AnimalDao {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Animal> getAnimales() {
        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Animal("Tortuga", R.drawable.gatito_enojado));
        animalList.add(new Animal("Gatito A", R.drawable.gatito_a));
        animalList.add(new Animal("Gatito B", R.drawable.gatito_b));
        animalList.add(new Animal("Gatito C", R.drawable.gatito_c));
        animalList.add(new Animal("Gatito Egipcio", R.drawable.gatito_egipcio));

        animalList.add(new Animal("Gatito C", R.drawable.gatito_c));
        animalList.add(new Animal("Gatito Egipcio", R.drawable.gatito_egipcio));

        animalList.add(new Animal("Gatito C", R.drawable.gatito_c));
        animalList.add(new Animal("Gatito Egipcio", R.drawable.gatito_egipcio));

        return animalList;
    }
}
