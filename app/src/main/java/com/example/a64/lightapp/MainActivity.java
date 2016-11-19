package com.example.a64.lightapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = " LINTERNA";
    private static final int RC_HANDLE_CAMERA_PERM = 2;
    private Camera camera;
    private boolean isFlash;
    private Camera.Parameters param;
    private boolean isFlashOn;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Consulta si el dispositivo tiene camara con flash
        isFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if(isFlash){
            Log.e(TAG, "No hay Flash");
            //Constructor AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Alerta")
                    .setMessage("Su dispositivo no posee Flash")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            //Crear AlertDialog
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

            toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) turnOnFlash();
                    else turnOffFlash();
                }
            });
    }

    @Override
    protected void onStart() {
        super.onStart();

        int rc= ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (rc == PackageManager.PERMISSION_GRANTED){
            getCamara();
        }else{
            requestCameraPermission();
        }

        /*Log.e(TAG, " onStart " + toggleButton.getTextOn());

        if(toggleButton.getText().equals(toggleButton.getTextOn())) {
            isFlashOn = false;
            turnOnFlash();
        }
        else turnOffFlash();*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isFlashOn) ledOn();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(camera!=null){
            camera.release();
            camera = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "Evento onDestroy");
    }

    private void requestCameraPermission() {
        final String[] permissions = new String[]{Manifest.permission.CAMERA};
        /*if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
            return;
        }*/
        ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
    }

    private void getCamara() {
        if(camera == null){
            camera = Camera.open();
            param = camera.getParameters();
        }else{
            Log.e(TAG, "Error de Camara");
        }
    }

    private void ledOn() {
        if(camera==null || param == null){
            return;
        }
        param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(param);
        //enciende la camara
        camera.startPreview();
        isFlashOn = true;
    }

    private void turnOnFlash() {
        if(!isFlashOn){
           ledOn();
            Log.e(TAG, "Flash encendido...");
        }
    }

    private void turnOffFlash () {
        if(isFlashOn){
            if(camera==null || param == null){
                return;
            }
            param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(param);
            //enciende la camara
            camera.stopPreview();
            isFlashOn = false;

            Log.e(TAG, "Flash apagado...");
        }
    }


}
