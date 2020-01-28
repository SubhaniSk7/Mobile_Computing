package com.example.contactslistassignment2.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactslistassignment2.R;

import java.util.List;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout contactItem;
    public TextView name;
    public TextView number;
    public ImageView image;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);

        contactItem = itemView.findViewById(R.id.contact_item);
        name = itemView.findViewById(R.id.contact_name);
        number = itemView.findViewById(R.id.contact_no);
        image = itemView.findViewById(R.id.contact_img);
    }
}
