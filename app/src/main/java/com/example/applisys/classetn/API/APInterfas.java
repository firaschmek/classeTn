package com.example.applisys.classetn.API;

/**
 * Created by applisys on 10/01/17.
 */


import com.example.applisys.classetn.Bean.Parent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APInterfas {

    @GET("/get_classe_parent.php?code={code}")
    Call<Parent> showParent(@Query("code") String code);


}
