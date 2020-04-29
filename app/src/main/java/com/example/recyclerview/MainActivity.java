package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RecyclerViewFragment.RecyclerViewFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pegar el fragment.
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        pegarFragment(recyclerViewFragment);

    }

    private void pegarFragment(RecyclerViewFragment recyclerViewFragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityMainContenedorFragment,recyclerViewFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClickAnimalDesdeFragment(Animal animal) {

        Intent unIntent = new Intent(this,DetailActivity.class);

        Bundle bundle = new Bundle();

        bundle.putSerializable(DetailFragment.ANIMAL,animal);

        unIntent.putExtras(bundle);

        startActivity(unIntent);
    }
}
