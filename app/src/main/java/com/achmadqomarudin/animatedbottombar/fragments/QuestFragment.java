package com.achmadqomarudin.animatedbottombar.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.fragments_mypage.SectionsPagerAdapter;
import com.achmadqomarudin.animatedbottombar.activities.fragments_questtheme.SectionsPagerAdapter_questtheme;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestFragment extends Fragment {

    public QuestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_quest, container, false);

        SectionsPagerAdapter_questtheme sectionsPagerAdapter = new SectionsPagerAdapter_questtheme(this, getActivity().getSupportFragmentManager());
        ViewPager viewPager = v.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        return v;
    }

}
