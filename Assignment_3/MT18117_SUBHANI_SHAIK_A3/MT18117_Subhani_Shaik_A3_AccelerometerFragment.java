//MT18117_Subhani_Shaik_A3
// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v
//MT18117_Subhani_Shaik_A3
package com.example.sensorsassignment3.accelerometer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorsassignment3.R;
import com.example.sensorsassignment3.db.SensorDBHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccelerometerFragment extends Fragment implements SensorEventListener {
    private static final String TAG = "AccelerometerFragment";
    private static SensorManager sensorManager;
    private static Sensor accelerometer;

    private Button btnSave;
    private static TextView sensorValue;

    public AccelerometerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accelerometer, container, false);

        Log.d(TAG, "onCreate: Initializing Sensor Services.");
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

            Log.d(TAG, "onCreate: Registered Accelerometer Listener....");
        } else {
            Log.d(TAG, "do not have Accelerometer.....");
        }

        btnSave = view.findViewById(R.id.btn_accelerometer_save);
        sensorValue = view.findViewById(R.id.tv_accelerometer_readings);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = 1;
                String name = "Accelerometer";
                String values = sensorValue.getText().toString();

                SensorDBHelper sensorDBHelper = new SensorDBHelper(getActivity());

                SQLiteDatabase database = sensorDBHelper.getWritableDatabase();
                sensorDBHelper.addSensorData(id, name, values, database);
                sensorDBHelper.close();

                Toast.makeText(getActivity(), "Info saved successfully...." + values, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged:X:" + sensorEvent.values[0] + " Y:" + sensorEvent.values[1] + " Z:" + sensorEvent.values[2]);
        String value = "X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2];
        sensorValue.setText(value);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onStop() {

        super.onStop();
        sensorManager.unregisterListener(this, accelerometer);
    }
}
