package com.example.mediaaluno;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlunoDao {

    @Insert
    void inserir(Aluno aluno);

    @Query("SELECT * FROM alunos")
    List<Aluno> listar();

    @Query("SELECT * FROM alunos WHERE ra = :ra LIMIT 1")
    Aluno buscarPorRa(String ra);
}