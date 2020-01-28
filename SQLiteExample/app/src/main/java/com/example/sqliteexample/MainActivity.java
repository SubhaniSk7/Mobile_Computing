package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            HomeFragment homeFragment = new HomeFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, homeFragment, null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void dBOpPerformed(int method) {
        switch (method) {

            case 0:
                AddContactFragment addContactFragment = new AddContactFragment();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, addContactFragment, null);
                fragmentTransaction.addToBackStack(null).commit();
                break;
            case 1:
                ReadContactsFragment readContactsFragment = new ReadContactsFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, readContactsFragment, null)
                        .addToBackStack(null).commit();
                break;
            case 2:
                UpdateFragment updateFragment = new UpdateFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, updateFragment, null)
                        .addToBackStack(null).commit();
                break;
            case 3:
                DeleteFragment deleteFragment = new DeleteFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, deleteFragment, null)
                        .addToBackStack(null).commit();
                break;
        }
    }
}
