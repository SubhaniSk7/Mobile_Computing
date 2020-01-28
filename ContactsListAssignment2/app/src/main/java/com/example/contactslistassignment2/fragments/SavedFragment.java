package com.example.contactslistassignment2.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.contactslistassignment2.R;
import com.example.contactslistassignment2.db.ContactsDBContract;
import com.example.contactslistassignment2.db.ContactsDBHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedFragment extends Fragment {
    private TextView tv;

    public SavedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
        tv = view.findViewById(R.id.tv_read_contact_info);
        readSavedInfo();
        return view;
    }

    public void onResume() {

        super.onResume();
        Log.d("Resume","on Resume...");
        readSavedInfo();
    }

    private void readSavedInfo() {

        Log.d("readSavedInfo", "in read saved info....");
        ContactsDBHelper sensorDBHelper = new ContactsDBHelper(getContext());
        SQLiteDatabase database = sensorDBHelper.getReadableDatabase();

        Cursor cursor = sensorDBHelper.readContactData(database);

        if (cursor == null)
            Log.d("readSavedInfo", "cursor is null..");
        else
            Log.d("readSavedInfo", "cursor is not null..");

        String info = "";
        Log.d("Saved Info", info);
        while (cursor.moveToNext()) {

            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactsDBContract.ContactEntry.CONTACT_ID)));
            Log.d("readSavedInfo cursor", id);
            String name = cursor.getString(cursor.getColumnIndex(ContactsDBContract.ContactEntry.CONTACT_NAME));
            Log.d("readSavedInfo cursor", name);
            String value = cursor.getString(cursor.getColumnIndex(ContactsDBContract.ContactEntry.CONTACTS_VALUE));
            Log.d("readSavedInfo cursor", value);
            info = info + "\n\nId: " + id + "\nName: " + name + "\nValue: " + value;
        }

        tv.setText(info);
        sensorDBHelper.close();
    }
}
