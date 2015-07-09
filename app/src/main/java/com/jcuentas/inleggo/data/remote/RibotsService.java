package com.jcuentas.inleggo.data.remote;

import com.jcuentas.inleggo.data.model.Ribot;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Jose Cuentas Turpo on 09/07/2015 - 04:05 PM.
 * E-mail: jcuentast@gmail.com
 */
public interface RibotsService {
    String ENDPOINT = "https://ribots-api.ribot.io";

    @GET("/ribots")
    void getRibots (Callback<List<Ribot>> serverResponse);

}
