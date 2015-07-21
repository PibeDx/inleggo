package com.jcuentas.inleggo.data.db.dao;

import android.database.Cursor;

import com.jcuentas.inleggo.data.db.DBHelper;

import org.json.JSONArray;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 05:07 PM.
 * E-mail: jcuentast@gmail.com
 */
public class DataBaseDao extends BaseDao<BaseDao, Integer> {
    public DataBaseDao(DBHelper dbHelper, Class<BaseDao> c) {
        super(dbHelper, c);
    }

    @Override
    public long actualizar(BaseDao entidad) {
        return 0;
    }

    @Override
    public long crear(BaseDao entidad) throws SQLException {
        return 0;
    }

    @Override
    public void actualizarIds(JSONArray array) {

    }

    @Override
    public BaseDao obtenerPorId(Integer llave) {
        return null;
    }

    @Override
    public List<BaseDao> obtenerTodos() {
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
    protected BaseDao obtenerDesdeCursor(Cursor cursor) {
        return null;
    }
}
