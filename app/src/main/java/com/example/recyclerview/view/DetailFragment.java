package com.example.recyclerview.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Animal;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public static final String ANIMAL = "animal";

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  =  inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle bundle = getArguments();

        Animal animal = (Animal) bundle.getSerializable(ANIMAL);

        ImageView imageViewAnimal = view.findViewById(R.id.fragmentDetailImageView);
        TextView textViewAnimal = view.findViewById(R.id.fragmentDetailTextViewNombreAnimal);

        imageViewAnimal.setImageResource(animal.getImagen());
        textViewAnimal.setText(animal.getNombre());

        return  view;
    }

}
