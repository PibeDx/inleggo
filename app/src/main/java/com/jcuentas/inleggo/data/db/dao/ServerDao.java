package com.jcuentas.inleggo.data.db.dao;

import android.database.Cursor;
import android.util.Log;

import com.jcuentas.inleggo.data.db.DBHelper;
import com.jcuentas.inleggo.data.model.Server;

import org.json.JSONArray;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 04:53 PM.
 * E-mail: jcuentast@gmail.com
 */
public class ServerDao extends BaseDao<Server, String> {
//    public static final String TAG = "ServerDao";

    public ServerDao(DBHelper dbHelper, Class<Server> c) {
        super(dbHelper, c);
    }

    @Override
    public long actualizar(Server entidad) {
        return 0;
    }

    @Override
    public long crear(Server entidad) {
        long cantInsert = 0;
        try {
            getDao().create(entidad);
            cantInsert = 1;
        } catch (Exception e) {
            e.printStackTrace();
            cantInsert = 0;
        }
        return cantInsert;
    }

    @Override
    public void actualizarIds(JSONArray array) {

    }

    @Override
    public Server obtenerPorId(String llave) {
        return null;
    }

    @Override
    public List<Server> obtenerTodos() {
        List<Server> servers = null;
        try{
            servers = getDao().queryForAll();
        }catch (SQLException e){
            Log.e(TAG, "obtenerTodos: Error al obtener informacion");
        }
        return servers;
    }

    @Override
    public boolean eliminarPorId(String llave) {
        return false;
    }

    @Override
    public boolean eliminarTodos() {
        return false;
    }

    @Override
    protected Server obtenerDesdeCursor(Cursor cursor) {
        return null;
    }
}
