package com.example.a64.intents;

import java.io.Serializable;

/**
 * Created by 64 on 26/11/2016.
 */

public class Person implements Serializable {
    private String nombre;
    private String web;
    private int telefono;

    public Person (String nombre, String web, int telefono){
        this.nombre=nombre;
        this.web=web;
        this.telefono=telefono;
    }

}
