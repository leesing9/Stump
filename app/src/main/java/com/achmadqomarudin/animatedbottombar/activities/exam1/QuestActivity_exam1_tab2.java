package com.achmadqomarudin.animatedbottombar.activities.exam1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.achmadqomarudin.animatedbottombar.Exam1Adapter_tab2_community;
import com.achmadqomarudin.animatedbottombar.KakaoUser;
import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class QuestActivity_exam1_tab2 extends AppCompatActivity implements View.OnClickListener{

        private static final String TAG = MainActivity.class.getSimpleName();
        private ArrayList<KakaoUser> mArrayList;
        private Exam1Adapter_tab2_community mAdapter;
        private RecyclerView mRecyclerView;
        private String mJsonString;
    private static String IP_ADDRESS = "172.30.1.59";
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


        mRecyclerView = findViewById(R.id.listView_main_list_community);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mArrayList = new ArrayList<>();

        mAdapter = new Exam1Adapter_tab2_community(this,mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        mArrayList.clear();
        mAdapter.notifyDataSetChanged();
        GetData task = new GetData();
        task.execute("http://" + IP_ADDRESS + "/get_opalquest_community.php", "");
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



    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(QuestActivity_exam1_tab2.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            Log.d(TAG, "response - " + result);

            if (result == null) {

            } else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String postParameters = params[1];


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }

                bufferedReader.close();

                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "GetData : Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }


    private void showResult() {

        String TAG_JSON = "webnautes";
        String TAG_CONTEXT = "context";

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject item = jsonArray.getJSONObject(i);

                String context = item.getString(TAG_CONTEXT);
                String kakaoname = KakaoUser.nickname;

                KakaoUser personalData = new KakaoUser();

                personalData.setMember_context(context);
                personalData.setMember_kakaoname(kakaoname);

                mArrayList.add(personalData);
                mAdapter.notifyDataSetChanged();
            }


        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }


    }

}



