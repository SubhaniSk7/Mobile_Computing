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

/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {

    private Button btnSave;
    private EditText contactId, contactName, contactEmail, contactNo;

    public AddContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        btnSave = view.findViewById(R.id.btn_add_save);
        contactId = view.findViewById(R.id.et_add_contact_id);
        contactName = view.findViewById(R.id.et_add_name);
        contactEmail = view.findViewById(R.id.et_add_email);
        contactNo = view.findViewById(R.id.et_add_contact_no);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = contactId.getText().toString();
                String name = contactName.getText().toString();
                String email = contactEmail.getText().toString();
                String no = contactNo.getText().toString();

                ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());

                SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                contactDBHelper.addContact(Integer.parseInt(id), name, email, no, database);
                contactDBHelper.close();

                contactId.setText("");
                contactName.setText("");
                contactEmail.setText("");
                contactNo.setText("");

                Toast.makeText(getActivity(), "Contact saved successfully....", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
