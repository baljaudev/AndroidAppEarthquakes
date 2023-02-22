package com.dam.proyectobadt2_rubenbalboa.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.dam.proyectobadt2_rubenbalboa.entity.PaisAfectado;

import java.util.List;

@Dao
public interface PaisesDao {
    @Query("SELECT * FROM PAISES_AFECTADOS")
    public List<PaisAfectado> getAll();

    @Insert
    public void insert(PaisAfectado paisAfectado);

    @Query("SELECT DISTINCT PAIS FROM PAISES_AFECTADOS ORDER BY PAIS")
    public List<String> getAllPaises();
}
