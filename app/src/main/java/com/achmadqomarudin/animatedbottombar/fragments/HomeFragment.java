package com.achmadqomarudin.animatedbottombar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.SetgpsActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView settext_place;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        settext_place = v.findViewById(R.id.settext_place);

        Intent intent = getActivity().getIntent();
        if(intent.hasExtra("place")) {
            String name = intent.getExtras().getString("place");
            settext_place.setText(name);
        }
        return v;

    }

}

