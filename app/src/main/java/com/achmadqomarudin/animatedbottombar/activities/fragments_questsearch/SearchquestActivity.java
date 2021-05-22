package com.achmadqomarudin.animatedbottombar.activities.fragments_questsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;
import com.google.android.material.tabs.TabLayout;


public class SearchquestActivity  extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_fragment);

        SectionsPagerAdapter_quest sectionsPagerAdapter = new SectionsPagerAdapter_quest(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager_search);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs_search);
        tabs.setupWithViewPager(viewPager);

    }


    public void onClick(View v){
//        if (v.getId() == R.id.mot){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
//        }

    }

}