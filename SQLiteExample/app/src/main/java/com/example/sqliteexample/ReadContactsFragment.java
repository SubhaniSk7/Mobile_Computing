package com.example.sqliteexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactsFragment extends Fragment {

    private TextView tv;

    public ReadContactsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_contacts, container, false);

        tv = view.findViewById(R.id.tv_read_contacts);

        readContacts();
        return view;
    }

    private void readContacts() {

        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
        SQLiteDatabase database = contactDBHelper.getReadableDatabase();

        Cursor cursor = contactDBHelper.readContacts(database);
        String info = "";

        while (cursor.moveToNext()) {

            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String no = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_NO));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));

            info = info + "\n\nId: " + id + "\nName: " + name + "\nNumber: " + no + "\nEmail: " + email;
        }

        tv.setText(info);
        contactDBHelper.close();
    }
}
