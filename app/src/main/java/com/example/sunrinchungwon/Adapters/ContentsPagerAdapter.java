package com.example.sunrinchungwon.Adapters;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentStatePagerAdapter;


import com.example.sunrinchungwon.Fragments.Example2Fragment;
import com.example.sunrinchungwon.Fragments.Example3Fragment;
import com.example.sunrinchungwon.Fragments.Example4Fragment;
import com.example.sunrinchungwon.Fragments.Example5Fragment;
import com.example.sunrinchungwon.Fragments.ExampleFragment;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;



    public ContentsPagerAdapter(FragmentManager fm, int pageCount) {

        super(fm);

        this.mPageCount = pageCount;

    }

    @Override

    public Fragment getItem(int position) {

        switch (position) {

            case 0:

                ExampleFragment exampleFragment = new ExampleFragment();

                return exampleFragment;
            case 1:

                Example2Fragment example2Fragment = new Example2Fragment();

                return example2Fragment;



            case 2:

                Example3Fragment example3Fragment = new Example3Fragment();

                return example3Fragment;



            case 3:

                Example4Fragment example4Fragment = new Example4Fragment();

                return example4Fragment;



            case 4:

                Example5Fragment example5Fragment = new Example5Fragment();

                return example5Fragment;



            default:

                return null;

        }

    }



    @Override

    public int getCount() {
        return mPageCount;
    }

}