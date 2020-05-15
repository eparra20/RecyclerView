package com.example.recyclerview.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Animal;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements RecyclerViewFragment.RecyclerViewFragmentListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private CardView navigationViewCardView;
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        configurarToolBar();

        configurarNavigationView();

        setBottomNavigationViewListener();

        //pegar el fragment.
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        pegarFragment(recyclerViewFragment);

        Toast.makeText(this, "hasta aca llego el codigo, aguante no debugear", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "hasta aca llego el codigo, aguante no debugear", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Aguante CasamCrem con mermelada", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "hasta aca llego el codigo, aguante no debugear", Toast.LENGTH_SHORT).show();
    }

    private void configurarNavigationView() {
        View headerView = navigationView.getHeaderView(0);
        navigationViewCardView = headerView.findViewById(R.id.navHeaderCardView);
        setNavigationViewListener();
    }

    /**
     * Metodo para configurar la toolbar,
     * ALERTA este metodo tiene que ejecutarse despues de {@link #findViews()}
     */
    private void configurarToolBar() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawers,R.string.close_drawers);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    /**
     * Metodo para aplicar los findViewById de cada elemento visual
     */
    private void findViews() {
        bottomNavigationView = findViewById(R.id.activityMainBottomNavigationView);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.activityMainToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bo_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBoMenuListener(item);
        return true;
    }

    private void setBottomNavigationViewListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
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
