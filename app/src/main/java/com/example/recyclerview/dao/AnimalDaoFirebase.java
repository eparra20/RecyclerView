package com.example.recyclerview.dao;

import androidx.annotation.NonNull;

import com.example.recyclerview.model.Animal;
import com.example.recyclerview.util.ResultListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class AnimalDaoFirebase {

    public static final String ANIMALES = "animales";

    private CollectionReference reference;

    public AnimalDaoFirebase() {

        // Access a Cloud Firestore instance from your Activity
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(false)
                .build();
        db.setFirestoreSettings(settings);

        reference = db.collection(ANIMALES);

    }

    /**
     * Busca en la collection de animales todos los animales
     * @param resultListener
     */
    public void getAnimales(ResultListener<List<Animal>> resultListener){

       reference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
           @Override
           public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
               List<Animal> animals = queryDocumentSnapshots.toObjects(Animal.class);
               resultListener.onFinish(animals);
           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               resultListener.onError("Ha ocurrido un error al obtener los animales "+e.getMessage());
           }
       });
    }

    public void agregarAnimal(Animal animal){

    }
}
