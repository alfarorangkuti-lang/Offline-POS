package com.example.practinepos;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launching_activity);
        SharedPreferences prefs = getSharedPreferences("APP_PREFS", MODE_PRIVATE);
        boolean activated = prefs.getBoolean("ACTIVATED", false);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (activated){
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                startActivity(new Intent(this, ActivationActivity.class));
            }
            finish();
        }, 1000);
    }
}