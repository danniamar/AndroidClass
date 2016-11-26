package com.example.a64.intents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.a64.intents.Main2Activity.TELEFONO;
import static com.example.a64.intents.Main2Activity.WEB;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "PERSON";
    private ArrayList<Person> arrayListPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        ListView listView = (ListView) findViewById(R.id.lista);
        arrayListPerson = new ArrayList<>();
        arrayListPerson.add(new Person("Google", "http://www.google.com/", 1111));
        arrayListPerson.add(new Person("Twitter", "http://www.twitter.com/", 2222));
        arrayListPerson.add(new Person("Facebook", "http://www.facebook.com/", 3333));
        arrayListPerson.add(new Person("Yahoo", "http://www.yahoo.com/", 4444));

        ArrayList<String> arrayList = new ArrayList<>();
        for (Person person : arrayListPerson) {
            arrayList.add(person.getnombre());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("object", arrayListPerson.get(position));
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String datos = data.getExtras().getString("data");
        Log.e(TAG, "datos: " + datos);
        switch (resultCode) {
            case TELEFONO:
                Intent In = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + datos));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(In);
                break;
            case WEB:
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse(datos));
                startActivity(I);
                break;
        }
    }
}
