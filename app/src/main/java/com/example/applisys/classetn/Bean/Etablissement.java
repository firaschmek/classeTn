package com.example.applisys.classetn.Bean;

/**
 * Created by applisys on 10/01/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Etablissement {
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("ville")
    @Expose
    private String ville;
    @SerializedName("nom_AR")
    @Expose
    private String nomAR;
    @SerializedName("abrege")
    @Expose
    private String abrege;
    @SerializedName("abrege2")
    @Expose
    private String abrege2;
    @SerializedName("nom_directeur")
    @Expose
    private String nomDirecteur;
    @SerializedName("adress_FR")
    @Expose
    private String adressFR;
    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("adress_AR")
    @Expose
    private String adressAR;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNomAR() {
        return nomAR;
    }

    public void setNomAR(String nomAR) {
        this.nomAR = nomAR;
    }

    public String getAbrege() {
        return abrege;
    }

    public void setAbrege(String abrege) {
        this.abrege = abrege;
    }

    public String getAbrege2() {
        return abrege2;
    }

    public void setAbrege2(String abrege2) {
        this.abrege2 = abrege2;
    }

    public String getNomDirecteur() {
        return nomDirecteur;
    }

    public void setNomDirecteur(String nomDirecteur) {
        this.nomDirecteur = nomDirecteur;
    }

    public String getAdressFR() {
        return adressFR;
    }

    public void setAdressFR(String adressFR) {
        this.adressFR = adressFR;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdressAR() {
        return adressAR;
    }

    public void setAdressAR(String adressAR) {
        this.adressAR = adressAR;
    }

}
