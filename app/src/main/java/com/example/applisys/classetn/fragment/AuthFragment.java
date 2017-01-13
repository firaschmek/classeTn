package com.example.applisys.classetn.fragment;

/**
 * Created by applisys on 10/01/17.
 */
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

import com.example.applisys.classetn.API.EleveInterfas;
import com.example.applisys.classetn.API.Parentnterfas;
import com.example.applisys.classetn.API.UserInterfas;
import com.example.applisys.classetn.Bean.Eleve;
import com.example.applisys.classetn.Bean.Parent;
import com.example.applisys.classetn.Bean.User;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.constant.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthFragment extends BaseFragment {


    TextView splash_text4;
    EditText email_auth_editext;
    Button btn_login;
    String returnedResponse;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_auth, container, false);
        email_auth_editext= (EditText) view.findViewById(R.id.email_auth_editext);
        btn_login= (Button) view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String identifiant_parent=email_auth_editext.getText().toString();
                Log.e("identifiant parent",identifiant_parent);


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();



                Parentnterfas parentAPIService = retrofit.create(Parentnterfas.class);
                Call<Parent> mService = parentAPIService.showParent(identifiant_parent);
                mService.enqueue(new Callback<Parent>() {
                    @Override
                    public void onResponse(Call<Parent> call, Response<Parent> response) {
                        if(response!=null)
                        {   Parent parent_liste = response.body();
                         if(parent_liste!=null)
                            {if(parent_liste.getEleves()!=null)
                            { returnedResponse = parent_liste.getEleves().get(0).getClasse();
                            Log.e("############NOM###ELEVE",returnedResponse);

                            Bundle bundle_identifiant=new Bundle();
                            bundle_identifiant.putString("identifiant_parent",identifiant_parent);
                            EleveListFragment eleveListFragment=new EleveListFragment();
                            eleveListFragment.setArguments(bundle_identifiant);
                                eleveListFragment.setListe_eleve(parent_liste.getEleves());
                            baseActivity.replaceFragment(eleveListFragment,R.id.activity_main_FrameLayout);}
                            else
                            {
                                Toast.makeText(getActivity(), getString(R.string.error_code_msg), Toast.LENGTH_LONG).show();
                            }

                            }
                            else
                         {
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
        splash_text4= (TextView) view.findViewById(R.id.splash_text4);
        splash_text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.replaceFragment(new WebsiteFragment(),R.id.activity_main_FrameLayout);
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

}



    @Override
    public boolean onBackPressed() {
        return false;
    }
}
