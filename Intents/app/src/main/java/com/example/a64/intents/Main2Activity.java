package com.example.a64.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    public  static final int TELEFONO =0;
    public  static final int WEB =1;
    private static final String TAG = "PERSON";
    private TextView telefono;
    private TextView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            Person person = (Person) extras.getSerializable("object");
          Log.e(TAG, person.getnombre() + "  " + person.gettelefono());
        }

        Person person = (Person) extras.getSerializable("object");

        TextView nombre = (TextView) findViewById(R.id.txt_Nombre);
        nombre.setText(person.getnombre());

        telefono = (TextView) findViewById(R.id.txt_telefono);
        telefono.setText("" + person.gettelefono());
        telefono.setOnClickListener(this);

         web = (TextView) findViewById(R.id.txt_web);
        web.setText(person.getweb());
        web.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.txt_telefono:
                intent.putExtra("data", telefono.getText().toString() );
                setResult(TELEFONO, intent);
                break;
            case R.id.txt_web:
                intent.putExtra("data", web.getText().toString() );
                setResult(WEB, intent);
                break;
            default:

                break;
        }
        finish();
    }
}
