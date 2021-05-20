package com.achmadqomarudin.animatedbottombar.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.achmadqomarudin.animatedbottombar.KakaoUser;
import com.achmadqomarudin.animatedbottombar.R;
import com.bumptech.glide.Glide;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MypageFragment extends Fragment {

    ImageView myprofile;
    TextView mynickname;
    TextView myplace;
    public MypageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mypage, container, false);



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
