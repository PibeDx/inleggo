package com.jcuentas.inleggo.data.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.jcuentas.inleggo.io.JsonKeys;

/**
 * Created by Jose Cuentas Turpo on 13/07/2015 - 06:12 PM.
 * E-mail: jcuentast@gmail.com
 */
@DatabaseTable
public class Gerencia {

    public static final String ID = "idGerencia";
    public static final String NO_GERENCIA = "noGerencia";

    @SerializedName(JsonKeys.GERENCIA_ID)
    @DatabaseField(columnName = ID)
    private int mId;
    @SerializedName(JsonKeys.GERENCIA_NAME)
    @DatabaseField(columnName = NO_GERENCIA)
    private String mNoGerencia;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getNoGerencia() {
        return mNoGerencia;
    }

    public void setNoGerencia(String noGerencia) {
        mNoGerencia = noGerencia;
    }

    public static Gerencia buildGerenciaFromJson(JsonObject gerenciaData) {
        return new Gson().fromJson(gerenciaData, Gerencia.class);
    }

}
