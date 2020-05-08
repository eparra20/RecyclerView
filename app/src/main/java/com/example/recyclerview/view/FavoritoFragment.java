package com.example.recyclerview.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;
import com.example.recyclerview.controller.PhotoController;
import com.example.recyclerview.model.Photo;
import com.example.recyclerview.util.ResultListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritoFragment extends Fragment {
    ImageView imageView;
    public FavoritoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorito, container, false);

        imageView = view.findViewById(R.id.fragmentFavoritoImageView);

        //controller
        PhotoController photoController = new PhotoController();
        photoController.getPhoto("10", new ResultListener<Photo>() {
            @Override
            public void onFinish(Photo result) {
                Toast.makeText(getContext(), result.getUrl(), Toast.LENGTH_SHORT).show();
                Glide.with(FavoritoFragment.this)
                        .asGif()
                        .load("https://media.giphy.com/media/3oEjI6SIIHBdRxXI40/source.gif")
                        .error(R.drawable.gatito_a)
                        .into(imageView);
            }
        });


        return view;
    }
}
