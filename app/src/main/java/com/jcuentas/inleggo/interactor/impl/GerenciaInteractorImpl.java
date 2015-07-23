package com.jcuentas.inleggo.interactor.impl;

import android.app.Activity;
import android.util.Log;

import com.jcuentas.inleggo.data.db.DBHelper;
import com.jcuentas.inleggo.data.db.dao.GerenciaDao;
import com.jcuentas.inleggo.data.model.Gerencia;
import com.jcuentas.inleggo.interactor.GerenciaInteractor;
import com.jcuentas.inleggo.io.adapter.GerenciaAdapter;
import com.jcuentas.inleggo.io.model.GerenciaResponse;
import com.jcuentas.inleggo.view.GerenciaView;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Jose Cuentas Turpo on 22/07/2015 - 04:41 PM.
 * E-mail: jcuentast@gmail.com
 */
public class GerenciaInteractorImpl  implements GerenciaInteractor{

    DBHelper mHelper;
    GerenciaDao mGerenciaDao;
    GerenciaView mGerenciaView;


    public GerenciaInteractorImpl(Activity activity,GerenciaView gerenciaView) {
        mHelper = new DBHelper(activity);
        mGerenciaDao = new GerenciaDao(mHelper, Gerencia.class);
        mGerenciaView = gerenciaView;
    }

    public static final String TAG = "GerenciaInteractorImpl";
    @Override
    public void cargarSP() {
        cargarGerencia();
        //gerenciaView.setMensaje();
        mGerenciaView.setListCaptura();
        mGerenciaView.setListSede();
        //gerenciaView.setListGerencia();
        mGerenciaView.setListArea();
        mGerenciaView.setListEquipo();
        mGerenciaView.setListLocal();
        mGerenciaView.setListPiso();
        mGerenciaView.setListUbicacion();
        mGerenciaView.setListUsuario();
        mGerenciaView.setListProyecto();


    }

    void cargarGerencia(){
        ArrayList<Gerencia> gerencias = (ArrayList<Gerencia>) mGerenciaDao.obtenerTodos();
        if (gerencias!= null)
            if (gerencias.isEmpty()) {
                Log.i(TAG, "onResume: Se llena la informacion por el Servicio");
                ejecutarServicioServer();
            } else {
                Log.i(TAG, "onResume: Se llena la informacion por SQLite");
                mGerenciaView.setListGerencia(gerencias);
            }
        else {
            Log.i(TAG, "onResume: Se llena la informacion por el Servicio");
            ejecutarServicioServer();
        }
    }


    private void ejecutarServicioServer() {
        GerenciaAdapter.getGerencias("inleggo_test_2014")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GerenciaResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(GerenciaResponse gerenciaResponse) {
                        Log.i(TAG, "asdasd: " + gerenciaResponse.getGerencias().size());
                        DBInsertarGerencia(gerenciaResponse);
                        mGerenciaView.setListGerencia(gerenciaResponse.getGerencias());
                    }
                });
    }

    private void DBInsertarGerencia(GerenciaResponse gerenciaResponse) {
        ArrayList<Gerencia> gerencias =gerenciaResponse.getGerencias();
        for (Gerencia gerencia : gerencias) {
            mGerenciaDao.crear(gerencia);
        }
    }

}
