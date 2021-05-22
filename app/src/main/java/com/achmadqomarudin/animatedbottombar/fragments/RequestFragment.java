package com.achmadqomarudin.animatedbottombar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.RequestPopupActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequestFragment extends Fragment {

    String[] category_items = {"운동","외국어","공예","뷰티","크리에이터","컴퓨터","라이프","재테크","요리"};


    String[] number_items = { "5인 이하","5~10인","10~20인","20~30인","30인 이상" };
    public RequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_request, container, false);



        AutoCompleteTextView category_edit = (AutoCompleteTextView) v.findViewById(R.id.category_edit);

       category_edit.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, category_items));


        AutoCompleteTextView number_edit = (AutoCompleteTextView) v.findViewById(R.id.number_edit);

        number_edit.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, number_items));
        return v;
    }


}
