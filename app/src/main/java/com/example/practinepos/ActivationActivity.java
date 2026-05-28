package com.example.practinepos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivationActivity extends AppCompatActivity {

    EditText etKey;
    Button btnActivate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation);

        etKey = findViewById(R.id.etKey);
        btnActivate = findViewById(R.id.btnActivate);

        btnActivate.setOnClickListener(v -> {

            String key = etKey.getText().toString();

            // simulasi validasi
            if (key.equals("ABC123")) {

                SharedPreferences prefs =
                        getSharedPreferences("APP_PREFS", MODE_PRIVATE);

                prefs.edit()
                        .putBoolean("ACTIVATED", true)
                        .apply();

                Toast.makeText(this,
                        "Activation Success",
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(this, HomeActivity.class));
                finish();

            } else {

                Toast.makeText(this,
                        "Invalid Key",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}