package com.example.applisys.classetn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.applisys.classetn.R;

/**
 * Created by applisys on 12/01/17.
 */

public class FragmentEleveDetail extends  BaseFragment  {

String code_classe;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_detail_eleve, container, false);
        if(getArguments().getString("code_classe")!=null)
        {code_classe=getArguments().getString("code_classe");
Log.e("code_classe",code_classe);
        }
        else
        {  Log.e("FragmentEleveDetail:BUNDLE","NULL");}

        WebView myWebView = (WebView) view.findViewById(R.id.webview_detail_eleve);
        myWebView.loadUrl("http://classe.tn/classe_eleve.php?classe="+code_classe);

        return view;
    }

    @Override
    public boolean onBackPressed() {
        return true;
    }
}