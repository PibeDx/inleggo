package com.jcuentas.inleggo.data.db.dao;

import android.database.Cursor;

import com.jcuentas.inleggo.data.db.DBHelper;
import com.jcuentas.inleggo.data.model.Gerencia;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by Jose Cuentas Turpo on 22/07/2015 - 06:13 PM.
 * E-mail: jcuentast@gmail.com
 */
public class GerenciaDao extends BaseDao<Gerencia, Integer> {
    public GerenciaDao(DBHelper dbHelper, Class<Gerencia> c) {
        super(dbHelper, c);
    }

    @Override
    public long actualizar(Gerencia entidad) {
        return 0;
    }

    @Override
    public long crear(Gerencia entidad)  {

        return 0;
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
        return null;
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
