package com.example.applisys.classetn.API;

import com.example.applisys.classetn.Bean.Parent;
import com.example.applisys.classetn.Bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by applisys on 12/01/17.
 */

public interface UserInterfas {

    @GET("users/{user}")
    Call<User> certeainuser(@Path("user") String user);
}
