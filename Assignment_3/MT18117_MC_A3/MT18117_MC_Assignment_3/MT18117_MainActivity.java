// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v

package com.example.sensorsassignment3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorFragment.OnDbOpListener {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            SensorFragment sensorFragment = new SensorFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, sensorFragment, null);
            fragmentTransaction.commit();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void dBOpPerformed(int method) {
        switch (method) {

            case 0:
                AccelerometerFragment accelerometerFragment = new AccelerometerFragment();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, accelerometerFragment, null);
                fragmentTransaction.addToBackStack(null).commit();
                break;
            case 1:
                GpsFragment gpsFragment = new GpsFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, gpsFragment, null)
                        .addToBackStack(null).commit();
                break;
            case 2:
                WiFiFragment wiFiFragment = new WiFiFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, wiFiFragment, null)
                        .addToBackStack(null).commit();
                break;
            case 3:
                MicrophoneFragment microphoneFragment = new MicrophoneFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, microphoneFragment, null)
                        .addToBackStack(null).commit();
                break;
            case 4:
                ShowSensorInfoFragment showSensorInfoFragment = new ShowSensorInfoFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, showSensorInfoFragment, null)
                        .addToBackStack(null).commit();
                break;
            case 5:
                SensorDBHelper sensorDBHelper = new SensorDBHelper(this);

                int permissionCheckStorage = ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);

                // we already asked for permisson & Permission granted, call camera intent
                if (permissionCheckStorage == PackageManager.PERMISSION_GRANTED) {

                    //do what you want
                    Toast.makeText(this, "Have Permissions", Toast.LENGTH_SHORT).show();
                } else {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    Toast.makeText(this, "please grant permissions...", Toast.LENGTH_SHORT).show();
                }
                sensorDBHelper.exportDB();
                Log.d(TAG, "case 5");
                Toast.makeText(this, "exporting...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
