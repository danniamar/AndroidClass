package com.example.a64.httpapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 64 on 03/12/2016.
 */

public class MyPreferences {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;
    private static final String KEY_PREFERENCES = "MyPreferences";
    private static final  String user = "userName";

    public MyPreferences (Context context){
        _context=context;
        sharedPreferences = _context.getSharedPreferences(KEY_PREFERENCES, Activity.MODE_PRIVATE);

        editor = sharedPreferences.edit();
    }

    public String getUserName(){
       return sharedPreferences.getString(user, "");
    }

    public void setUserName(String userName){
        editor.putString(user,userName);
        editor.commit();
    }

    public void ClearSesion(){
        editor.clear();
        editor.commit();
    }
}
