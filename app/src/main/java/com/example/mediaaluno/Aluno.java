package com.example.mediaaluno;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "alunos")
public class Aluno {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String ra;
    public String nome;
    public String email;
}