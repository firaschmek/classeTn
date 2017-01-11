package com.example.applisys.classetn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applisys.classetn.R;

/**
 * Created by applisys on 10/01/17.
 */

public class HomeFragment extends  BaseFragment {




    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);



        return view;
    }



    @Override
    public boolean onBackPressed() {
        return true;
    }
}
