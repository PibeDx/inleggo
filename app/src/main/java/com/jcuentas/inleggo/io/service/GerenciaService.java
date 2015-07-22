package com.jcuentas.inleggo.io.service;

import com.jcuentas.inleggo.io.model.GerenciaResponse;
import com.jcuentas.inleggo.soporte.Constantes;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Jose Cuentas Turpo on 22/07/2015 - 12:59 PM.
 * E-mail: jcuentast@gmail.com
 */
public interface GerenciaService {

    @GET(Constantes.URL_CAPTURA_GERENCIA_LIST)
    Observable<GerenciaResponse> getGerencias (@Query(Constantes.PARAN_DB) String db,
                                               @Query(Constantes.PARAN_USER) String user,
                                               @Query(Constantes.PARAN_PASS)String pass);
}
