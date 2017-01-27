package com.example.applisys.classetn.API;

import com.example.applisys.classetn.Bean.ListClass;
import com.example.applisys.classetn.Bean.ListNiveau;
import com.example.applisys.classetn.Bean.Niveau;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by applisys on 25/01/17.
 */

public interface NiveauInterfas {
    @GET("get_niveau.php")
    Call<ListNiveau> get_niveaux();
}
