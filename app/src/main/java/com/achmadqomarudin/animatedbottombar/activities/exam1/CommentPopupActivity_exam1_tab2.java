package com.achmadqomarudin.animatedbottombar.activities.exam1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.achmadqomarudin.animatedbottombar.R;

public class CommentPopupActivity_exam1_tab2 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 배경 어둡게
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.75f;
        getWindow().setAttributes(lpWindow);

        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_quest_exam1_comment_popup);

        //UI 객체생성
    }



}
