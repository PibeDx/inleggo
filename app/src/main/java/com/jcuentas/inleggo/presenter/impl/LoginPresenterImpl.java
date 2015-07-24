package com.jcuentas.inleggo.presenter.impl;

import android.app.Activity;

import com.jcuentas.inleggo.interactor.LoginInteractor;
import com.jcuentas.inleggo.interactor.impl.LoginInteractorImpl;
import com.jcuentas.inleggo.presenter.LoginPresenter;
import com.jcuentas.inleggo.view.LoginView;

/**
 * Created by Pibe on 23/07/2015.
 */
public class LoginPresenterImpl implements LoginPresenter{

    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView, Activity activity) {
        mLoginView = loginView;
        mLoginInteractor = new LoginInteractorImpl(mLoginView, activity);
    }

    @Override
    public void validateLogin(String user, String pass) {
        mLoginInteractor.login(user,pass);
    }
}
