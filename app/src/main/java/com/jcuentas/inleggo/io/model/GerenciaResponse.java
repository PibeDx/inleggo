package com.jcuentas.inleggo.io.model;

import com.google.gson.annotations.SerializedName;
import com.jcuentas.inleggo.data.model.Gerencia;
import com.jcuentas.inleggo.io.JsonKeys;

import java.util.ArrayList;

/**
 * Created by Jose Cuentas Turpo on 22/07/2015 - 12:57 PM.
 * E-mail: jcuentast@gmail.com
 */
public class GerenciaResponse {

    @SerializedName(JsonKeys.GERENCIA_RESPONSE)
    private ArrayList<Gerencia> mGerencias;

    public ArrayList<Gerencia> getGerencias() {
        return mGerencias;
    }

    public void setGerencias(ArrayList<Gerencia> gerencias) {
        mGerencias = gerencias;
    }
}
