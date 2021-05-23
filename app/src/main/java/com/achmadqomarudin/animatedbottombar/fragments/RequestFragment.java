package com.achmadqomarudin.animatedbottombar.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.activities.RequestPopupActivity;

import java.lang.reflect.Array;


/**
 * A simple {@link Fragment} subclass.
 */
public class RequestFragment extends Fragment {
    TextView spinnertext1;
    TextView spinnertext2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_request, container, false);
        spinnertext1 = v.findViewById(R.id.spinnertext1);
        spinnertext2 = v.findViewById(R.id.spinnertext2);
        Spinner spinner1 = (Spinner) v.findViewById(R.id.request_spinner1);
        Spinner spinner2 = (Spinner) v.findViewById(R.id.request_spinner2);

        @SuppressLint("ResourceType") ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,R.array.request_array1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        return v;
    }


}
