package com.example.sensorsassignment3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowSensorInfoFragment extends Fragment {
    private TextView tv;

    public ShowSensorInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_sensor_info, container, false);

        tv = view.findViewById(R.id.tv_read_sensor_info);
        readSavedInfo();
        return view;
    }

    private void readSavedInfo() {

        Log.d("readSavedInfo", "in read saved info....");
        SensorDBHelper sensorDBHelper = new SensorDBHelper(getActivity());
        SQLiteDatabase database = sensorDBHelper.getReadableDatabase();

        Cursor cursor = sensorDBHelper.readSensorData(database);

        if (cursor == null)
            Log.d("readSavedInfo", "cursor is null..");
        else
            Log.d("readSavedInfo", "cursor is not null..");

        String info = "";
        Log.d("Saved Info", info);
        while (cursor.moveToNext()) {

            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(SensorContract.SensorEntry.SENSOR_ID)));
            Log.d("readSavedInfo cursor", id);
            String name = cursor.getString(cursor.getColumnIndex(SensorContract.SensorEntry.SENSOR_NAME));
            Log.d("readSavedInfo cursor", name);
            String value = cursor.getString(cursor.getColumnIndex(SensorContract.SensorEntry.SENSOR_VALUE));
            Log.d("readSavedInfo cursor", value);
            info = info + "\n\nId: " + id + "\nName: " + name + "\nValue: " + value;
        }

        tv.setText(info);
        sensorDBHelper.close();
    }
}
