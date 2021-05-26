package com.achmadqomarudin.animatedbottombar.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.achmadqomarudin.animatedbottombar.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreatequestFragment extends Fragment {

    Calendar myCalendar = Calendar.getInstance();
    Calendar myCalendar2 = Calendar.getInstance();
    String et_date_;
    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {

        int choise_year;
        int choise_month;
        int choise_day;

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            choise_year=year;
            choise_month=month;
            choise_day=dayOfMonth;

            String myFormat = "yyyy/MM/dd ~ ";    // 출력형식   2018/11/28
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

            et_date_ = sdf.format(myCalendar.getTime());
        }
    };

    DatePickerDialog.OnDateSetListener myDatePicker2 = new DatePickerDialog.OnDateSetListener() {

        int choise_year;
        int choise_month;
        int choise_day;

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            choise_year=year;
            choise_month=month;
            choise_day=dayOfMonth;

            String myFormat = "yyyy/MM/dd";    // 출력형식   2018/11/28
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

            EditText et_date = (EditText) getActivity().findViewById(R.id.createquest_date);
            et_date.setText(et_date_ + sdf.format(myCalendar.getTime()));
        }
    };

    TextView spinnertext1;
    TextView spinnertext2;
    String[] items1 = {"운동","외국어","공예","뷰티","크리에이터","컴퓨터","라이프","재테크","요리"};
    String[] items2 = {"5인 이하", "5 ~ 10인","10 ~ 20인","20 ~ 30인","30인 이상"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_createquest, container, false);

        spinnertext1 = v.findViewById(R.id.spinnertext1);
        spinnertext2 = v.findViewById(R.id.spinnertext2);
        Spinner spinner1 = (Spinner) v.findViewById(R.id.request_spinner1);
        Spinner spinner2 = (Spinner) v.findViewById(R.id.request_spinner2);


        EditText et_Date = v.findViewById(R.id.createquest_date);
        ImageView createquest_image = v.findViewById(R.id.createquest_image);


        createquest_image.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     Intent intent = new Intent(Intent.ACTION_PICK);
                                                     intent.setType("image/");
                                                     intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                                     startActivityForResult(intent, 0);
                                                     createquest_image.setImageURI(intent.getData());
                                                 }


                                             });



        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "시작 날짜와 종료 날짜를 선택해주세요.",Toast.LENGTH_SHORT).show();
                new DatePickerDialog(getActivity(), myDatePicker2, myCalendar2.get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH), myCalendar2.get(Calendar.DAY_OF_MONTH)).show();
                new DatePickerDialog(getActivity(), myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                 }
        });


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,items1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,items2);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnertext1.setText(items1[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnertext1.setText("");
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnertext2.setText(items2[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnertext2.setText("");

            }
        });

            return v;
    }


}
