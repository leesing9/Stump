package com.achmadqomarudin.animatedbottombar.activities.exam1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.achmadqomarudin.animatedbottombar.KakaoUser;
import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuestActivity_exam1_tab1 extends AppCompatActivity implements View.OnClickListener {
    Button exam1_tab1_fragment_back;
    Button quest_accept_btn;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static String IP_ADDRESS = "172.30.1.59";
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_quest_exam1_tab1);

        exam1_tab1_fragment_back = findViewById(R.id.exam1_tab1_fragment_back);
        exam1_tab1_fragment_back.setOnClickListener(this);

        quest_accept_btn = findViewById(R.id.quest_accept_btn);
        quest_accept_btn.setOnClickListener(this);

    }


    public void onClick(View v){
        if (v.getId() == R.id.exam1_tab1_fragment_back){
            finish();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.quest_accept_btn){

            InsertData task = new InsertData();
            task.execute("http://" + IP_ADDRESS + "/insert.php","");


            Toast.makeText(getApplicationContext(), "인증이 등록되었습니다.",Toast.LENGTH_SHORT).show();
            finish();

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



    class InsertData extends AsyncTask<String, Void, String> {  // DB에 넣는 함수
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(QuestActivity_exam1_tab1.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String title = "오늘 내 패션 어때? 나만의 인생화보 만들기";
            String context ="나만의 패션을 매일 사진 한장으로 남겨보세요!";
            String date = "2021/5/1 ~ 2021/5/29";
            String kakaoname = "신민혜";

            String serverURL = (String) params[0];
            String postParameters = "&title=" + title + "&date=" + date + "&context=" + context + "&kakaoname=" + kakaoname;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

                InputStream inputStream;
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }
}



