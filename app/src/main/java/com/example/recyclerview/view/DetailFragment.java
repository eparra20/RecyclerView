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

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;
import com.example.recyclerview.databinding.FragmentDetailBinding;
import com.example.recyclerview.model.Animal;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public static final String ANIMAL = "animal";

    private Toolbar toolbar;
    private FragmentDetailBinding binding;
    private DetailFragmentListener detailFragmentListener;
    private ActionBar supportActionBar;

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


        configurarToolBarEnFragment();
        StorageReference imageReference = FirebaseStorage.getInstance().getReference(animal.getImagenRef());
        Glide.with(binding.fragmentDetailImageView.getContext()).load(imageReference).into(binding.fragmentDetailImageView);
        supportActionBar.setTitle(animal.getNombre());

        binding.unButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailFragmentListener.onClickFloating();
            }
        });

        return view;
    }

    private void configurarToolBarEnFragment() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.activityMainToolbar);

        supportActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowTitleEnabled(true);
        supportActionBar.setHomeButtonEnabled(true);
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
