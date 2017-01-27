package com.example.applisys.classetn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.applisys.classetn.R;

/**
 * Created by applisys on 12/01/17.
 */

public class WebsiteFragment extends  BaseFragment {




    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_website, container, false);
        WebView myWebView = (WebView) view.findViewById(R.id.webview);
        myWebView.loadUrl("http://classe.tn");
//this returned view ok

        return view;
    }



    @Override
    public boolean onBackPressed() {
        return true;
    }
}
