package com.jcuentas.inleggo.interactor.impl;

import android.util.Log;

import com.jcuentas.inleggo.interactor.GerenciaInteractor;
import com.jcuentas.inleggo.io.adapter.GerenciaAdapter;
import com.jcuentas.inleggo.io.model.GerenciaResponse;
import com.jcuentas.inleggo.view.GerenciaView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Jose Cuentas Turpo on 22/07/2015 - 04:41 PM.
 * E-mail: jcuentast@gmail.com
 */
public class GerenciaInteractorImpl  implements GerenciaInteractor{
    public static final String TAG = "GerenciaInteractorImpl";
    @Override
    public void cargarSP(GerenciaView gerenciaView) {
        cargarGerencia(gerenciaView);
        //gerenciaView.setMensaje();
        gerenciaView.setListCaptura();
        gerenciaView.setListSede();
        //gerenciaView.setListGerencia();
        gerenciaView.setListArea();
        gerenciaView.setListEquipo();
        gerenciaView.setListLocal();
        gerenciaView.setListPiso();
        gerenciaView.setListUbicacion();
        gerenciaView.setListUsuario();
        gerenciaView.setListProyecto();


    }

    void cargarGerencia(final GerenciaView gerenciaView){
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
                        gerenciaView.setListGerencia(gerenciaResponse.getGerencias());
                        gerenciaView.setMensaje(""+gerenciaResponse.getGerencias().size());
                    }
                });
    }
}
