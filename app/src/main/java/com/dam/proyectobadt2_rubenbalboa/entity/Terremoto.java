package com.dam.proyectobadt2_rubenbalboa.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (tableName = "TERREMOTOS",
        indices = {@Index(value = {"nombreTerremoto"},unique = true)})
public class Terremoto {
    @PrimaryKey
    @NonNull
            @ColumnInfo(name = "fechaHora")
    public String fechaHora;

    @ColumnInfo(name = "magnitud")
    public double magnitud;

    @ColumnInfo(name = "nombreTerremoto")
    public String nombreTerremoto;

    @ColumnInfo(name = "lugar")
    public String lugar;

    @ColumnInfo(name = "coordenadas")
    public String coordenadas;

    @ColumnInfo(name = "numMuertos")
    public String numMuertos;


    public Terremoto(String fechaHora, double magnitud, String nombreTerremoto, String lugar, String coordenadas, String numMuertos) {
        this.fechaHora = fechaHora;
        this.magnitud = magnitud;
        this.nombreTerremoto = nombreTerremoto;
        this.lugar = lugar;
        this.coordenadas = coordenadas;
        this.numMuertos = numMuertos;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombreTerremoto() {
        return nombreTerremoto;
    }

    public void setNombreTerremoto(String nombreTerremoto) {
        this.nombreTerremoto = nombreTerremoto;
    }

    public double getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNumMuertos() {
        return numMuertos;
    }

    public void setNumMuertos(String numMuertos) {
        this.numMuertos = numMuertos;
    }
}
