package com.example.viewpagerswipeviewsexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerFragmentCollectionAdapter extends FragmentStatePagerAdapter {
    public PagerFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        PagerFragment pagerFragment = new PagerFragment();
        Bundle bundle = new Bundle();
        position = position + 1;

        bundle.putString("message", "Contact name :" + position);
        pagerFragment.setArguments(bundle);

        return pagerFragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
