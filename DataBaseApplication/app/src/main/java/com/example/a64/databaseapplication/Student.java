package com.example.a64.databaseapplication;

import java.io.Serializable;

/**
 * Created by 64 on 10/12/2016.
 */

public class Student implements Serializable {

    private String Nombre;
    private String Telefono;
    private String Carrera;

    public Student(){

    }

    public String getCarrera() {
        return Carrera;
    }

    public String getTelefono() {
        return Telefono;
    }

    public Student(String nombre, String telefono, String carrera) {
        Nombre = nombre;
        Telefono = telefono;
        Carrera = carrera;
    }

    public String getNombre() {
        return Nombre;
    }
}
