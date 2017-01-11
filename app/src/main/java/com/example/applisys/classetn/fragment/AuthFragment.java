package com.example.applisys.classetn.fragment;

/**
 * Created by applisys on 10/01/17.
 */
import android.content.Context;
import android.content.Intent;
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

import com.example.applisys.classetn.API.APInterfas;
import com.example.applisys.classetn.Bean.Parent;
import com.example.applisys.classetn.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;

public class AuthFragment extends BaseFragment {

    public static final String BASE_URL = "http://classe.tn";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_auth, container, false);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        APInterfas parentAPIService = retrofit.create(APInterfas.class);
        Call<Parent> mService = parentAPIService.showParent("469219");
        mService.enqueue(new Callback<Parent>() {
            @Override
            public void onResponse(Call<Parent> call, Response<Parent> response) {
if(response!=null)
{    Parent mparentObject = response.body();
                String returnedResponse = mparentObject.getNomEleve();
Log.e("############NOM###ELEVE",returnedResponse);
}

                //showProgress(false);




            }

            @Override
            public void onFailure(Call<Parent> call, Throwable t) {
                call.cancel();
                Toast.makeText(getActivity(), "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();

            }
        });


}



    @Override
    public boolean onBackPressed() {
        return false;
    }
}
