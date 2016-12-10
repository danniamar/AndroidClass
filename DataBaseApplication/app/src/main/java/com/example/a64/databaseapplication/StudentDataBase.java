package com.example.a64.databaseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 64 on 10/12/2016.
 */

public class StudentDataBase extends SQLiteOpenHelper {

    private SQLiteDatabase Database;
    private static final String COLUMN_ID ="_id";
    public static final String COLUMN_NAME ="_name";
    public static final String COLUMN_CARRER ="_carrer";
    private static final String COLUMN_TELEFONO ="_phone";
    private static final String TABLE_NAME ="students";

    private Context context;
    private String[] cols = {COLUMN_ID, COLUMN_NAME, COLUMN_CARRER, COLUMN_TELEFONO};

    public StudentDataBase(Context context) {
        super(context, "University", null, 1);
        this.context=context;
    }

    public void openConnection(){
        Database = getWritableDatabase();
    }

    public void create(Student student){
        ContentValues CV = new ContentValues();
        CV.put(COLUMN_NAME, student.getNombre());
        CV.put(COLUMN_CARRER, student.getTelefono());
        CV.put(COLUMN_TELEFONO, student.getCarrera());
        Database.insert(TABLE_NAME, null, CV);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " Interger PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_TELEFONO + " TEXT,"
                + COLUMN_CARRER + " TEXT"
                + ")";

        db.execSQL(query);

        fillDataBase(db);
    }

    private void fillDataBase(SQLiteDatabase db) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Juan Perez", "154879", "Ing. Sistemas"));
        studentArrayList.add(new Student("Daniel Asprilla", "23598", "Ing. Mecanica"));
        studentArrayList.add(new Student("Marco Espriella", "985245", "Ing. Electronica"));
        studentArrayList.add(new Student("Luis Gutierrez", "9632585", "Ing. Sistemas"));
        studentArrayList.add(new Student("Camilo Garcia", "741258", "Ing. Civil"));

        for (Student student: studentArrayList){
            ContentValues CV = new ContentValues();
            CV.put(COLUMN_NAME, student.getNombre());
            CV.put(COLUMN_CARRER, student.getTelefono());
            CV.put(COLUMN_TELEFONO, student.getCarrera());
            db.insert(TABLE_NAME, null, CV);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAll() {
        return Database.query(TABLE_NAME, cols, null,null,null,null,null);
    }

    public Cursor getByCarrer(String career) {
        String query = "Select * from students where _carrer like ' "  + career + "'";
        return Database.rawQuery(query, null);
    }
}
