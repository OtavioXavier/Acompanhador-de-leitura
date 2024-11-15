package com.example.acompanhadordeleitura;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        // Código que criei para exibir a progress bar somente após alguns segundos:
        // Obs: Somente para fins de deixar dinâmico!

        ProgressBar progressBar = findViewById(R.id.progressbar_splashscreen);
        progressBar.setVisibility(View.INVISIBLE);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            progressBar.setVisibility(View.VISIBLE);
            Log.d("SplashScreen", "ProgressBar agora visível");

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                startActivity(new Intent(MainActivity.this, LoginScreen.class));
                finish();
            }, 1700);
        }, 1700);
        Toast.makeText(this, getString(R.string.title_toast_splashScreen), Toast.LENGTH_LONG).show();
    }
}