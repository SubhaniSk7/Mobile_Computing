package com.example.fragments_classwork;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Fragment1_onCreate", "Fragment 1 onCreate running..");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Fragment1_onCreateView", "Fragment 1 onCreateView running..");
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment1_onActCreate", "Fragment 1 onActivityCreated running..");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment1_onStart", "Fragment 1 onStart running..");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment1_onResume", "Fragment 1 onResume running..");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment1_onPause", "Fragment 1 onPause running..");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment1_onDestroyView", "Fragment 1 onDestroyView running..");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment1_onDestroy", "Fragment 1 onDestroy running..");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment1_onStop", "Fragment 1 onStop running..");
    }

    @Override
    public void onAttach(Context context) {
        Log.d("Fragment1_onAttach", "Fragment 1 onAttach running..");
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Log.d("Fragment1_onDetach", "Fragment 1 onDetach running..");
        super.onDetach();
    }
}
