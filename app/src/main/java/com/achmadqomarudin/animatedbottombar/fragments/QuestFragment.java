package com.achmadqomarudin.animatedbottombar.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.achmadqomarudin.animatedbottombar.R;


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
        return inflater.inflate(R.layout.fragment_quest, container, false);
    }
}
