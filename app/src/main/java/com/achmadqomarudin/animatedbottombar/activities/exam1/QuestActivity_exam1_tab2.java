package com.achmadqomarudin.animatedbottombar.activities.exam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;

public class QuestActivity_exam1_tab2 extends AppCompatActivity implements View.OnClickListener{

    private SwipeRefreshLayout swipeRefreshLayout;
    Button exam1_tab2_fragment_back;
    Button exam1_auth;
    ImageButton exam1_comment1;
    ImageButton exam1_comment2;
    ImageButton exam1_comment3;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quest_exam1_tab2);

        exam1_tab2_fragment_back = findViewById(R.id.exam1_tab2_fragment_back);
        exam1_tab2_fragment_back.setOnClickListener(this);

        exam1_auth = findViewById(R.id.exam1_auth);
        exam1_auth.setOnClickListener(this);

        exam1_comment1 = findViewById(R.id.exam1_comment1);
        exam1_comment1.setOnClickListener(this);
        exam1_comment2 = findViewById(R.id.exam1_comment2);
        exam1_comment2.setOnClickListener(this);
        exam1_comment3 = findViewById(R.id.exam1_comment3);
        exam1_comment3.setOnClickListener(this);

        swipeRefreshLayout = findViewById(R.id.exam1_tab2_sr);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                /* swipe 시 진행할 동작 */

                /* 업데이트가 끝났음을 알림 */

                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    public void onClick(View v) {
        if (v.getId() == R.id.exam1_tab2_fragment_back) {
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.exam1_auth) {
            finish();
            Intent intent = new Intent(this, AuthPopupActivity_exam1_tab2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.sliding_up, R.anim.stay);
        }
        if (v.getId() == R.id.exam1_comment1||v.getId() == R.id.exam1_comment2||v.getId() ==R.id.exam1_comment3) {
            Intent intent = new Intent(this, CommentPopupActivity_exam1_tab2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.sliding_up, R.anim.stay);
        }
    }
    public void mOnClick_exam1_tab2_tab1(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent = new Intent(this, QuestActivity_exam1_tab1.class);
        startActivityForResult(intent, 1);
    }
    public void mOnClick_exam1_tab2_tab3(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent = new Intent(this, QuestActivity_exam1_tab3.class);
        startActivityForResult(intent, 1);
    }



}



