package com.example.applisys.classetn.fragment;

/**
 * Created by applisys on 10/01/17.
 */

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applisys.classetn.API.CodeInterfas;
import com.example.applisys.classetn.API.EleveInterfas;
import com.example.applisys.classetn.API.EtablissementIntefas;
import com.example.applisys.classetn.API.Parentnterfas;
import com.example.applisys.classetn.API.UserInterfas;
import com.example.applisys.classetn.Bean.CodeEtab;
import com.example.applisys.classetn.Bean.Eleve;
import com.example.applisys.classetn.Bean.Etablissement;
import com.example.applisys.classetn.Bean.ListeEtab;
import com.example.applisys.classetn.Bean.Parent;
import com.example.applisys.classetn.Bean.User;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.constant.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.victor.loading.rotate.RotateLoading;

import org.apache.commons.codec.digest.Crypt;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthFragment extends BaseFragment {

    Bundle bundle_identifiant;
    TextView splash_text4;
    EditText email_auth_editext;
    Button btn_login, add_acount;
    String returnedResponse;
    String identifiant_parent;
    Retrofit retrofit, retrofit2;
    RotateLoading rotateLoading;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_auth, container, false);

rotateLoading= (RotateLoading) view.findViewById(R.id.rotateloading);

        email_auth_editext = (EditText) view.findViewById(R.id.email_auth_editext);
        btn_login = (Button) view.findViewById(R.id.btn_login);
        add_acount = (Button) view.findViewById(R.id.add_acount);
        add_acount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.replaceFragment(new ParentAddFragment(),R.id.activity_main_FrameLayout);
            }
        });

        //initialiser retrofit
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        // Add logging into retrofit 2.0
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.interceptors().add(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build()).build();
        retrofit2 = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build()).build();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rotateLoading.start();
                identifiant_parent = email_auth_editext.getText().toString();
                Log.e("identifiant parent", identifiant_parent);
                Constant.identifiant_parent = identifiant_parent;

                // authentification parent

email_auth_editext.setText(null);
                email_auth_editext.setHint(null);
                Parentnterfas parentAPIService = retrofit.create(Parentnterfas.class);
                Call<Parent> mService = parentAPIService.showParent(identifiant_parent);
                mService.enqueue(new Callback<Parent>() {
                    @Override
                    public void onResponse(Call<Parent> call, Response<Parent> response) {
                        if (response != null) {
                            Parent parent_liste = response.body();
                            Log.e("error", parent_liste.getError());

                            if (parent_liste != null) {
                                Constant.code_parent = parent_liste.getCodeParent();
                                if (parent_liste.getEleves() != null) {
                                    returnedResponse = parent_liste.getEleves().get(0).getClasse();
                                    Log.e("############NOM###ELEVE", returnedResponse);

                                    bundle_identifiant = new Bundle();
                                    bundle_identifiant.putString("identifiant_parent", identifiant_parent);

                                    EleveListFragment eleveListFragment = new EleveListFragment();
                                    eleveListFragment.setArguments(bundle_identifiant);
                                    rotateLoading.stop();

                                    //eleveListFragment.setListe_eleve(parent_liste.getEleves());
                                    baseActivity.replaceFragment(eleveListFragment, R.id.activity_main_FrameLayout);

                                } else {
                                    EleveListFragment eleveListFragment = new EleveListFragment();
                                    eleveListFragment.setArguments(bundle_identifiant);
                                    rotateLoading.stop();
                                    baseActivity.replaceFragment(eleveListFragment, R.id.activity_main_FrameLayout);
                                }

                            } else {
                                Log.e("parent", "null");
                                Toast.makeText(getActivity(), getString(R.string.error_code_msg), Toast.LENGTH_LONG).show();
                            }

                        }

                        //showProgress(false);


                    }

                    @Override
                    public void onFailure(Call<Parent> call, Throwable t) {
                        call.cancel();
                        Toast.makeText(getActivity(), getString(R.string.error_internet_msg), Toast.LENGTH_LONG).show();

                    }
                });


            }
        });
        splash_text4 = (TextView) view.findViewById(R.id.splash_text4);

        splash_text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.replaceFragment(new WebsiteFragment(), R.id.activity_main_FrameLayout);
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//chercher la code pour liste des etablissement

        //    int code_to_send=(Integer.parseInt(codeEtab.getCode())*2+2);
        //  Log.e("code_to_send",code_to_send+"");

    }


    @Override
    public boolean onBackPressed() {
        return false;
    }


}
