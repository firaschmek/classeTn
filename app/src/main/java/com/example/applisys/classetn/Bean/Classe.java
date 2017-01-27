package com.example.applisys.classetn.Bean;

/**
 * Created by applisys on 17/01/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Classe {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("abrege")
    @Expose
    private String abrege;
    @SerializedName("titre")
    @Expose
    private String titre;
    @SerializedName("niveau")
    @Expose
    private String niveau;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getAbrege() {
        return abrege;
    }

    public void setAbrege(String abrege) {
        this.abrege = abrege;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }



}
