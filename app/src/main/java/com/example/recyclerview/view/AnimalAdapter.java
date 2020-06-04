package com.example.recyclerview.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolderAnimal> {

    private List<Animal> animalList;
    private AnimalAdapterListener animalAdapterListener;

    public AnimalAdapter(List<Animal> animalList, AnimalAdapterListener listener) {
        this.animalList = animalList;
        this.animalAdapterListener = listener;
    }

    @NonNull
    @Override
    public ViewHolderAnimal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celda_animal, parent, false);
        return new ViewHolderAnimal(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAnimal holder, int position) {
        Animal animal = this.animalList.get(position);
        holder.onBind(animal);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }


    public interface AnimalAdapterListener {
        void onClickAnimal(Animal animal);
    }

    //La representacion de mi celda.
    protected class ViewHolderAnimal extends RecyclerView.ViewHolder {

        private ImageView imageViewAnimal;
        private TextView textViewNombreAnimal;

        public ViewHolderAnimal(@NonNull final View itemView) {
            super(itemView);
            imageViewAnimal = itemView.findViewById(R.id.celdaImaveViewAnimal);
            textViewNombreAnimal = itemView.findViewById(R.id.celdaTextViewNombreAnimal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animal animal = animalList.get(getAdapterPosition());
                    animalAdapterListener.onClickAnimal(animal);
                }
            });
        }

        public void onBind(Animal animal) {
            imageViewAnimal.setImageResource(animal.getImagen());
            textViewNombreAnimal.setText(animal.getNombre());
        }
    }
}
