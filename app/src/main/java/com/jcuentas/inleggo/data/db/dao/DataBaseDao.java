package com.jcuentas.inleggo.data.db.dao;

import android.database.Cursor;
import android.util.Log;

import com.jcuentas.inleggo.data.db.DBHelper;
import com.jcuentas.inleggo.data.model.DataBase;

import org.json.JSONArray;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 05:07 PM.
 * E-mail: jcuentast@gmail.com
 */
public class DataBaseDao extends BaseDao<DataBase, Integer>{
    public DataBaseDao(DBHelper dbHelper, Class<DataBase> c) {
        super(dbHelper, c);
    }

    @Override
    public long actualizar(DataBase entidad) {
        return 0;
    }

    @Override
    public long crear(DataBase entidad) {
        long cantInsert = 0;
        try {
            getDao().create(entidad);
            cantInsert = 1;
        } catch (SQLException e) {
            Log.e(TAG, "crear:  Error");
            e.printStackTrace();
        }
        return cantInsert;
    }

    @Override
    public void actualizarIds(JSONArray array) {

    }

    @Override
    public DataBase obtenerPorId(Integer llave) {
        return null;
    }

    @Override
    public List<DataBase> obtenerTodos() {
        List<DataBase> dataBases = null;
        try {
            dataBases = getDao().queryForAll();
        } catch (SQLException e) {
            Log.i(TAG, "obtenerTodos: Error");
            e.printStackTrace();
        }
        return dataBases;
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
    protected DataBase obtenerDesdeCursor(Cursor cursor) {
        return null;
    }
}
