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

    // Consulta sin filtros
    @Query("SELECT * FROM terremotos ORDER BY magnitud DESC")
    public List<Terremoto> getAllOrderByMagnitud();


    //Query por Mes:
    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :mes || '%' ORDER BY magnitud")
    public List<Terremoto> getTerremotosByMes(String mes);



    //Query por Año:
    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :anio || '%' ORDER BY magnitud")
    public List<Terremoto> getTerremotosByAnio(String anio);

    //Query por Pais Afectado:
    @Query("SELECT * FROM terremotos WHERE fechaHora = (SELECT fechaHora FROM PAISES_AFECTADOS WHERE PAIS LIKE '%' || :pais || '%') ORDER BY magnitud")
    public List<Terremoto> getTerremotosByPais(String pais);


    //Query por Mes y Año:
    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :mes || '%' AND fechaHora LIKE '%' || :anio || '%' ORDER BY magnitud")
    public List<Terremoto> getTerremotosByMesAndAnio(String mes, String anio);

    //Query por Mes y Pais:
    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :mes || '%' AND fechaHora = (SELECT fechaHora FROM PAISES_AFECTADOS WHERE PAIS LIKE '%' || :pais || '%') ORDER BY magnitud")
    public List<Terremoto> getTerremotosByMesAndPais(String mes, String pais);

    //Query por Año y Pais:
    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :anio || '%' AND fechaHora = (SELECT fechaHora FROM PAISES_AFECTADOS WHERE PAIS LIKE '%' || :pais || '%') ORDER BY magnitud")
    public List<Terremoto> getTerremotosByAnioAndPais(String anio, String pais);

    //Query por Mes, Año y Pais:
    @Query("SELECT * FROM terremotos WHERE fechaHora LIKE '%' || :mes || '%' AND fechaHora LIKE '%' || :anio || '%' AND fechaHora = (SELECT fechaHora FROM PAISES_AFECTADOS WHERE PAIS LIKE '%' || :pais || '%') ORDER BY magnitud")
    public List<Terremoto> getTerremotosByMesAndAnioAndPais(String mes, String anio, String pais);
}
