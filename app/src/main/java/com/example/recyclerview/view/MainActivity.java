package com.example.recyclerview.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Animal;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements RecyclerViewFragment.RecyclerViewFragmentListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private CardView navigationViewCardView;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activityMainBottomNavigationView);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);

        View headerView = navigationView.getHeaderView(0);
        navigationViewCardView = headerView.findViewById(R.id.navHeaderCardView);

        setNavigationViewListener();
        setBottomNavigationViewListener();


        navigationViewCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cambiando foto de perfil...", Toast.LENGTH_SHORT).show();
            }
        });

        //pegar el fragment.
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        pegarFragment(recyclerViewFragment);

        Toast.makeText(this, "hasta aca llego el codigo, aguante no debugear", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "hasta aca llego el codigo, aguante no debugear", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "hasta aca llego el codigo, aguante no debugear", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "hasta aca llego el codigo, aguante no debugear", Toast.LENGTH_SHORT).show();
    }

    private void setBottomNavigationViewListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.boHome:
                        Toast.makeText(MainActivity.this, "En Construccion", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.boSearch:
                        Toast.makeText(MainActivity.this, "En Construccion", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.boLibrary:
                        drawerLayout.openDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });
    }


    private void setNavigationViewListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuInicio:
                        Toast.makeText(MainActivity.this, "Presionaron inicio", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.menuFavorito:
                        FavoritoFragment favoritoFragment = new FavoritoFragment();
                        pegarFragment(favoritoFragment);
                        drawerLayout.closeDrawers();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "En construccion", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    private void pegarFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityMainContenedorFragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClickAnimalDesdeFragment(Animal animal) {

        Intent unIntent = new Intent(this, DetailActivity.class);

        Bundle bundle = new Bundle();

        bundle.putSerializable(DetailFragment.ANIMAL, animal);

        unIntent.putExtras(bundle);

        startActivity(unIntent);
    }


}
