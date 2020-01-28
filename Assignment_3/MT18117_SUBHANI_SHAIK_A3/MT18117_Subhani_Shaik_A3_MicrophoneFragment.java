// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v
//MT18117_Subhani_Shaik_A3
package com.example.sensorsassignment3.microphone;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorsassignment3.R;
import com.example.sensorsassignment3.db.SensorDBHelper;

import java.io.IOException;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class MicrophoneFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "MicrophoneFragment";

    String savePath = "";

    private Button btnSave;
    private static TextView sensorValue;

    private static MediaRecorder mediaRecorder;

    public MicrophoneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_microphone, container, false);
        Log.d(TAG, "onCreate: Initializing Microphone Services.");

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(getActivity(), "Please Grant Permissions", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.RECORD_AUDIO}, 100);
        }
        int permissionCheckStorage = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheckStorage == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getActivity(), "Have storage Permissions", Toast.LENGTH_SHORT).show();
        } else {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            Toast.makeText(getActivity(), "please grant storage permissions...", Toast.LENGTH_SHORT).show();
        }

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        savePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/assignment3.3gp";

        mediaRecorder.setOutputFile(savePath);
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnSave = view.findViewById(R.id.btn_microphone_save);
        sensorValue = view.findViewById(R.id.tv_microphone_readings);

        sensorValue.setText("Recording..Save to stop");

        btnSave.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
        sensorValue.setText("saved");
        Toast.makeText(getActivity(), "Audio saved successfully to assignment3.3gp....", Toast.LENGTH_SHORT).show();
    }

    public void start() {

    }
}
