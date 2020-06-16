package com.example.recyclerview.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.controller.AnimalController;
import com.example.recyclerview.model.Animal;
import com.example.recyclerview.util.ResultListener;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements AnimalAdapter.AnimalAdapterListener {


    private RecyclerViewFragmentListener recyclerViewFragmentListener;

    private RecyclerView recyclerViewAnimales;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Es cuando el fragment conoce donde se pego.
     *
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.recyclerViewFragmentListener = (RecyclerViewFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);


        recyclerViewAnimales = view.findViewById(R.id.fragmentRecyclerRecyclerView);


        AnimalController animalController = new AnimalController();
        //el getAnimals tarda 10 segundos en devolver respuesta.
        animalController.getAnimals(new ResultListener<List<Animal>>() {
            @Override
            public void onFinish(List<Animal> result) {
                cargarRecycler(result);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });


//        Button button = null;
//        //patron observer en android le 70% del patron me lo da android.
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        return view;
    }

    private void cargarRecycler(List<Animal> animalList) {
        AnimalAdapter animalAdapter = new AnimalAdapter(animalList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewAnimales.setLayoutManager(linearLayoutManager);
        recyclerViewAnimales.setAdapter(animalAdapter);
    }


    @Override
    public void onClickAnimal(Animal animal) {
        recyclerViewFragmentListener.onClickAnimalDesdeFragment(animal);
    }

    public interface RecyclerViewFragmentListener {
        void onClickAnimalDesdeFragment(Animal animal);

    }

}
