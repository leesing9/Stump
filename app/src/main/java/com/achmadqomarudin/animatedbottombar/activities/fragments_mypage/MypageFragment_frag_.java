package com.achmadqomarudin.animatedbottombar.activities.fragments_mypage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.achmadqomarudin.animatedbottombar.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MypageFragment_frag_ extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mypage_frag3, container, false);
        return root;
    }
}