package com.jcuentas.inleggo.data.db;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.jcuentas.inleggo.data.model.Server;

import java.sql.SQLException;


/**
 * Created by Jos? Cuentas Turpo on 10/06/2015 - 10:11 AM.
 * E-mail: jcuentast@gmail.com
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "db.inleggo.com";
    private static final int DATABASE_VERSION = 2;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
        try {
            TableUtils.createTable(connectionSource, Server.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
                          int arg3) {
        try {
			TableUtils.dropTable(connectionSource, Server.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(arg0, connectionSource);
    }

    @Override
    public void close() {
        super.close();
    }


}


