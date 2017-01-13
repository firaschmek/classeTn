package com.example.applisys.classetn.Bean;

/**
 * Created by applisys on 10/01/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Eleve {

    @SerializedName("nom_eleve")
    @Expose
    private String nomEleve;
    @SerializedName("classe")
    @Expose
    private String classe;
    @SerializedName("etab")
    @Expose
    private String etab;

    public Eleve(String nomEleve, String classe, String etab) {
        this.nomEleve = nomEleve;
        this.classe = classe;
        this.etab = etab;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEtab() {
        return etab;
    }

    public void setEtab(String etab) {
        this.etab = etab;
    }

}
