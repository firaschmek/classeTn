package com.example.applisys.classetn.Bean;

/**
 * Created by applisys on 10/01/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Parent {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("eleves")
    @Expose
    private List<Eleve> eleves = null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
}
