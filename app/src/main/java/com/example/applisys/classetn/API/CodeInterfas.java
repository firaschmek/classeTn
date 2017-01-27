package com.example.applisys.classetn.API;

import com.example.applisys.classetn.Bean.CodeEtab;
import com.example.applisys.classetn.Bean.Eleve;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by applisys on 16/01/17.
 */

public interface CodeInterfas {

    @GET("get_etablissements.php")
    Call<CodeEtab> get_code();
}
