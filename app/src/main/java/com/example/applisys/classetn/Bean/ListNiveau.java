package com.example.applisys.classetn.Bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by applisys on 25/01/17.
 */

public class ListNiveau {
    @SerializedName("niveau")
    @Expose
    private List<Niveau> niveau = null;

    public List<Niveau> getNiveau() {
        return niveau;
    }

    public void setNiveau(List<Niveau> niveau) {
        this.niveau = niveau;
    }

}
