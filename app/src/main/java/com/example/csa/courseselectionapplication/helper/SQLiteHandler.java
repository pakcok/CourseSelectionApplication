package com.example.csa.courseselectionapplication.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.database.sqlite.SQLiteDatabase.CONFLICT_REPLACE;
import android.util.Log;

import java.util.HashMap;

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "schooldb-api";

    // Login table name
    private static final String TABLE_USER = "students";
    private static final String TABLE_USER_RECORDS = "student_records";

    // Login Table Columns names
    private static final String KEY_STUDENT_ID = "student_id";
    private static final String KEY_USER = "username";
    //private static final String KEY_EMAIL = "email";
    private static final String KEY_ID = "id";

    private static final String KEY_COURSE_ID = "course_id";
    private static final String KEY_UNIT = "unit";
    private static final String KEY_GRADE = "grade";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_STUDENT_ID + " INTEGER PRIMARY KEY,"
                + KEY_USER + " TEXT,"
                + KEY_ID + " TEXT" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);

        String CREATE_GPA_TABLE = "CREATE TABLE " + TABLE_USER_RECORDS + "("
                + KEY_STUDENT_ID + " INTEGER PRIMARY KEY,"
                + KEY_COURSE_ID + " TEXT,"
                + KEY_UNIT + " TEXT,"
                + KEY_GRADE + " TEXT" + ")";
        db.execSQL(CREATE_GPA_TABLE);

        Log.d(TAG, "Database tables created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String username, String student_id, String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STUDENT_ID, student_id); // Student ID
        values.put(KEY_USER, username); // User Name
        values.put(KEY_ID, id); // ID

        // Inserting Row
        long numberid = db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + numberid);
    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails(String student_id) {
        HashMap<String, String> student = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_USER + " WHERE student_id =" + student_id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            student.put("student_id", cursor.getString(0));
            student.put("username", cursor.getString(1));
            student.put("id", cursor.getString(2));

        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + student.toString());

        return student;
    }

    /*
    public HashMap<String, String> getGPA(String student_id) {
        HashMap<String, String> student_GPA = new HashMap<String, String>();
        String selectQuery = "SELECT student_id, SUM(grade) AS 'sumGrade FROM' " + TABLE_USER_RECORDS + " WHERE student_id =" + student_id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            student_GPA.put("student_id", cursor.getString(0));
            //student.put("course_id", cursor.getString(1));
            //student.put("sumUnit", cursor.getString(0));
            student_GPA.put("sumGrade", cursor.getString(1));
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + student_GPA.toString());

        return student_GPA;
    }
    */

    /**
     * Re crate database Delete all tables and create them again
     * */
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_USER, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }

}
