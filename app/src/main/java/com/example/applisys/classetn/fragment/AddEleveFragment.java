package com.example.applisys.classetn.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applisys.classetn.API.ClasseInterfas;
import com.example.applisys.classetn.API.CodeInterfas;
import com.example.applisys.classetn.API.EleveInterfas;
import com.example.applisys.classetn.API.EtablissementIntefas;
import com.example.applisys.classetn.API.NiveauInterfas;
import com.example.applisys.classetn.Bean.Classe;
import com.example.applisys.classetn.Bean.CodeEtab;
import com.example.applisys.classetn.Bean.Eleve;
import com.example.applisys.classetn.Bean.Error;
import com.example.applisys.classetn.Bean.Etablissement;
import com.example.applisys.classetn.Bean.ListClass;
import com.example.applisys.classetn.Bean.ListNiveau;
import com.example.applisys.classetn.Bean.ListeEtab;
import com.example.applisys.classetn.Bean.Niveau;
import com.example.applisys.classetn.R;
import com.example.applisys.classetn.adapter.ClassAdapter;
import com.example.applisys.classetn.adapter.EleveAdapter;
import com.example.applisys.classetn.constant.Constant;
import com.example.applisys.classetn.interfas.ClassRecyclerListener;
import com.example.applisys.classetn.util.EditTextUtils;
import com.example.applisys.classetn.util.RecyclerAdapterUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.codec.digest.Crypt;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by applisys on 13/01/17.
 */

public class AddEleveFragment extends BaseFragment implements ClassRecyclerListener {


    Retrofit retrofit, retrofit2;

    List<Etablissement> etablissementList;
    List<Classe> liste_classe, liste_class_per_recycler;
    String[] array_classe;
    EditText nom_edittext;
    FloatingActionButton btn_save;
    String[] array_etablissement, array_niveaux;
    ClassAdapter classAdapter;
    RecyclerView classRecyclerView;
    List<Niveau> liste_niveaux;
    TextView kism_txtview;
    ImageView back_icon_add_eleve;
    public static final String TAG = "AddEleveFragment";
    String nom_eleve, identifiant_parent, id_etablissement, id_classe;


    AutoCompleteTextView etablissement_txtv, niveaux_txtv;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_eleve, container, false);
        liste_class_per_recycler = new ArrayList<>();
        back_icon_add_eleve = (ImageView) view.findViewById(R.id.back_icon_add_eleve);
        back_icon_add_eleve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.replaceFragment(new EleveListFragment());
            }
        });
        classRecyclerView = (RecyclerView) view.findViewById(R.id.class_recycler_view);
        classAdapter = new ClassAdapter(liste_class_per_recycler, this);
        LinearLayoutManager class_recycler_view_llm = new LinearLayoutManager(getContext());
        classRecyclerView.setLayoutManager(class_recycler_view_llm);
        classRecyclerView.setHasFixedSize(true);


        classRecyclerView.setAdapter(classAdapter);
        classAdapter.notifyDataSetChanged();


        btn_save = (FloatingActionButton) view.findViewById(R.id.btn_save);

        kism_txtview = (TextView) view.findViewById(R.id.frg_add_elev_classe_txtv);
        etablissement_txtv = (AutoCompleteTextView)
                view.findViewById(R.id.frg_add_elev_etab_autocomtxtv);

        nom_edittext = (EditText) view.findViewById(R.id.frg_add_elev_nom_elev_editxt);
        niveaux_txtv = (AutoCompleteTextView)
                view.findViewById(R.id.niveaux_txtv);

        // riiiiiiiii9 w barah
        nom_edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                etablissement_txtv.requestFocus();
                return true;
            }
        });

        etablissement_txtv.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                niveaux_txtv.requestFocus();
                return true;
            }
        });

        niveaux_txtv.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                kism_txtview.requestFocus();
                return true;
            }
        });



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


        //


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nom_eleve = nom_edittext.getText().toString();

                if (EditTextUtils.isTextFieldEmpty(nom_edittext) || EditTextUtils.isTextFieldEmpty(etablissement_txtv) || EditTextUtils.isTextFieldEmpty(niveaux_txtv)) {
                    Toast.makeText(baseActivity, getString(R.string.etab_obligatoire), Toast.LENGTH_SHORT).show();
                } else


                {
                    EleveInterfas eleveInterfas = retrofit.create(EleveInterfas.class);
                    // code_parent=469219&etab=1&classe=210&nom_eleve=kerim
                    Log.e("identifiant_parent", identifiant_parent);
                    Log.e(TAG, Constant.code_parent + id_etablissement + "clas" + id_classe + nom_eleve);
                    Call<Error> eleve_service = eleveInterfas.add_eleve(Constant.code_parent, id_etablissement, id_classe, nom_eleve);
                    eleve_service.enqueue(new Callback<Error>() {
                        @Override
                        public void onResponse(Call<Error> call, Response<Error> response) {
                            Toast.makeText(baseActivity, getString(R.string.success_add), Toast.LENGTH_SHORT).show();
                            //  Log.e("eror",response.body().getError());
                            //    btn_save.setBackground(getResources().getColor(R.color.logo_color));
                            btn_save.setImageResource(R.drawable.ic_checked);
                        }

                        @Override
                        public void onFailure(Call<Error> call, Throwable t) {

                            Toast.makeText(baseActivity, getString(R.string.failure_add), Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }
        });
//recupere  identifiant_parent

        if (getArguments().getString("identifiant_parent") != null) {
            identifiant_parent = getArguments().getString("identifiant_parent");
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CodeInterfas codeInterfas = retrofit.create(CodeInterfas.class);
        Call<CodeEtab> codeservice = codeInterfas.get_code();
        codeservice.enqueue(new Callback<CodeEtab>() {
            @Override
            public void onResponse(Call<CodeEtab> call, Response<CodeEtab> response) {
                if (response != null) {
                    CodeEtab codeEtab = response.body();
                    if (codeEtab != null) {
                        Log.e("codeEtab", codeEtab.getCode());
                        Log.e("code crypte", Crypt.crypt(codeEtab.getCode(), "st"));
                        new LoadDataAsync().execute(codeEtab.getCode());

                    }
                }
            }

            @Override
            public void onFailure(Call<CodeEtab> call, Throwable t) {
                Log.e("codeEtab", "FAILURE");
            }
        });


        // setting action on etablissement autocomplete textview

        etablissement_txtv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("onItemClick", id + "");
                id_etablissement = etablissementList.get((int) id).getID();


                ClasseInterfas classeInterfas = retrofit.create(ClasseInterfas.class);
                Log.e("etablise", etablissementList.get((int) id).getID());

                Call<ListClass> codeservice = classeInterfas.get_classes(etablissementList.get((int) id).getID());
                codeservice.enqueue(new Callback<ListClass>() {
                    @Override
                    public void onResponse(Call<ListClass> call, Response<ListClass> response) {
                        if (response != null) {
                            liste_classe = response.body().getListe_classes();
                            Log.e(TAG, "onResponse classe");
                            array_classe = new String[liste_classe.size()];

                            int j = 0;
                            for (Classe classe : liste_classe) {
                                Log.e("classe", classe.getTitre());

                                array_classe[j] = classe.getTitre();
                                j++;

                            }


                        }
                    }

                    @Override
                    public void onFailure(Call<ListClass> call, Throwable t) {
                        Log.e("classe", "FAILURE");
                    }
                });


            }
        });
        // setting the clickListener on niveauTextview


        niveaux_txtv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //cette variable designe le titre de niveua clicked in autocompleteTextView
                String nivau_clicked = liste_niveaux.get((int) id).getTitre();
                String id_ch = id + "";

                int x = Integer.parseInt(id_ch);
                Log.e(TAG, x + "");
                Log.e(TAG, liste_niveaux.get((int) id).getTitre());
                Log.e(TAG, nivau_clicked);
                liste_class_per_recycler.clear();
                if (liste_classe != null)

                {

                    for (Classe classe : liste_classe) {

                        if (classe.getTitre().contains(nivau_clicked)) {
                            Log.e(TAG, nivau_clicked + "contains(nivau_clicked)");
                            Log.e(TAG, classe.getTitre());
                            liste_class_per_recycler.add(classe);
                            classAdapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    Toast.makeText(baseActivity, getString(R.string.etab_obligatoire), Toast.LENGTH_SHORT).show();
                    niveaux_txtv.setText(null);
                }
            }
        });

        //executing the LoadNiveauTask
        new LoadNiveauTask().execute();
    }

    @Override
    public boolean onBackPressed() {
        return true;
    }

    //Listener for the click on claase recycler view
    @Override
    public void onItemClicked(View v, int position) {
        Log.e(TAG, liste_class_per_recycler.get(position).getTitre());
        id_classe = liste_classe.get(position).getID();

    }

    class LoadDataAsync extends AsyncTask<String, Integer, List<Etablissement>> {
        @Override
        protected List<Etablissement> doInBackground(String... params) {

            /*
             BEGIN
             1-getting webserivice reponse for etablissement list
             2-filling the array foe etablissement txtv
             */
            EtablissementIntefas etablissementIntefas = retrofit2.create(EtablissementIntefas.class);
            final Call<ListeEtab> etablissementCall = etablissementIntefas.get_liste_etablissement(Integer.parseInt(params[0]), Crypt.crypt(params[0], "st"));
            etablissementCall.enqueue(new Callback<ListeEtab>() {
                @Override
                public void onResponse(Call<ListeEtab> call, Response<ListeEtab> response) {
                    Log.e("onResponse", "entred");
                    if (response != null) {
                        etablissementList = response.body().getEtablissements();
                        if (etablissementList != null) {
                            array_etablissement = new String[etablissementList.size()];
                            int i = 0;
                            Log.e("liste des etab", etablissementList.get(0).getNomAR());
                            for (Etablissement etablissement : etablissementList) {
                                array_etablissement[i] = etablissement.getNomAR();

                                i++;
                            }
                            Log.e("liste des etab", array_etablissement.toString());
                            ArrayAdapter<String> adapter_etablissement = new ArrayAdapter<String>(baseActivity,
                                    android.R.layout.simple_dropdown_item_1line, array_etablissement);
                            etablissement_txtv.setAdapter(adapter_etablissement);

                        }
                    }
                }

                @Override
                public void onFailure(Call<ListeEtab> call, Throwable t) {


                    Log.e("onFailure", "etablissement ");
                }


            });
              /*
           END
             1-getting webserivice reponse for etablissement list
             2-filling the array foe etablissement txtv
             */

            return null;
        }
    }

    class LoadNiveauTask extends AsyncTask<Void, Void, List<Niveau>> {
        @Override
        protected List<Niveau> doInBackground(Void... params) {
            NiveauInterfas niveauInterfas = retrofit.create(NiveauInterfas.class);
            Call<ListNiveau> niveauService = niveauInterfas.get_niveaux();
            niveauService.enqueue(new Callback<ListNiveau>() {
                @Override
                public void onResponse(Call<ListNiveau> call, Response<ListNiveau> response) {
                    Log.e(TAG, "niveau response");
                    if (response != null) {
                        liste_niveaux = response.body().getNiveau();
                        array_niveaux = new String[liste_niveaux.size()];
                        if (liste_niveaux != null) {
                            for (Niveau niveau : liste_niveaux) {
                                int indexOfniveau = liste_niveaux.indexOf(niveau);
                                Log.e("indexOfniveau", indexOfniveau + "");
                                Log.e("indexOfniveau", niveau.getTitre());
                                array_niveaux[indexOfniveau] = niveau.getTitre();
                            }

                            niveaux_txtv.setAdapter(new ArrayAdapter<String>(baseActivity,
                                    android.R.layout.simple_dropdown_item_1line, array_niveaux));
                        } else {
                            Log.e(TAG, "niveaux null");
                        }
                    }
                }

                @Override
                public void onFailure(Call<ListNiveau> call, Throwable t) {
                    Log.e(TAG, "niveau failure");

                }
            });


            return liste_niveaux;
        }

        // I didn't use his shitty reponse "niveaus" because it's null do u believe that ?!!!!!!!!!!
        @Override
        protected void onPostExecute(List<Niveau> niveaus) {


        }
    }
}
