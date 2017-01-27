package com.example.applisys.classetn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applisys.classetn.R;
import com.example.applisys.classetn.constant.Constant;

/**
 * Created by applisys on 12/01/17.
 */

public class FragmentEleveDetail extends BaseFragment {

    String code_classe;
    TextView nom_eleve_txtv, class_txtv, etablissement_item_txtv;
    ImageView back_icon_detail_eleve, reclam_admin;
    Bundle bundle_identifiant;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_detail_eleve, container, false);
        Toolbar elev_detail_toolbar = (Toolbar) view.findViewById(R.id.eleve_detail_toolbar);
        baseActivity.setSupportActionBar(elev_detail_toolbar);
        back_icon_detail_eleve = (ImageView) view.findViewById(R.id.back_icon_detail_eleve);
        reclam_admin = (ImageView) view.findViewById(R.id.reclam_admin);
        reclam_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(baseActivity, getString(R.string.reclamation_txt), Toast.LENGTH_SHORT).show();
            }
        });
        back_icon_detail_eleve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EleveListFragment eleveListFragment = new EleveListFragment();

                baseActivity.replaceFragment(eleveListFragment);

            }
        });
        nom_eleve_txtv = (TextView) view.findViewById(R.id.nom_eleve_txtv);
        class_txtv = (TextView) view.findViewById(R.id.class_txtv);
        etablissement_item_txtv = (TextView) view.findViewById(R.id.etablissement_item_txtv);



        nom_eleve_txtv.setText(getArguments().getString("nom_eleve"));
        code_classe = getArguments().getString("code_classe");
        Log.e("code_classe", code_classe);
        class_txtv.setText(getArguments().getString("classe_eleve"));
        etablissement_item_txtv.setText(getArguments().getString("etab_eleve"));
        WebView myWebView = (WebView) view.findViewById(R.id.webview_detail_eleve);
        myWebView.loadUrl("http://classe.tn/classe_eleve.php?classe=" + code_classe);

        return view;
    }


    @Override
    public boolean onBackPressed() {
        return true;
    }
}