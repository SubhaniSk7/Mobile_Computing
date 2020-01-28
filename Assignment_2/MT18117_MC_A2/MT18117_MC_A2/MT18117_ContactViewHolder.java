// Referred developers.android.com and online tutorials
//https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v
package com.example.subhani.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.subhani.R;
import com.example.subhani.models.Contact;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private ImageView mProfileImage;
    private TextView mName, mMobile;
    private Contact mBoundContact;

    public ContactViewHolder(final View itemView) {
        super(itemView);
        mProfileImage = (ImageView) itemView.findViewById(R.id.profile_image);
        mName = (TextView) itemView.findViewById(R.id.tv_name);
        mMobile = (TextView) itemView.findViewById(R.id.tv_mobile);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBoundContact != null) {
                    Toast.makeText(itemView.getContext(), "Hi, I am " + mBoundContact.name, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void bind(Contact contact) {
        System.out.println("contact: " + contact);
        mBoundContact = contact;
        mName.setText(contact.name);
        mMobile.setText(contact.mobileNumber);
    }
}
