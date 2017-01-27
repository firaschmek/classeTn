package com.example.applisys.classetn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.applisys.classetn.API.Parentnterfas;
import com.example.applisys.classetn.Bean.Eleve;
import com.example.applisys.classetn.Bean.Parent;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.constant.Constant;
import com.example.applisys.classetn.util.EditTextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by applisys on 18/01/17.
 */

public class ParentAddFragment extends BaseFragment {

Button btn_signin;
    Bundle bundle_identifiant;
    EditText frg_add_parent_id_parent_editxt;
    Retrofit retrofit;
    String identifiant_parent;
    ImageView back_icon_add_prent;
public static  final String TAG="ParentAddFragment";
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_add_parent, container, false);
        back_icon_add_prent= (ImageView) view.findViewById(R.id.back_icon_add_prent);
        back_icon_add_prent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Constant.identifiant_parent!=null)
                baseActivity.replaceFragment(new EleveListFragment(),R.id.activity_main_FrameLayout);
else
                    baseActivity.replaceFragment(new AuthFragment(),R.id.activity_main_FrameLayout);
            }
        });
        btn_signin= (Button) view.findViewById(R.id.btn_signin);
        frg_add_parent_id_parent_editxt= (EditText) view.findViewById(R.id.frg_add_parent_id_parent_editxt);
//retrofit initialisation and debug begin
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.interceptors().add(logging);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build()).build();
        //retrofit initialisation and debug end
        EditTextUtils.forwardTonext(frg_add_parent_id_parent_editxt,btn_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                identifiant_parent=frg_add_parent_id_parent_editxt.getText().toString();
                Phonenumber.PhoneNumber tnNumberProto=null;
                PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

                try {
                    tnNumberProto = phoneUtil.parse(identifiant_parent, "TN");
                } catch (NumberParseException e) {
                    System.err.println("NumberParseException was thrown: " + e.toString());
                }

                if(EditTextUtils.isTextFieldEmpty(frg_add_parent_id_parent_editxt))
                {
                    Toast.makeText(baseActivity,getResources().getString(R.string.etab_obligatoire), Toast.LENGTH_SHORT).show();
                }
                else if (!EmailValidator.getInstance().isValid(identifiant_parent)&&!phoneUtil.isValidNumber(tnNumberProto)){

                    Toast.makeText(baseActivity,getString(R.string.email_or_phone_non_valid), Toast.LENGTH_SHORT).show();

                }

                else
                { Call<Parent> mService=null;
                    Parentnterfas parentAPIService = retrofit.create(Parentnterfas.class);
                    if(EmailValidator.getInstance().isValid(identifiant_parent))
                   mService = parentAPIService.addParent("",identifiant_parent);
                    else
                        mService = parentAPIService.addParent(identifiant_parent,"");
                    mService.enqueue(new Callback<Parent>() {
                        @Override
                        public void onResponse(Call<Parent> call, Response<Parent> response) {
                            if(response!=null)
                            {   Parent parent_liste = response.body();
                               Log.e(TAG,parent_liste.getCodeParent());
Constant.code_parent=parent_liste.getCodeParent();
                            Constant.identifiant_parent=identifiant_parent;
                               // Toast.makeText(getActivity(), "تم تسجيلك بنجاح", Toast.LENGTH_LONG).show();
                                bundle_identifiant = new Bundle();
                                bundle_identifiant.putString("identifiant_parent", identifiant_parent);

                                EleveListFragment eleveListFragment = new EleveListFragment();
                                eleveListFragment.setArguments(bundle_identifiant);


                                baseActivity.replaceFragment(eleveListFragment, R.id.activity_main_FrameLayout);

                            }

                            //showProgress(false);




                        }

                        @Override
                        public void onFailure(Call<Parent> call, Throwable t) {

                            Toast.makeText(getActivity(), getString(R.string.error_sign_up), Toast.LENGTH_LONG).show();

                        }
                    });


                }
            }
        });


        return view;
    }



    @Override
    public boolean onBackPressed() {
        return true;
    }
}
