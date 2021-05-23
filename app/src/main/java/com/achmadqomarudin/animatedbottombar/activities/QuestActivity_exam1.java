package com.achmadqomarudin.animatedbottombar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.fragments_questexam1.SectionsPagerAdapter_quest_exam1;
import com.google.android.material.tabs.TabLayout;

public class QuestActivity_exam1 extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quest_exam1);

        Button search_fragment_back = findViewById(R.id.exam1_fragment_back);
        search_fragment_back.setOnClickListener(this);

        SectionsPagerAdapter_quest_exam1 sectionsPagerAdapter = new SectionsPagerAdapter_quest_exam1(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager_exam1);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs_exam1);
        tabs.setupWithViewPager(viewPager);
    }


    public void onClick(View v){
        if (v.getId() == R.id.exam1_fragment_back){

            Intent intent = new Intent(this, MainActivity.class);
            startActivityForResult(intent, 1);
        }

    }

}



