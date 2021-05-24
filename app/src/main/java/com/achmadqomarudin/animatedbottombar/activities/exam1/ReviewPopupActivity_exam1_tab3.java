package com.achmadqomarudin.animatedbottombar.activities.exam1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;

public class ReviewPopupActivity_exam1_tab3 extends Activity implements View.OnClickListener{

    ImageButton review_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 배경 어둡게
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.75f;
        getWindow().setAttributes(lpWindow);

        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_quest_exam1_review_popup);

        review_back = findViewById(R.id.review_back);
        review_back.setOnClickListener(this);

        //UI 객체생성
    }

    //확인 버튼 클릭
    public void mOnClick_success(View v) {


        finish();
    }
    public void onClick(View v) {
        if (v.getId() == R.id.review_back) {
            finish();
        }
    }

}
