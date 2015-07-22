package com.jcuentas.inleggo.io.service;


import com.jcuentas.inleggo.io.model.ServersResponse;
import com.jcuentas.inleggo.soporte.Constantes;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Jose Cuentas Turpo on 20/07/2015 - 03:34 PM.
 * E-mail: jcuentast@gmail.com
 */
public interface LoginService {

    @GET(Constantes.URL_LOGIN_SERVERS)
    Observable<ServersResponse> getServers(@Query(Constantes.PARAN_USER) String user,
                                           @Query(Constantes.PARAN_PASS) String pass);
}
