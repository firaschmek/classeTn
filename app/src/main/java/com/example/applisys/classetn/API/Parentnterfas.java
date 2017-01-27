package com.example.applisys.classetn.API;

/**
 * Created by applisys on 10/01/17.
 */


import com.example.applisys.classetn.Bean.Parent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Parentnterfas {

    @GET("get_parent.php")
    Call<Parent> showParent(@Query("code") String phone);

    @GET("get_submit_parent.php")
    Call<Parent> addParent(@Query("tel") String phone,@Query("email") String email);
}
