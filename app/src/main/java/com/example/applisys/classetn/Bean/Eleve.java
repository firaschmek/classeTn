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
    @SerializedName("classe_titre")
    @Expose
    private String classeTitre;
    @SerializedName("classe_abrege")
    @Expose
    private String classeAbrege;
    @SerializedName("etab")
    @Expose
    private String etab;
    @SerializedName("etab_code")
    @Expose
    private String etabCode;
    @SerializedName("etab_type")
    @Expose
    private String etabType;
    @SerializedName("etab_ville")
    @Expose
    private String etabVille;
    @SerializedName("etab_nom_AR")
    @Expose
    private String etabNomAR;
    @SerializedName("etab_abrege")
    @Expose
    private String etabAbrege;
    @SerializedName("etab_abrege2")
    @Expose
    private String etabAbrege2;
    @SerializedName("etab_nom_directeur")
    @Expose
    private String etabNomDirecteur;
    @SerializedName("etab_tel")
    @Expose
    private String etabTel;
    @SerializedName("etab_adress_AR")
    @Expose
    private String etabAdressAR;
    @SerializedName("etab_adress_FR")
    @Expose
    private String etabAdressFR;

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

    public String getClasseTitre() {
        return classeTitre;
    }

    public void setClasseTitre(String classeTitre) {
        this.classeTitre = classeTitre;
    }

    public String getClasseAbrege() {
        return classeAbrege;
    }

    public void setClasseAbrege(String classeAbrege) {
        this.classeAbrege = classeAbrege;
    }

    public String getEtab() {
        return etab;
    }

    public void setEtab(String etab) {
        this.etab = etab;
    }

    public String getEtabCode() {
        return etabCode;
    }

    public void setEtabCode(String etabCode) {
        this.etabCode = etabCode;
    }

    public String getEtabType() {
        return etabType;
    }

    public void setEtabType(String etabType) {
        this.etabType = etabType;
    }

    public String getEtabVille() {
        return etabVille;
    }

    public void setEtabVille(String etabVille) {
        this.etabVille = etabVille;
    }

    public String getEtabNomAR() {
        return etabNomAR;
    }

    public void setEtabNomAR(String etabNomAR) {
        this.etabNomAR = etabNomAR;
    }

    public String getEtabAbrege() {
        return etabAbrege;
    }

    public void setEtabAbrege(String etabAbrege) {
        this.etabAbrege = etabAbrege;
    }

    public String getEtabAbrege2() {
        return etabAbrege2;
    }

    public void setEtabAbrege2(String etabAbrege2) {
        this.etabAbrege2 = etabAbrege2;
    }

    public String getEtabNomDirecteur() {
        return etabNomDirecteur;
    }

    public void setEtabNomDirecteur(String etabNomDirecteur) {
        this.etabNomDirecteur = etabNomDirecteur;
    }

    public String getEtabTel() {
        return etabTel;
    }

    public void setEtabTel(String etabTel) {
        this.etabTel = etabTel;
    }

    public String getEtabAdressAR() {
        return etabAdressAR;
    }

    public void setEtabAdressAR(String etabAdressAR) {
        this.etabAdressAR = etabAdressAR;
    }

    public String getEtabAdressFR() {
        return etabAdressFR;
    }

    public void setEtabAdressFR(String etabAdressFR) {
        this.etabAdressFR = etabAdressFR;
    }

}
