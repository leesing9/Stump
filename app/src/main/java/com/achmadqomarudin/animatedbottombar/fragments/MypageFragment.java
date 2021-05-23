package com.achmadqomarudin.animatedbottombar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.achmadqomarudin.animatedbottombar.KakaoUser;
import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.fragments_mypage.SectionsPagerAdapter;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class MypageFragment extends Fragment {

    ImageView myprofile;
    TextView mynickname;
    TextView myplace;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mypage, container, false);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getActivity().getSupportFragmentManager());
        ViewPager viewPager = v.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = v.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        myprofile = v.findViewById(R.id.myprofile);
        mynickname = v.findViewById(R.id.mynickname);
        myplace = v.findViewById(R.id.myplace);


        mynickname.setText(KakaoUser.nickname);
        if(KakaoUser.profile!=null) {
            Glide.with(this).load(KakaoUser.profile).into(myprofile);
        }
        if(KakaoUser.myplace!=null) {
            myplace.setText(KakaoUser.myplace);
        }


        return v;
}
}