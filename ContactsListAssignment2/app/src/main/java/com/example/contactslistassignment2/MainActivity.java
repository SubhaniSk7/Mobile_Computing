package com.example.contactslistassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.contactslistassignment2.fragments.ContactsFragment;
import com.example.contactslistassignment2.fragments.SavedFragment;
import com.example.contactslistassignment2.viewpager.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 50;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactsFragment contactsFragment = new ContactsFragment();
        SavedFragment savedFragment = new SavedFragment(); // can add Bundle arguments to these fragments.

        tabLayout = findViewById(R.id.main_tablayout);
        viewPager = findViewById(R.id.main_viewpager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(contactsFragment, "Contacts");
        viewPagerAdapter.addFragment(savedFragment, "Saved Contacts");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        getPermissions();
    }

    public void getPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getApplication().getApplicationContext().checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);

            Log.d(TAG, "in RequestContacts");
        } else {
//            showContacts();
            Toast.makeText(getApplication().getApplicationContext(), "Have Permissions", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "have permissions");
        }
    }
}
