package com.example.applisys.classetn.Bean;

/**
 * Created by applisys on 19/01/17.
 */
//el hazan w nafdhan mta3 webserviece mta3 widhni
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Error {
    @SerializedName("error")
    @Expose
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
