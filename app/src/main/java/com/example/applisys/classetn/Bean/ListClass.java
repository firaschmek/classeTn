package com.example.applisys.classetn.Bean;

/**
 * Created by applisys on 18/01/17.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ListClass {

    @SerializedName("classes")
    @Expose
    private List<Classe> liste_classes ;

    public List<Classe> getListe_classes() {
        return liste_classes;
    }

    public void setListe_classes(List<Classe> liste_classes) {
        this.liste_classes = liste_classes;
    }
}
