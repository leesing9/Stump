package com.achmadqomarudin.animatedbottombar.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.fragments_questsearch.SearchquestActivity;
import com.achmadqomarudin.animatedbottombar.fragments.CommunityFragment;
import com.achmadqomarudin.animatedbottombar.fragments.HomeFragment;
import com.achmadqomarudin.animatedbottombar.fragments.MypageFragment;
import com.achmadqomarudin.animatedbottombar.fragments.QuestFragment;
import com.achmadqomarudin.animatedbottombar.fragments.RequestFragment;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        animatedBottomBar = findViewById(R.id.animatedBottomBar);

        if (savedInstanceState == null) {
            animatedBottomBar.selectTabById(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment)
                    .commit();
        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.quest:
                        fragment = new QuestFragment();
                        break;
                    case R.id.request:
                        fragment = new RequestFragment();
                        break;
                    case R.id.community:
                        fragment = new CommunityFragment();
                        break;
                    case R.id.mypage:
                        fragment = new MypageFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                } else {
                    Log.e(TAG, "Error in creating Fragment");
                }
            }
        });
    }

    public void mOnPopupClick_setgps(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, SetgpsActivity.class);
        startActivityForResult(intent, 1);
    }


    //버튼


    public void mOnClick_request(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Intent intent2 = new Intent(this, RequestPopupActivity.class);
        startActivityForResult(intent2, 1);
    }


    public void mOnClick_searchquest(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent2 = new Intent(this, SearchquestActivity.class);
        startActivityForResult(intent2, 1);
    }
    //버튼



    public void mOnClick_questexam1(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent = new Intent(this, QuestActivity_exam1.class);
        startActivityForResult(intent, 1);
    }
    //버튼
}
