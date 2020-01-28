// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v
//MT18117_Subhani_Shaik_A3
package com.example.sensorsassignment3.gps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
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
public class GpsFragment extends Fragment implements LocationListener, View.OnClickListener {
    private static final String TAG = "GpsFragment";

    public static LocationManager locationManager;
    private Button btnSave;
    private static TextView sensorValue;

    public GpsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gps, container, false);
        Log.d(TAG, "onCreate: Initializing Location Services.");

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getActivity(), "Please Grant Permissions", Toast.LENGTH_SHORT).show();
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSEnabled) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10, this);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            btnSave = view.findViewById(R.id.btn_gps_save);
            sensorValue = view.findViewById(R.id.tv_gps_readings);

            onLocationChanged(location);
        } else {
            Toast.makeText(getActivity(), "please enable GPS", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    @Override
    public void onLocationChanged(Location location) {

        sensorValue.setText(location.toString());
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onClick(View view) {
        int id = 2;
        String name = "GPS";
        String values = sensorValue.getText().toString();
        SensorDBHelper sensorDBHelper = new SensorDBHelper(getActivity());

        SQLiteDatabase database = sensorDBHelper.getWritableDatabase();
        sensorDBHelper.addSensorData(id, name, values, database);
        sensorDBHelper.close();
        Toast.makeText(getActivity(), "Info saved successfully...." + values, Toast.LENGTH_SHORT).show();
    }
}
