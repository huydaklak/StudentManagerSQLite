package com.example.myapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.model.ClassModel;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "school.db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createClass = "CREATE TABLE " + DbContract.TABLE_CLASS + " ("
                + DbContract.CLASS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DbContract.CLASS_CODE + " TEXT UNIQUE, "
                + DbContract.CLASS_NAME + " TEXT)";

        String createStudent = "CREATE TABLE " + DbContract.TABLE_STUDENT + " ("
                + DbContract.STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DbContract.STUDENT_CODE + " TEXT UNIQUE, "
                + DbContract.STUDENT_NAME + " TEXT, "
                + DbContract.STUDENT_IMG + " TEXT, "
                + DbContract.STUDENT_CLASS_ID + " INTEGER, "
                + " FOREIGN KEY( " + DbContract.STUDENT_CLASS_ID + ") REFERENCES "
                + DbContract.TABLE_CLASS + "(" + DbContract.CLASS_ID + "))";

        db.execSQL(createClass);
        db.execSQL(createStudent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<ClassModel> getAllClass() {
        List<ClassModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DbContract.TABLE_CLASS, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            ClassModel cl = new ClassModel();

            cl.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DbContract.CLASS_ID)));
            cl.setCode(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.CLASS_CODE)));
            cl.setName(cursor.getString(cursor.getColumnIndexOrThrow(DbContract.CLASS_NAME)));

            list.add(cl);
        }
        cursor.close();
        return list;
    }
}
