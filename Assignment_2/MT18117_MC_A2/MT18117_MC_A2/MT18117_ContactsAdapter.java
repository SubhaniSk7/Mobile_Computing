// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v
package com.example.subhani.ui;

import android.content.ContentUris;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.subhani.R;
import com.example.subhani.models.Contact;

public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private Cursor mCursor;
    private final int mNameColIdx, mIdColIdx;

    public ContactsAdapter(Cursor cursor) {
        mCursor = cursor;
        mNameColIdx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        mIdColIdx = cursor.getColumnIndex(ContactsContract.Contacts._ID);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        String contactName = mCursor.getString(mNameColIdx);
        long contactId = mCursor.getLong(mIdColIdx);
        String hasPhone = mCursor.getString(mCursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

        Contact c = new Contact();
        c.name = contactName;
        c.profilePic = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId);
        if (hasPhone.equalsIgnoreCase("1")) {
            c.mobileNumber = mCursor.getString(mCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        }

        holder.bind(c);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}
