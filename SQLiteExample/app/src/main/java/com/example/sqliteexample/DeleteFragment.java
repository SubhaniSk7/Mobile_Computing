package com.example.sqliteexample;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteFragment extends Fragment {

    private EditText deleteId;
    private Button btn_delete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        deleteId = view.findViewById(R.id.et_add_contact_id);
        btn_delete = view.findViewById(R.id.btn_add_save);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteContact();
            }
        });

        return view;
    }

    public void deleteContact() {
        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());

        SQLiteDatabase database = contactDBHelper.getWritableDatabase();

        int id = Integer.parseInt(deleteId.getText().toString());

        contactDBHelper.deleteContact(id, database);
        contactDBHelper.close();

        deleteId.setText("");
        Toast.makeText(getActivity(), "Contact Deleted Successfully....", Toast.LENGTH_SHORT).show();
    }
}
