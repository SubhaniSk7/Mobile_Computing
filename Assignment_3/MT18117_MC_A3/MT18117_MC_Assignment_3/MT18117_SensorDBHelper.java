// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v

package com.example.sensorsassignment3;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class SensorDBHelper extends SQLiteOpenHelper {
    private static final int REQUEST_WRITE_PERMISSION = 786;

    public static final String DATABASE_NAME = "sensors_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TAG = "SensorDBHelper";
    public static final String CREATE_TABLE = "create table " + SensorContract.SensorEntry.TABLE_NAME +
            "(" + SensorContract.SensorEntry.SENSOR_ID + " number," + SensorContract.SensorEntry.SENSOR_NAME + " text,"
            + SensorContract.SensorEntry.SENSOR_VALUE + " text);";

    public static final String DROP_TABLE = "drop table if exists " + SensorContract.SensorEntry.TABLE_NAME;

    public SensorDBHelper(@Nullable Context context) {
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

    public void addSensorData(int id, String name, String value, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(SensorContract.SensorEntry.SENSOR_ID, id);
        contentValues.put(SensorContract.SensorEntry.SENSOR_NAME, name);
        contentValues.put(SensorContract.SensorEntry.SENSOR_VALUE, value);

        Log.d("insertion:", id + "--" + name + "--" + value);
        database.insert(SensorContract.SensorEntry.TABLE_NAME, null, contentValues);

        Log.d("Database Operations", "Record Inserted....");
    }

    public Cursor readSensorData(SQLiteDatabase database) {
        String[] projections = {SensorContract.SensorEntry.SENSOR_ID, SensorContract.SensorEntry.SENSOR_NAME,
                SensorContract.SensorEntry.SENSOR_VALUE};

        Cursor cursor = database.query(SensorContract.SensorEntry.TABLE_NAME,
                projections, null, null, null, null, null);
        Log.d("readSensorData", "fetching database");
        if (cursor == null)
            Log.d("readSensorData", "cursor is null..");
        else
            Log.d("readSensorData", "cursor is not null..");
        return cursor;
    }

    // referred online resources and developer.android.com
    //https://stackoverflow.com/questions/35858981/read-and-write-permission-for-storage-and-gallery-usage-for-marshmallow
    //https://www.techrepublic.com/blog/software-engineer/export-sqlite-data-from-your-android-device/
    public void exportDB() {
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source = null;
        FileChannel destination = null;

        Log.d(TAG, sd.toString());
        Log.d(TAG, data.toString());
        String currentDBPath = "/data/com.example.sensorsassignment3/databases/" + SensorContract.SensorEntry.DB_NAME;
        String backupDBPath = SensorContract.SensorEntry.DB_NAME;

        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
//            Toast.makeText(, "DB Exported!", Toast.LENGTH_LONG).show();
            Log.d("ExportDB:", "Exporting....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
