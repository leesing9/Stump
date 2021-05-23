package com.achmadqomarudin.animatedbottombar.activities.fragments_questtheme;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;
import com.achmadqomarudin.animatedbottombar.activities.QuestActivity_exam1;
import com.achmadqomarudin.animatedbottombar.activities.fragments_questsearch.SearchquestActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment_quest_frag3 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_quest_frag3, container, false);

        return root;
    }

}