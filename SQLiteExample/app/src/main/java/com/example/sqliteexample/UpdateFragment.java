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
public class UpdateFragment extends Fragment {

    private EditText updateId, updateName, updateContactNo, updateEmail;
    private Button btn_update;

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        updateId = view.findViewById(R.id.et_add_contact_id);
        updateName = view.findViewById(R.id.et_add_name);
        updateContactNo = view.findViewById(R.id.et_add_contact_no);
        updateEmail = view.findViewById(R.id.et_add_email);

        btn_update = view.findViewById(R.id.btn_add_save);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateContact();
            }
        });

        return view;
    }

    public void updateContact() {
        int id = Integer.parseInt(updateId.getText().toString());
        String name = updateName.getText().toString();
        String no = updateContactNo.getText().toString();
        String email = updateEmail.getText().toString();

        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());

        SQLiteDatabase database = contactDBHelper.getWritableDatabase();

        contactDBHelper.updateContact(id, name, no, email, database);

        contactDBHelper.close();

        Toast.makeText(getActivity(), "Contact updated..", Toast.LENGTH_SHORT).show();

        updateId.setText("");
        updateName.setText("");
        updateContactNo.setText("");
        updateEmail.setText("");
    }
}
