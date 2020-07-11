package com.example.recyclerview.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import com.example.recyclerview.R;
import com.example.recyclerview.config.AppDatabase;
import com.example.recyclerview.databinding.ActivityMainBinding;
import com.example.recyclerview.model.Animal;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements RecyclerViewFragment.RecyclerViewFragmentListener {


    private CardView navigationViewCardView;
    private ActivityMainBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        configurarToolBar();


        configurarNavigationView();

        setBottomNavigationViewListener();

        //pegar el fragment.
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        pegarFragment(recyclerViewFragment);

    }

    private void configurarNavigationView() {
        View headerView = binding.navigationView.getHeaderView(0);
        navigationViewCardView = headerView.findViewById(R.id.navHeaderCardView);
        setNavigationViewListener();
    }

    /**
     * Metodo para configurar la toolb
     */
    private void configurarToolBar() {
        setSupportActionBar(binding.includeToolBar.activityMainToolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.includeToolBar.activityMainToolbar, R.string.open_drawers, R.string.close_drawers);
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBoMenuListener(item);
        return true;
    }

    private void setBottomNavigationViewListener() {
        binding.activityMainBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onBoMenuListener(item);
                return true;
            }
        });
    }

    private void onBoMenuListener(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.boHome:
                Toast.makeText(MainActivity.this, "En Construccion", Toast.LENGTH_SHORT).show();
                break;
            case R.id.boSearch:
                Toast.makeText(MainActivity.this, "En Construccion", Toast.LENGTH_SHORT).show();
                break;
            case R.id.boLibrary:
                binding.drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }


    private void setNavigationViewListener() {
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuInicio:
                        Toast.makeText(MainActivity.this, "Presionaron inicio", Toast.LENGTH_SHORT).show();
                        binding.drawerLayout.closeDrawers();
                        break;
                    case R.id.menuFavorito:
                        FavoritoFragment favoritoFragment = new FavoritoFragment();
                        pegarFragment(favoritoFragment);
                        binding.drawerLayout.closeDrawers();
                        break;
                    case R.id.menuPerfil:
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
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
