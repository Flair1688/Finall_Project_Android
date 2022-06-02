package com.arhiser.todolist.screens.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arhiser.todolist.R;


public class FirstFragment extends Fragment {
    Button Wbtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        Wbtn = (Button) v.findViewById(R.id.web_button);
        Wbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()){
                    case R.id.web_button:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1ERegv5O73kkC1NHeE1qkMI349pa-oFp3dN7PgaFUJAY/edit#gid=1477614000"));
                        startActivity(intent);
                        break;

                }
            }
        });
    return v;
    }



}