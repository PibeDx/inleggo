package com.jcuentas.inleggo.view;

import com.jcuentas.inleggo.data.model.Server;

import java.util.List;

/**
 * Created by Pibe on 23/07/2015.
 */
public interface LoginView {
    void goToMain();
    void cargarServers(List servers);
    String obtenerSelectItemServers();
    void setMennsaje(String mensaje);
    Server getSelectItemServere();

}
