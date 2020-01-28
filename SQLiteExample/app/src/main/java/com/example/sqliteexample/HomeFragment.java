package com.example.sqliteexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnSave, btnView, btnUpdate, btnDelete;

    OnDbOpListener onDbOpListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListener {
        public void dBOpPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnSave = view.findViewById(R.id.btn_home_add_contact);
        btnSave.setOnClickListener(this);

        btnView = view.findViewById(R.id.btn_home_view_contacts);
        btnView.setOnClickListener(this);

        btnUpdate = view.findViewById(R.id.btn_home_update_contact);
        btnUpdate.setOnClickListener(this);

        btnDelete = view.findViewById(R.id.btn_home_delete_contact);
        btnDelete.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_home_add_contact:
                onDbOpListener.dBOpPerformed(0);
                break;
            case R.id.btn_home_view_contacts:
                onDbOpListener.dBOpPerformed(1);
                break;
            case R.id.btn_home_update_contact:
                onDbOpListener.dBOpPerformed(2);
                break;
            case R.id.btn_home_delete_contact:
                onDbOpListener.dBOpPerformed(3);
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
