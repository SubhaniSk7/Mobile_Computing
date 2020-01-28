package com.example.sensorsassignment3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class SensorFragment extends Fragment implements View.OnClickListener {

    private Button btnAccelerometer, btnGPS, btnWiFi, btnMicrophone, btnShowSaved, btnExport;

    OnDbOpListener onDbOpListener;

    public SensorFragment() {
    }

    public interface OnDbOpListener {
        public void dBOpPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sensor, container, false);

        btnAccelerometer = view.findViewById(R.id.btn_sensor_accelerometer);
        btnAccelerometer.setOnClickListener(this);

        btnGPS = view.findViewById(R.id.btn_sensor_gps);
        btnGPS.setOnClickListener(this);

        btnWiFi = view.findViewById(R.id.btn_sensor_wifi);
        btnWiFi.setOnClickListener(this);

        btnMicrophone = view.findViewById(R.id.btn_sensor_microphone);
        btnMicrophone.setOnClickListener(this);

        btnShowSaved = view.findViewById(R.id.btn_sensor_view_saved_info);
        btnShowSaved.setOnClickListener(this);

        btnExport = view.findViewById(R.id.btn_sensor_export);
        btnExport.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sensor_accelerometer:
                onDbOpListener.dBOpPerformed(0);
                break;
            case R.id.btn_sensor_gps:
                onDbOpListener.dBOpPerformed(1);
                break;
            case R.id.btn_sensor_wifi:
                onDbOpListener.dBOpPerformed(2);
                break;
            case R.id.btn_sensor_microphone:
                onDbOpListener.dBOpPerformed(3);
                break;

            case R.id.btn_sensor_view_saved_info:
                onDbOpListener.dBOpPerformed(4);
                break;
            case R.id.btn_sensor_export:
                onDbOpListener.dBOpPerformed(5);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {
            onDbOpListener = (OnDbOpListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement the OnDbOpListener interface method");
        }
    }
}
