package com.jcuentas.inleggo.interactor.impl;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.util.Log;

import com.jcuentas.inleggo.data.db.DBHelper;
import com.jcuentas.inleggo.data.db.dao.ServerDao;
import com.jcuentas.inleggo.data.model.Server;
import com.jcuentas.inleggo.interactor.LoginInteractor;
import com.jcuentas.inleggo.io.adapter.LoginAdapter;
import com.jcuentas.inleggo.io.model.ServersResponse;
import com.jcuentas.inleggo.ui.adapter.ServerAdapter;
import com.jcuentas.inleggo.view.LoginView;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Pibe on 23/07/2015.
 */
public class LoginInteractorImpl implements LoginInteractor {
    public static final String TAG = "LoginInteractorImpl";

    LoginView mLoginView;
    DBHelper mDBHelper;
    ServerDao mServerDao;


    public LoginInteractorImpl(LoginView loginView, Activity activity) {
        mLoginView = loginView;
        mDBHelper = new DBHelper(activity);
        mServerDao = new ServerDao(mDBHelper, Server.class);
        validateServerInSQLite();
    }

    @Override
    public void login(String user, String pass) {
        boolean isValidate = true;
        if (user.isEmpty() && isValidate){
            mLoginView.setMennsaje("Error User");
            isValidate = false;
        }
        if (pass.isEmpty() && isValidate) {
            mLoginView.setMennsaje("Error Pass");
            isValidate = false;
        }
        if (mLoginView.obtenerSelectItemServers().isEmpty() && isValidate){
            mLoginView.setMennsaje("Error ObtenerServers");
            isValidate = false;
        }
        if (isValidate){
            mLoginView.goToMain();
        }
    }


    void cargarServers(){
        LoginAdapter.getServers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ServersResponse>() {
                    @Override
                    public void call(ServersResponse serversResponse) {
                        //Insertamos Datos
                        DBInsertarServer(serversResponse);
                        mLoginView.cargarServers(serversResponse.getServers());
                    }
                });
    }

    private void DBInsertarServer(ServersResponse serversResponse) {
        ArrayList<Server> servers =serversResponse.getServers();
        for (Server server : servers) {
            mServerDao.crear(server);
        }
    }

    void validateServerInSQLite(){
        ArrayList<Server> servers = (ArrayList<Server>) mServerDao.obtenerTodos();
        if (servers!=null) {
            if (servers.isEmpty()) {
                Log.i(TAG, "validateServerInSQLite: Se llena la informacion por el Servicio");
                cargarServers();
            } else {
                Log.i(TAG, "validateServerInSQLite: Se llena la informacion por SQLite");
                mLoginView.cargarServers(servers);
            }
        }else{
            Log.i(TAG, "validateServerInSQLite: Se llena la informacion por SQLite");
            mLoginView.cargarServers(servers);
        }


    }
}
