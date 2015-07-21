package com.jcuentas.inleggo.data.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 04:54 PM.
 * E-mail: jcuentast@gmail.com
 */
@DatabaseTable
public class DataBase {
    public static final String ID = "idDataBase";
    public static final String NO_TABLE = "noTable";
    public static final String FE_CREATE = "feCreate";
    public static final String FE_UPDATE_ANTERIOR = "feUpdateAnterior";
    public static final String FE_UPDATE_ULTIMA = "feUpdateUltima";
    public static final String FE_ULTIMO_INTENTO_UPDATE = "feUltimoIntentoUpdate";
    public static final String FE_ULTIMA_CONEXION = "feUltimaConexion";


    @DatabaseField(generatedId = true, columnName = ID)
    private int idTable;
    @DatabaseField(columnName = NO_TABLE)
    private String noTable;
    @DatabaseField(columnName = FE_CREATE)
    private String feCreate;
    @DatabaseField(columnName = FE_UPDATE_ANTERIOR)
    private String feUpdateAnterior;
    @DatabaseField(columnName = FE_UPDATE_ULTIMA)
    private String feUpdateUltima;
    @DatabaseField(columnName = FE_ULTIMO_INTENTO_UPDATE)
    private String feUltimoIntentoUpdate;
    @DatabaseField(columnName = FE_ULTIMA_CONEXION)
    private String feUltimaConexion; // Ultima conexion con internet;


    public String getFeCreate() {
        return feCreate;
    }

    public void setFeCreate(String feCreate) {
        this.feCreate = feCreate;
    }

    public String getFeUltimaConexion() {
        return feUltimaConexion;
    }

    public void setFeUltimaConexion(String feUltimaConexion) {
        this.feUltimaConexion = feUltimaConexion;
    }

    public String getFeUltimoIntentoUpdate() {
        return feUltimoIntentoUpdate;
    }

    public void setFeUltimoIntentoUpdate(String feUltimoIntentoUpdate) {
        this.feUltimoIntentoUpdate = feUltimoIntentoUpdate;
    }

    public String getFeUpdateAnterior() {
        return feUpdateAnterior;
    }

    public void setFeUpdateAnterior(String feUpdateAnterior) {
        this.feUpdateAnterior = feUpdateAnterior;
    }

    public String getFeUpdateUltima() {
        return feUpdateUltima;
    }

    public void setFeUpdateUltima(String feUpdateUltima) {
        this.feUpdateUltima = feUpdateUltima;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public String getNoTable() {
        return noTable;
    }

    public void setNoTable(String noTable) {
        this.noTable = noTable;
    }
}
