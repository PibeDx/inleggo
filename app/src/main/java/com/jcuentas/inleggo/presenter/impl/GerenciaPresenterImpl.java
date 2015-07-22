package com.jcuentas.inleggo.presenter.impl;

import android.app.Activity;

import com.jcuentas.inleggo.interactor.GerenciaInteractor;
import com.jcuentas.inleggo.interactor.impl.GerenciaInteractorImpl;
import com.jcuentas.inleggo.presenter.GerenciaPresenter;
import com.jcuentas.inleggo.view.GerenciaView;

/**
 * Created by Jose Cuentas Turpo on 22/07/2015 - 05:56 PM.
 * E-mail: jcuentast@gmail.com
 */
public class GerenciaPresenterImpl implements GerenciaPresenter {
    GerenciaView mGerenciaView;
    GerenciaInteractor mGerenciaInteractor;
    public GerenciaPresenterImpl(GerenciaView gerenciaView, Activity activity) {
        mGerenciaView = gerenciaView;
        mGerenciaInteractor= new GerenciaInteractorImpl(activity,gerenciaView);
    }

    @Override
    public void validateCargaInfo() {
        mGerenciaInteractor.cargarSP();
    }
}
