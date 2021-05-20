package com.achmadqomarudin.animatedbottombar.activities;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.achmadqomarudin.animatedbottombar.R;

import java.security.MessageDigest;

public class FirstActivity extends AppCompatActivity {

    private void HashKey() {
        try {
            PackageInfo pkinfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : pkinfo.signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                String result = new String(Base64.encode(messageDigest.digest(), 0));
                Log.d("해시", result);
            }
        }
        catch (Exception e) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        HashKey();

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
