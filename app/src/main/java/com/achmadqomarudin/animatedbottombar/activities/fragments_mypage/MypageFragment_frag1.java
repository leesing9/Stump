package com.achmadqomarudin.animatedbottombar.activities.fragments_mypage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.achmadqomarudin.animatedbottombar.KakaoUser;
import com.achmadqomarudin.animatedbottombar.QuestAdapter;
import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.MainActivity;
import com.achmadqomarudin.animatedbottombar.fragments.MypageFragment;
import com.google.android.material.tabs.TabLayout;

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


/**
 * A placeholder fragment containing a simple view.
 */
public class MypageFragment_frag1 extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<KakaoUser> mArrayList;
    private QuestAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private String mJsonString;
    private static String IP_ADDRESS = "172.30.1.59";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mypage_frag1, container, false);

        mRecyclerView = v.findViewById(R.id.listView_main_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mArrayList = new ArrayList<>();

        mAdapter = new QuestAdapter(getActivity(), mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        mArrayList.clear();
        mAdapter.notifyDataSetChanged();
        GetData task = new GetData();
        task.execute("http://" + IP_ADDRESS + "/get_opalquest.php", "");


        return v;
    }


    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(getActivity(),
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
        String TAG_TITLE = "title";
        String TAG_DATE = "date";
        String TAG_CONTEXT = "context";
        String TAG_KAKAONAME = "kakaoname";
        String TAG_IMAGE = "image";

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject item = jsonArray.getJSONObject(i);

                String title = item.getString(TAG_TITLE);
                String date = item.getString(TAG_DATE);
                String context = item.getString(TAG_CONTEXT);
                String kakaoname = item.getString(TAG_KAKAONAME);
                String image = item.getString(TAG_IMAGE);

                KakaoUser personalData = new KakaoUser();

                personalData.setMember_title(title);
                personalData.setMember_date(date);
                personalData.setMember_context(context);
                personalData.setMember_kakaoname(kakaoname);
                Bitmap bmp = BitmapFactory.decodeByteArray(image.getBytes(),0,image.length());
                personalData.setMember_image(bmp);



                mArrayList.add(personalData);
                mAdapter.notifyDataSetChanged();
            }


        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }


    }

}