package com.example.recyclerview.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.recyclerview.R;

public class DetailActivity extends AppCompatActivity implements DetailFragment.DetailFragmentListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();


        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detailActivityContenedorFragment, detailFragment)
                .commit();


    }

    @Override
    public void onClickFloating() {
         Toast.makeText(this, "EXIS", Toast.LENGTH_SHORT).show();
    }
}
