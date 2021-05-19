package com.achmadqomarudin.animatedbottombar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.achmadqomarudin.animatedbottombar.R;

public class Login2Activity extends AppCompatActivity {

    LinearLayout login2_tab1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

    }
    public void mOnPopupClick_Login2tab1(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 1);
    }
}