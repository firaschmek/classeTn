package com.example.applisys.classetn.Bean;

/**
 * Created by applisys on 16/01/17.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ListeEtab {

    @SerializedName("etablissements")
    @Expose
    private List<Etablissement> etablissements = null;

    public List<Etablissement> getEtablissements() {
        return etablissements;
    }

    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }
}
