// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v

package com.example.contactslistassignment2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ContactsDBHelper extends SQLiteOpenHelper {
    private static final int REQUEST_WRITE_PERMISSION = 786;

    public static final String DATABASE_NAME = "contacts_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TAG = "ContactsDBHelper";
    public static final String CREATE_TABLE = "create table " + ContactsDBContract.ContactEntry.TABLE_NAME +
            "(" + ContactsDBContract.ContactEntry.CONTACT_ID + " number," + ContactsDBContract.ContactEntry.CONTACT_NAME + " text,"
            + ContactsDBContract.ContactEntry.CONTACTS_VALUE + " text);";

    public static final String DROP_TABLE = "drop table if exists " + ContactsDBContract.ContactEntry.TABLE_NAME;

    public ContactsDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "Database created....");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "Table created..");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        Log.d("Database Operations", "Table Dropped..");
        onCreate(sqLiteDatabase);
    }

    public void addContactData(int id, String name, String value, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactsDBContract.ContactEntry.CONTACT_ID, id);
        contentValues.put(ContactsDBContract.ContactEntry.CONTACT_NAME, name);
        contentValues.put(ContactsDBContract.ContactEntry.CONTACTS_VALUE, value);

        Log.d("insertion:", id + "--" + name + "--" + value);
        database.insert(ContactsDBContract.ContactEntry.TABLE_NAME, null, contentValues);

        Log.d("Database Operations", "Record Inserted....");
    }

    public Cursor readContactData(SQLiteDatabase database) {
        String[] projections = {ContactsDBContract.ContactEntry.CONTACT_ID, ContactsDBContract.ContactEntry.CONTACT_NAME,
                ContactsDBContract.ContactEntry.CONTACTS_VALUE};

        Cursor cursor = database.query(ContactsDBContract.ContactEntry.TABLE_NAME,
                projections, null, null, null, null, null);
        Log.d("readSensorData", "fetching database");
        if (cursor == null)
            Log.d("readSensorData", "cursor is null..");
        else
            Log.d("readSensorData", "cursor is not null..");
        return cursor;
    }
}
