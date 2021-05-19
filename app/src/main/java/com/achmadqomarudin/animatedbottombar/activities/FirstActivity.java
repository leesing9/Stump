package com.achmadqomarudin.animatedbottombar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.achmadqomarudin.animatedbottombar.R;

public class FirstActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);


        final Handler mHandler = new Handler();


        mHandler.postDelayed(new Runnable() {
            public void run() {
                // 시간 지난 후 실행할 코딩
                Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 1500);
    }
}
