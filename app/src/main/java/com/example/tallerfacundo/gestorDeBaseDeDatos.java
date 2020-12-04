package com.example.tallerfacundo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class gestorDeBaseDeDatos extends SQLiteOpenHelper {

    String tabla_tareas = "CREATE TABLE tareas(id int primary key, tarea text, descripcion text, estado text)";

    String tabla_usuarios = "CREATE TABLE usuarios(id int primary key, email text, password text)";

    public gestorDeBaseDeDatos(@Nullable Context context, @Nullable String name,
                               @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_tareas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
