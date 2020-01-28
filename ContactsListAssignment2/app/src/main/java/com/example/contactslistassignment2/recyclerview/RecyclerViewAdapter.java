package com.example.contactslistassignment2.recyclerview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactslistassignment2.R;
import com.example.contactslistassignment2.db.ContactsDBHelper;
import com.example.contactslistassignment2.vo.Contact_VO;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private final String TAG = "RecyclerViewAdapter";
    Context context;
    private List<Contact_VO> contactVoList;
    private static TextView contactName;
    private Button btnSave;

    public RecyclerViewAdapter(Context context, List<Contact_VO> contactVoList) {
        this.context = context;
        this.contactVoList = contactVoList;
        Log.d(TAG, "length" + contactVoList.size());
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_view_layout, parent, false);
        final ContactViewHolder contactViewHolder = new ContactViewHolder(view);

        btnSave = view.findViewById(R.id.btn_save_contact);
        contactName = view.findViewById(R.id.contact_name);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = contactViewHolder.getAdapterPosition();

                String name = contactVoList.get(contactViewHolder.getAdapterPosition()).getContact_name();
                String number = contactVoList.get(contactViewHolder.getAdapterPosition()).getContact_number();

                ContactsDBHelper sensorDBHelper = new ContactsDBHelper(context);
                SQLiteDatabase database = sensorDBHelper.getWritableDatabase();

                sensorDBHelper.addContactData(id, name, number, database);
                sensorDBHelper.close();

                Toast.makeText(context, name + " " + number, Toast.LENGTH_SHORT).show();
            }
        });

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Log.d(TAG, "========" + contactVoList.size());
        holder.name.setText(contactVoList.get(position).getContact_name());
        holder.number.setText(contactVoList.get(position).getContact_number());
//        holder.image.setImageResource(contactVoList.get(position).getProfilePic());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "get item count length" + contactVoList.size());
        return contactVoList.size();
    }

//    @Override
//    public void onClick(View view) {
//        int id = 1;
//        String name = "Accelerometer";
//        String values = contactName.getText().toString();
//
////        ContactsDBHelper sensorDBHelper = new ContactsDBHelper(getActivity());
////
////        SQLiteDatabase database = sensorDBHelper.getWritableDatabase();
////        sensorDBHelper.addContactData(id, name, values, database);
////        sensorDBHelper.close();
//
//        Toast.makeText(context, "Info saved successfully...." + String.valueOf(), Toast.LENGTH_SHORT).show();
//    }
}
