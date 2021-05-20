package com.achmadqomarudin.animatedbottombar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.achmadqomarudin.animatedbottombar.R;

public class Login2Activity extends AppCompatActivity{

    ImageView login2tab1;
    ImageView login2tab2;
    ImageView login2tab3;
    ImageView login2tab4;
    ImageView login2tab5;
    ImageView login2tab6;
    ImageView login2tab7;
    ImageView login2tab8;
    ImageView login2tab9;
    boolean login2tab1_bool;
    boolean login2tab2_bool;
    boolean login2tab3_bool;
    boolean login2tab4_bool;
    boolean login2tab5_bool;
    boolean login2tab6_bool;
    boolean login2tab7_bool;
    boolean login2tab8_bool;
    boolean login2tab9_bool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Intent intent = new Intent(this, OnboardingActivity.class);
        startActivityForResult(intent, 1);

        login2tab1 = findViewById(R.id.login2tab1);
        login2tab2 = findViewById(R.id.login2tab2);
        login2tab3 = findViewById(R.id.login2tab3);
        login2tab4 = findViewById(R.id.login2tab4);
        login2tab5 = findViewById(R.id.login2tab5);
        login2tab6 = findViewById(R.id.login2tab6);
        login2tab7 = findViewById(R.id.login2tab7);
        login2tab8 = findViewById(R.id.login2tab8);
        login2tab9 = findViewById(R.id.login2tab9);

    }
    public void mOnPopupClick_Login2tab1(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        if(login2tab1_bool==false) {
            login2tab1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_1icon_on));
            login2tab1_bool=true;
        }
        else{
            login2tab1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_1icon_off));
            login2tab1_bool=false;
        }
    }

    public void mOnPopupClick_Login2tab2(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        if(login2tab2_bool==false) {
            login2tab2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_2icon_on));
            login2tab2_bool=true;
        }
        else{
            login2tab2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_2icon_off));
            login2tab2_bool=false;
        }
    }

    public void mOnPopupClick_Login2tab3(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        if(login2tab3_bool==false) {
            login2tab3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_3icon_on));
            login2tab3_bool=true;
        }
        else{
            login2tab3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_3icon_off));
            login2tab3_bool=false;
        }

    }

    public void mOnPopupClick_Login2tab4(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        if(login2tab4_bool==false) {
            login2tab4.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_4icon_on));
            login2tab4_bool=true;
        }
        else{
            login2tab4.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_4icon_off));
            login2tab4_bool=false;
        }
    }

    public void mOnPopupClick_Login2tab5(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        if(login2tab5_bool==false) {
            login2tab5.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_5icon_on));
            login2tab5_bool=true;
        }
        else{
            login2tab5.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_5icon_off));
            login2tab5_bool=false;
        }
    }

    public void mOnPopupClick_Login2tab6(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        if(login2tab6_bool==false) {
            login2tab6.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_6icon_on));
            login2tab6_bool=true;
        }
        else{
            login2tab6.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_6icon_off));
            login2tab6_bool=false;
        }
    }

    public void mOnPopupClick_Login2tab7(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        if(login2tab7_bool==false) {
            login2tab7.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_7icon_on));
            login2tab7_bool=true;
        }
        else{
            login2tab7.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_7icon_off));
            login2tab7_bool=false;
        }
    }

    public void mOnPopupClick_Login2tab8(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        if(login2tab8_bool==false) {
            login2tab8.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_8icon_on));
            login2tab8_bool=true;
        }
        else{
            login2tab8.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_8icon_off));
            login2tab8_bool=false;
        }

    }

    public void mOnPopupClick_Login2tab9(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        if(login2tab9_bool==false) {
            login2tab9.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_9icon_on));
            login2tab9_bool=true;
        }
        else{
            login2tab9.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.login_9icon_off));
            login2tab9_bool=false;
        }

    }

    public void mOnPopupClick_Login2start(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 1);
    }
}