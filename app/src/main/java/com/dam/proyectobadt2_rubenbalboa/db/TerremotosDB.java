package com.dam.proyectobadt2_rubenbalboa.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.dam.proyectobadt2_rubenbalboa.dao.PaisesDao;
import com.dam.proyectobadt2_rubenbalboa.dao.TerremotosDao;
import com.dam.proyectobadt2_rubenbalboa.entity.PaisAfectado;
import com.dam.proyectobadt2_rubenbalboa.entity.Terremoto;

@Database(entities = {Terremoto.class, PaisAfectado.class}, version = 1)
public abstract class TerremotosDB extends RoomDatabase {

    public abstract TerremotosDao terremotosDAO();
    public abstract PaisesDao paisesDAO();

    private static TerremotosDB terremotosDB;

    public static TerremotosDB getDatabase(Context context) {
        if (terremotosDB == null) {
            terremotosDB = Room.databaseBuilder(
                            context.getApplicationContext(),
                            TerremotosDB.class, "TERREMOTOS_DB")
                    .allowMainThreadQueries()
                    .build();
        }
        return terremotosDB;


    }
}
