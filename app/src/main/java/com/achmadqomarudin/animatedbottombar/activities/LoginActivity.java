package com.achmadqomarudin.animatedbottombar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.achmadqomarudin.animatedbottombar.R;

public class LoginActivity extends AppCompatActivity {


    LinearLayout kakao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void mOnPopupClick_kakao(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, Login2Activity.class);
        startActivityForResult(intent, 1);
    }
}