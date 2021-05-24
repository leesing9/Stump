package com.achmadqomarudin.animatedbottombar.activities.exam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;

public class QuestActivity_exam1_tab1 extends AppCompatActivity implements View.OnClickListener {
    Button exam1_tab1_fragment_back;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quest_exam1_tab1);

        exam1_tab1_fragment_back = findViewById(R.id.exam1_tab1_fragment_back);
        exam1_tab1_fragment_back.setOnClickListener(this);


    }


    public void onClick(View v){
        if (v.getId() == R.id.exam1_tab1_fragment_back){
            finish();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void mOnClick_exam1_tab1_tab2(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent = new Intent(this, QuestActivity_exam1_tab2.class);
        startActivityForResult(intent, 1);
    }
    public void mOnClick_exam1_tab1_tab3(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent = new Intent(this, QuestActivity_exam1_tab3.class);
        startActivityForResult(intent, 1);
    }
}



