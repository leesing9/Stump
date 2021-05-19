package com.achmadqomarudin.animatedbottombar.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.fragments.CommunityFragment;
import com.achmadqomarudin.animatedbottombar.fragments.MypageFragment;
import com.achmadqomarudin.animatedbottombar.fragments.RequestFragment;
import com.achmadqomarudin.animatedbottombar.fragments.QuestFragment;
import com.achmadqomarudin.animatedbottombar.fragments.HomeFragment;

import org.jetbrains.annotations.NotNull;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;
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

                    case R.id.mypage_frag2:
                        fragment = new MypageFragment();
                        break;

                    case R.id.mypage_frag3:
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
}
