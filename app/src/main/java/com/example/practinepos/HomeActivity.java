package com.example.practinepos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = findViewById(R.id.bottom_nav);
        replaceFragment(new HomeFragment());

        bottomNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home){
                replaceFragment(new HomeFragment());
            }
            else if (item.getItemId() == R.id.nav_products){
                replaceFragment(new ProductsFragment());
            }
            else if (item.getItemId() == R.id.nav_profile){
                SharedPreferences prefs = getSharedPreferences("APP_PREFS", MODE_PRIVATE);

                prefs.edit()
                        .putBoolean("ACTIVATED", false)
                        .apply();
            }
            else if (item.getItemId() == R.id.nav_create){
                replaceFragment(new CreateFragment());
            }
            else if (item.getItemId() == R.id.nav_transactions){
                replaceFragment(new TransactionsFragment());
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.frame_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void showBottomNav(boolean show){
        BottomNavigationView nav = findViewById(R.id.bottom_nav);
        if (show){
            nav.setVisibility(View.VISIBLE);
        } else {
            nav.setVisibility(View.GONE);
        }
    }

}