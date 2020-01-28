package com.example.contactslistassignment2.fragments;

import android.content.ContentUris;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contactslistassignment2.R;
import com.example.contactslistassignment2.db.ContactsDBHelper;
import com.example.contactslistassignment2.recyclerview.RecyclerViewAdapter;
import com.example.contactslistassignment2.vo.Contact_VO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {
    private final String TAG = "ContactsFragment";

    private Cursor cursor;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private static List<Contact_VO> contactVoList = new ArrayList<>();

    public ContactsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.contacts_recyclerview);
        contactVoList = requestContacts();

        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), contactVoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    public List<Contact_VO> requestContacts() {
        List<Contact_VO> list = new ArrayList<>();

        Uri contentUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        cursor = getContext().getContentResolver().query(contentUri, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            long contactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String hasPhone = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

            String contactNumber = "";
            Uri profilePic = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId);

            if (hasPhone.equalsIgnoreCase("1")) {
                contactNumber = contactNumber + cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }
            Contact_VO contact_vo = new Contact_VO(contactName, contactNumber, profilePic);
            Log.d(TAG, contactName);

            list.add(contact_vo);
        }
        return list;
    }
}
