package com.dam.proyectobadt2_rubenbalboa.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.dam.proyectobadt2_rubenbalboa.entity.Terremoto;
import java.util.List;

@Dao
public interface TerremotosDao {
    @Query("SELECT * FROM TERREMOTOS")
    public List<Terremoto> getAll();

    @Insert
    public void insert(Terremoto terremoto);

    @Query("SELECT * FROM terremotos ORDER BY magnitud DESC")
    public List<Terremoto> getAllOrderByMagnitud();

    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :mes || '%' ORDER BY magnitud DESC")
    public List<Terremoto> getTerremotosByMes(String mes);

    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :anio || '%' ORDER BY magnitud DESC")
    public List<Terremoto> getTerremotosByAnio(String anio);

    @Query("SELECT * FROM terremotos WHERE fechaHora IN (SELECT fechaHora FROM PAISES_AFECTADOS WHERE PAIS LIKE '%' || :pais || '%') ORDER BY magnitud DESC")
    public List<Terremoto> getTerremotosByPais(String pais);


    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :mes || '%' AND fechaHora LIKE '%' || :anio || '%' ORDER BY magnitud DESC")
    public List<Terremoto> getTerremotosByMesAndAnio(String mes, String anio);

    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :mes || '%' AND fechaHora IN" +
            " (SELECT fechaHora FROM PAISES_AFECTADOS WHERE PAIS LIKE '%' || :pais || '%') ORDER BY magnitud DESC")
    public List<Terremoto> getTerremotosByMesAndPais(String mes, String pais);

    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :anio || '%' AND fechaHora IN" +
            " (SELECT fechaHora FROM PAISES_AFECTADOS WHERE PAIS LIKE '%' || :pais || '%') ORDER BY magnitud DESC")
    public List<Terremoto> getTerremotosByAnioAndPais(String anio, String pais);

    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :mes || '%' AND fechaHora LIKE '%' || :anio || '%' AND fechaHora IN" +
            " (SELECT fechaHora FROM PAISES_AFECTADOS WHERE PAIS LIKE '%' || :pais || '%') ORDER BY magnitud DESC")
    public List<Terremoto> getTerremotosByMesAndAnioAndPais(String mes, String anio, String pais);

}
