package com.example.a64.listcontact.models;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by 64 on 26/11/2016.
 */

public class user implements Serializable {
    private String Nombre;
    private String Cargo;
    private int icono;

    public user (String nombre, String cargo, int icon){
        this.Nombre = nombre;
        this.Cargo = cargo;
        this.icono = icon;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCargo() {
        return Cargo;
    }

    public int getImagen() {
        return icono;
    }
}
