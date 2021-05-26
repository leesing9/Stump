package com.achmadqomarudin.animatedbottombar.activities.exam1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.achmadqomarudin.animatedbottombar.KakaoUser;
import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthPopupActivity_exam1_tab2 extends Activity implements View.OnClickListener{

    ImageButton auth_back;
    Button auth_accept_btn;
    private static final String TAG = MainActivity.class.getSimpleName();
    EditText exam1_auth_context;
    private static String IP_ADDRESS = "172.30.1.59";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 배경 어둡게
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.75f;
        getWindow().setAttributes(lpWindow);

        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_quest_exam1_auth_popup);

        auth_back = findViewById(R.id.auth_back);
        auth_back.setOnClickListener(this);
        auth_accept_btn = findViewById(R.id.auth_accept_btn);
        auth_accept_btn.setOnClickListener(this);

        //UI 객체생성
    }

    public void onClick(View v) {
        if (v.getId() == R.id.auth_back) {
            finish();
        }
        if (v.getId() == R.id.auth_accept_btn) {

            exam1_auth_context = findViewById(R.id.exam1_auth_context);
            String context = exam1_auth_context.getText().toString();

            InsertData task = new InsertData();
            task.execute("http://" + IP_ADDRESS + "/insert_community.php",context);


            Toast.makeText(getApplicationContext(), "인증이 등록되었습니다.",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    class InsertData extends AsyncTask<String, Void, String> {  // DB에 넣는 함수
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(AuthPopupActivity_exam1_tab2.this,
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

            String context = (String) params[1];
            String kakaoname = KakaoUser.nickname;

            String serverURL = (String) params[0];
            String postParameters = "&context=" + context + "&kakaoname=" + kakaoname;


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
