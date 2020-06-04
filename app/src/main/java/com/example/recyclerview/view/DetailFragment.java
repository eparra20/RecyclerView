package com.example.recyclerview.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.recyclerview.R;
import com.example.recyclerview.databinding.FragmentDetailBinding;
import com.example.recyclerview.model.Animal;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public static final String ANIMAL = "animal";

    private Toolbar toolbar;
    private FragmentDetailBinding binding;
    private DetailFragmentListener detailFragmentListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.detailFragmentListener = (DetailFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Bundle bundle = getArguments();

        Animal animal = (Animal) bundle.getSerializable(ANIMAL);

        getActivity().getSupportFragmentManager();

        toolbar = binding.activityMainToolbar;

        configurarToolBarEnFragment();

        binding.fragmentDetailImageView.setImageResource(animal.getImagen());
      //  binding.fragmentDetailTextViewNombreAnimal.setText(animal.getNombre());
        toolbar.setTitle(animal.getNombre());

        binding.unButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailFragmentListener.onClickFloating();
            }
        });

        return view;
    }

    private void configurarToolBarEnFragment() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar supportActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public interface DetailFragmentListener{
        public void onClickFloating();
    }
}
