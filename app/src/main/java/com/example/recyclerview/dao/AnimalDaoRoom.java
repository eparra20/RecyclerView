package com.example.recyclerview.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.recyclerview.model.Animal;

import java.util.List;

@Dao
public interface AnimalDaoRoom {

    /**
     * Me crea el SQL necesario para un INSERT INTO en la tabla Animal
     * @param animal
     */
    @Insert
    void insertAll(Animal... animal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Animal> animalList);


    @Delete
    void delete(Animal animal);

    @Query("DELETE FROM ANIMAL")
    void deleteAll();

    @Query("SELECT * FROM Animal")
    List<Animal> getAnimals();

    @Query("SELECT * FROM Animal")
    LiveData<List<Animal>> getAnimalesObserver();


}
