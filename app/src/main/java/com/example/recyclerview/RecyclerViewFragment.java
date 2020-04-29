package com.example.recyclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements AnimalAdapter.AnimalAdapterListener {


    private RecyclerViewFragmentListener recyclerViewFragmentListener;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Es cuando el fragment conoce donde se pego.
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
        View view =  inflater.inflate(R.layout.fragment_recycler_view, container, false);


        RecyclerView recyclerViewAnimales = view.findViewById(R.id.fragmentRecyclerRecyclerView);


        List<Animal> animalList = ProveedorDeAnimales.getAnimales();
        AnimalAdapter animalAdapter = new AnimalAdapter(animalList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);


        recyclerViewAnimales.setLayoutManager(linearLayoutManager);
        recyclerViewAnimales.setAdapter(animalAdapter);

        return view;
    }


    @Override
    public void onClickAnimal(Animal animal) {
        recyclerViewFragmentListener.onClickAnimalDesdeFragment(animal);
    }

    public interface RecyclerViewFragmentListener{
        public void onClickAnimalDesdeFragment(Animal animal);
    }
}
