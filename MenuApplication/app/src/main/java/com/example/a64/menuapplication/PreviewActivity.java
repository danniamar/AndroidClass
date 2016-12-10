package com.example.a64.menuapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class PreviewActivity extends AppCompatActivity {

    private int resourseId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        resourseId = extras.getInt("image");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(resourseId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
