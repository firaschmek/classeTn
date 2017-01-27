package com.example.applisys.classetn.Bean;

/**
 * Created by applisys on 16/01/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class CodeEtab {

    @SerializedName("code")
    @Expose
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
