package com.example.wcmc_pr8_17it018;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment1 extends Fragment {
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_fragment1,null);

       intent=new Intent(getActivity(),fragment1activity.class);
       final Button pr1=(Button)v.findViewById(R.id.button);

       pr1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(intent);
           }
       });

       return v;


    }



    }
