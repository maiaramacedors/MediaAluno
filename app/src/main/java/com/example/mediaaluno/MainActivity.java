package com.example.mediaaluno;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_media= findViewById(R.id.btn_media);
        Button btn_cadastro = findViewById(R.id.btn_cadastro);

        btn_media.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Calcular_Media.class);
            startActivity(intent);
        });

        btn_cadastro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Cadastro_Aluno.class);
            startActivity(intent);
        });
    }
}