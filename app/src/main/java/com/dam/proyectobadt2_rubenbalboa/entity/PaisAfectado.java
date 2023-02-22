package com.dam.proyectobadt2_rubenbalboa.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity (tableName = "PAISES_AFECTADOS",
    foreignKeys = {
        @ForeignKey(entity = Terremoto.class,
            parentColumns = "fechaHora",
            childColumns = "fechaHora",
            onDelete = ForeignKey.CASCADE),
    }, primaryKeys = {"fechaHora", "pais"})
public class PaisAfectado {
    @NonNull
    @ColumnInfo(name = "fechaHora")
    public String fechaHora;

    @NonNull
    @ColumnInfo(name = "pais")
    public String pais;


    public PaisAfectado(String fechaHora, String pais) {
        this.fechaHora = fechaHora;
        this.pais = pais;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
