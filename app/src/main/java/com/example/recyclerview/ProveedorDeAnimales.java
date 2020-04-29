package com.example.recyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que va a proveer de el listado de animales
 */
public abstract class ProveedorDeAnimales {

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
