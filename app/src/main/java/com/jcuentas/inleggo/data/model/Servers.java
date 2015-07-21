package com.jcuentas.inleggo.data.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.jcuentas.inleggo.io.JsonKeys;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 10:50 AM.
 * E-mail: jcuentast@gmail.com
 */

@DatabaseTable
public class Servers {
    public static final String ID = "idServers";
    public static final String NO_EMPRESA = "noEmpresa";


    @SerializedName(JsonKeys.SERVER_ID)
    @DatabaseField(columnName = ID)
    public String mId;

    @SerializedName(JsonKeys.SERVER_NO_EMPRESA)
    @DatabaseField(columnName = NO_EMPRESA)
    public String mNoEmpresa;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getNoEmpresa() {
        return mNoEmpresa;
    }

    public void setNoEmpresa(String noEmpresa) {
        mNoEmpresa = noEmpresa;
    }

    public static Servers buildServersFromJson(JsonObject artistData) {
        Gson gson = new Gson();
        return gson.fromJson(artistData, Servers.class);
    }
}
