// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v

package com.example.sensorsassignment3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class WiFiFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "WiFiFragment";
    private static WifiManager wifiManager;

    private static ConnectivityManager connectivityManager;

    private Button btnSave;
    private static TextView sensorValue;

    public WiFiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wi_fi, container, false);
        Log.d(TAG, "onCreate: Initializing Wifi Services.");
        ConnectivityManager connManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (networkInfo.isConnected()) {
            wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);

            if (wifiManager.isWifiEnabled()) {

                Log.d(TAG, "wifi checking");

                WifiInfo wifiInfo = wifiManager.getConnectionInfo();

                if (String.valueOf(wifiInfo.getSupplicantState()).equals("COMPLETED")) {
                    Log.d(TAG, "wifi apn ssid:" + wifiInfo.getSSID());
                    Log.d(TAG, "wifi apn extraInfo:" + networkInfo.getExtraInfo());
                    Log.d(TAG, "wifi apn" + networkInfo.getState());

                    Toast.makeText(getActivity(), networkInfo.getExtraInfo() + " " + networkInfo.getState(), Toast.LENGTH_SHORT).show();

                    btnSave = view.findViewById(R.id.btn_wifi_save);
                    sensorValue = view.findViewById(R.id.tv_wifi_readings);

                    sensorValue.setText("AP:" + networkInfo.getExtraInfo() + "\nStatus:" + networkInfo.getState() + "\nStrength:" + wifiInfo.getRssi());

                    btnSave.setOnClickListener(this);
//
                } else {
                    Toast.makeText(getActivity(), "Please Connect to Wifi", Toast.LENGTH_SHORT).show();
                }
            } else {
                wifiManager.setWifiEnabled(true);
            }
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = 3;
        String name = "WiFi";
        String values = sensorValue.getText().toString();

        SensorDBHelper sensorDBHelper = new SensorDBHelper(getActivity());

        SQLiteDatabase database = sensorDBHelper.getWritableDatabase();
        sensorDBHelper.addSensorData(id, name, values, database);
        sensorDBHelper.close();
        Toast.makeText(getActivity(), "Info saved successfully...." + values, Toast.LENGTH_SHORT).show();
    }
}
