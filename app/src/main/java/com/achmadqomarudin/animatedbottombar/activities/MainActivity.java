package com.achmadqomarudin.animatedbottombar.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.achmadqomarudin.animatedbottombar.KakaoUser;
import com.achmadqomarudin.animatedbottombar.QuestAdapter;
import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.exam1.QuestActivity_exam1_tab1;
import com.achmadqomarudin.animatedbottombar.activities.fragments_questsearch.SearchquestActivity;
import com.achmadqomarudin.animatedbottombar.fragments.CommunityFragment;
import com.achmadqomarudin.animatedbottombar.fragments.HomeFragment;
import com.achmadqomarudin.animatedbottombar.fragments.MypageFragment;
import com.achmadqomarudin.animatedbottombar.fragments.QuestFragment;
import com.achmadqomarudin.animatedbottombar.fragments.CreatequestFragment;
import com.google.android.material.tabs.TabLayout;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = MainActivity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;

    EditText createquest_title;
    EditText createquest_date;
    EditText createquest_context;
    private static String IP_ADDRESS = "172.30.1.59";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        animatedBottomBar = findViewById(R.id.animatedBottomBar);



        if (savedInstanceState == null) {
            animatedBottomBar.selectTabById(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment)
                    .commit();
        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.quest:
                        fragment = new QuestFragment();
                        break;
                    case R.id.request:
                        fragment = new CreatequestFragment();
                        break;
                    case R.id.community:
                        fragment = new CommunityFragment();
                        break;
                    case R.id.mypage:
                        fragment = new MypageFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                } else {
                    Log.e(TAG, "Error in creating Fragment");
                }
            }
        });
    }

    public void mOnPopupClick_setgps(View v) {
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, SetgpsActivity.class);
        startActivityForResult(intent, 1);
    }


    //버튼



    public void mOnClick_searchquest(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent2 = new Intent(this, SearchquestActivity.class);
        startActivityForResult(intent2, 1);
    }
    //버튼



    public void mOnClick_questexam1(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent = new Intent(this, QuestActivity_exam1_tab1.class);
        startActivityForResult(intent, 1);
    }
    //버튼

    public void mOnClick_mypageconfig(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    //버튼
    public void mOnClick_mypagetoexam1(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                Intent intent = new Intent(MainActivity.this, QuestActivity_exam1_tab1.class);
                startActivity(intent);
            }
        });
    }

    public void mOnClick_createquest(View v) {
        //데이터 담아서 팝업(액티비티) 호출

        createquest_title = (EditText)findViewById(R.id.createquest_title);
        createquest_date = (EditText)findViewById(R.id.createquest_date);
        createquest_context = (EditText)findViewById(R.id.createquest_context);

        String title = createquest_title.getText().toString();
        String date = createquest_date.getText().toString();
        String context = createquest_context.getText().toString();

        InsertData task = new InsertData();
        task.execute("http://" + IP_ADDRESS + "/insert.php", title,date,context);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Intent intent2 = new Intent(this, RequestPopupActivity.class);
        startActivityForResult(intent2, 1);
    }


    class InsertData extends AsyncTask<String, Void, String> {  // DB에 넣는 함수
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainActivity.this,
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

            String title = (String) params[1];
            String date = (String) params[2];
            String context = (String) params[3];
            String kakaoname = (String) params[4];

            String serverURL = (String) params[0];
            String postParameters = "title=" + title + "&date=" + date + "&context=" + context + "&kakaoname=" + kakaoname;


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
