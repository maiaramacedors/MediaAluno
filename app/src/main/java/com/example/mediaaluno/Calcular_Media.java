package com.example.mediaaluno;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calcular_Media extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcular_media);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtNota1 = findViewById(R.id.edtNota1);
        EditText edtNota2 = findViewById(R.id.edtNota2);
        EditText edtNota3 = findViewById(R.id.edtNota3);
        EditText edtNota4 = findViewById(R.id.edtNota4);
        TextView txt_resultado = findViewById(R.id.txt_resultado);
        Button btn_Resultado = findViewById(R.id.btn_Resultado);
        ImageButton btn_voltar = findViewById(R.id.btn_voltar);

        btn_voltar.setOnClickListener(v -> finish());

        btn_Resultado.setOnClickListener(v -> {

            // Validação: se algum campo estiver vazio, avisa e para
            if (edtNota1.getText().toString().isEmpty() || edtNota2.getText().toString().isEmpty()
                    || edtNota3.getText().toString().isEmpty() || edtNota4.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todas as notas!", Toast.LENGTH_SHORT).show();
                return;
            }
                // Transforma o texto dos campos em números
                double nota1 = Double.parseDouble(edtNota1.getText().toString());
                double nota2 = Double.parseDouble(edtNota2.getText().toString());
                double nota3 = Double.parseDouble(edtNota3.getText().toString());
                double nota4 = Double.parseDouble(edtNota4.getText().toString());

                double media = (nota1 + nota2 + nota3 + nota4) / 4;

                txt_resultado.setText(String.format("Média final: %.2f", media));
            });
        }
    }