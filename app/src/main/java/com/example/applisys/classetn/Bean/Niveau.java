package com.example.applisys.classetn.Bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by applisys on 25/01/17.
 */

public class Niveau {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("titre")
    @Expose
    private String titre;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

}