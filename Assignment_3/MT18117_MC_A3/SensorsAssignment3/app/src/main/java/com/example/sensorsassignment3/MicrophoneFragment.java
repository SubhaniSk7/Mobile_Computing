package com.example.sensorsassignment3;

import android.location.LocationManager;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MicrophoneFragment extends Fragment {
    private static final String TAG = "MicrophoneFragment";

    private static AudioRecord audioRecord;
    private static MediaRecorder mediaRecorder;
    private static int minBuffer;

    private Button btnSave;
    private static TextView sensorValue;

    public MicrophoneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_microphone, container, false);
        Log.d(TAG, "onCreate: Initializing Microphone Services.");

        return view;
    }
}
