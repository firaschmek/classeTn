package com.example.applisys.classetn.API;

import com.example.applisys.classetn.Bean.Classe;
import com.example.applisys.classetn.Bean.CodeEtab;
import com.example.applisys.classetn.Bean.ListClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by applisys on 17/01/17.
 */

public interface ClasseInterfas {

    @GET("get_classes.php")
    Call<ListClass> get_classes(@Query("etab") String etab);
}
