package com.example.mediaaluno;

import android.os.Bundle;
import android.view.View;
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

public class Cadastro_Aluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_aluno);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edt_ra = findViewById(R.id.edt_ra);
        EditText edt_nome = findViewById(R.id.edt_nome);
        EditText edt_email = findViewById(R.id.edt_email);
        TextView txt_mensagem = findViewById(R.id.txt_mensagem);
        Button btn_Cadastrar = findViewById(R.id.btn_Cadastrar);
        ImageButton btn_voltar = findViewById(R.id.btn_voltar);

        // Seta: volta para a tela inicial
        btn_voltar.setOnClickListener(v -> finish());

        btn_Cadastrar.setOnClickListener(v -> {

            // Validação se algum campo estiver vazio, avisa e para
            if (edt_ra.getText().toString().isEmpty() || edt_nome.getText().toString().isEmpty()
                    || edt_email.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os dados!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Verifica se o RA já está cadastrado
            if (AppDatabase.getInstance(this).alunoDao().buscarPorRa(edt_ra.getText().toString()) != null) {
                Toast.makeText(this, "Este RA já está cadastrado!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cria um aluno novo com os dados digitados
            Aluno aluno = new Aluno();
            aluno.ra = edt_ra.getText().toString();
            aluno.nome = edt_nome.getText().toString();
            aluno.email = edt_email.getText().toString();

            // Salva no banco
            AppDatabase.getInstance(this).alunoDao().inserir(aluno);

            // Limpa os campos
            edt_ra.setText("");
            edt_nome.setText("");
            edt_email.setText("");

            // Mostra a mensagem de sucesso
            txt_mensagem.setVisibility(View.VISIBLE);
        });
    }
}