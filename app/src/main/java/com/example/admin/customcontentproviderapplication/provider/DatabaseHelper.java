package com.example.admin.customcontentproviderapplication.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.admin.customcontentproviderapplication.model.Person;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "People.db";
    public static final String TABLE_NAME = "people";
    public static final String COL_ID = BaseColumns._ID;
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_LAST_NAME = "last_name";
    public static final String COL_AGE = "age";
    public static final String COL_ADDRESS = "address";
    public static final String COL_SSN = "ssn";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d(TAG, "constructor: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Called when the database is created for the first time
        Log.d(TAG, "onCreate: creating table.");

        String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "( " + "" +
                        COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COL_FIRST_NAME + " TEXT, " +
                        COL_LAST_NAME + " TEXT, " +
                        COL_AGE + " TEXT, " +
                        COL_ADDRESS + " TEXT, " +
                        COL_SSN + " TEXT " +
                        ");";

        sqLiteDatabase.execSQL( CREATE_TABLE );

        Log.d(TAG, "onCreate: Adding data.");

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Jarrett");
        contentValues.put(COL_LAST_NAME, "Adkins");
        contentValues.put(COL_AGE, "27");
        contentValues.put(COL_ADDRESS, "2034 Palace Dr, Smyrna, GA 30080, USA");
        contentValues.put(COL_SSN, "000000000");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Jason");
        contentValues.put(COL_LAST_NAME, "Gomez");
        contentValues.put(COL_AGE, "25");
        contentValues.put(COL_ADDRESS, "2034 Palace Dr, Smyrna, GA 30080, USA");
        contentValues.put(COL_SSN, "111111111");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Ryne");
        contentValues.put(COL_LAST_NAME, "Green");
        contentValues.put(COL_AGE, "29");
        contentValues.put(COL_ADDRESS, "2034 Palace Dr, Smyrna, GA 30080, USA");
        contentValues.put(COL_SSN, "222222222");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Mac");
        contentValues.put(COL_LAST_NAME, "Myers");
        contentValues.put(COL_AGE, "24");
        contentValues.put(COL_ADDRESS, "2034 Palace Dr, Smyrna, GA 30080, USA");
        contentValues.put(COL_SSN, "333333333");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Joe");
        contentValues.put(COL_LAST_NAME, "Casal");
        contentValues.put(COL_AGE, "25");
        contentValues.put(COL_ADDRESS, "2034 Palace Dr, Smyrna, GA 30080, USA");
        contentValues.put(COL_SSN, "444444444");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "John");
        contentValues.put(COL_LAST_NAME, "Doe");
        contentValues.put(COL_AGE, "35");
        contentValues.put(COL_ADDRESS, "New York");
        contentValues.put(COL_SSN, "555555555");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Morgan");
        contentValues.put(COL_LAST_NAME, "Freeman");
        contentValues.put(COL_AGE, "80");
        contentValues.put(COL_ADDRESS, "Hollywood");
        contentValues.put(COL_SSN, "666666666");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Troy");
        contentValues.put(COL_LAST_NAME, "Dorsey");
        contentValues.put(COL_AGE, "27");
        contentValues.put(COL_ADDRESS, "???");
        contentValues.put(COL_SSN, "777777777");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Vinny");
        contentValues.put(COL_LAST_NAME, "Pizzapasta");
        contentValues.put(COL_AGE, "31");
        contentValues.put(COL_ADDRESS, "New York");
        contentValues.put(COL_SSN, "888888888");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, "Tony");
        contentValues.put(COL_LAST_NAME, "Soprano");
        contentValues.put(COL_AGE, "45");
        contentValues.put(COL_ADDRESS, "Jersey");
        contentValues.put(COL_SSN, "999999999");
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        Log.d(TAG, "onCreate: Data added.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //called when version number is changed. Like if you edit the class to have a diff schema,
        //change version num to 2.

        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate( sqLiteDatabase );
    }

    public List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(QUERY, null);

        if (cursor.moveToFirst()) {
            do {
                Person person = new Person(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getInt(5));

                personList.add(person);
            } while (cursor.moveToNext());
        }

        return personList;
    }
}
