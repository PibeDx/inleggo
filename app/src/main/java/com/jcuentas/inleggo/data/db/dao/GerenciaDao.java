package com.jcuentas.inleggo.data.db.dao;

import android.database.Cursor;
import android.util.Log;

import com.jcuentas.inleggo.data.db.DBHelper;
import com.jcuentas.inleggo.data.model.Gerencia;

import org.json.JSONArray;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jose Cuentas Turpo on 22/07/2015 - 06:13 PM.
 * E-mail: jcuentast@gmail.com
 */
public class GerenciaDao extends BaseDao<Gerencia, Integer> {
//    public static final String TAG = "GerenciaDao";
    public GerenciaDao(DBHelper dbHelper, Class<Gerencia> c) {
        super(dbHelper, c);
    }

    @Override
    public long actualizar(Gerencia entidad) {
        int cantUpdate = 0;
        try {
            cantUpdate=getDao().update(entidad);
        } catch (SQLException e) {
            Log.e(TAG, "actualizar: Error");
            e.printStackTrace();
        }
        return cantUpdate;
    }

    @Override
    public long crear(Gerencia entidad) {
        long cantInsert = 0;
        try {
            getDao().create(entidad);
            cantInsert = 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cantInsert;
    }

    @Override
    public void actualizarIds(JSONArray array) {

    }

    @Override
    public Gerencia obtenerPorId(Integer llave) {
        return null;
    }

    @Override
    public List<Gerencia> obtenerTodos() {
        List<Gerencia> gerencias = null;
        try {
            gerencias = getDao().queryForAll();
        } catch (SQLException e) {
            Log.e(TAG, "obtenerTodos: Error al obtener informacion");
            e.printStackTrace();
        }
        Log.i(TAG, "obtenerTodos: Obtener informacion");
        return gerencias;
    }

    @Override
    public boolean eliminarPorId(Integer llave) {
        return false;
    }

    @Override
    public boolean eliminarTodos() {
        return false;
    }

    @Override
    protected Gerencia obtenerDesdeCursor(Cursor cursor) {
        return null;
    }
}
