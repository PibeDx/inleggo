package com.jcuentas.inleggo.io.adapter;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcuentas.inleggo.BuildConfig;
import com.jcuentas.inleggo.data.model.Servers;
import com.jcuentas.inleggo.io.deserializer.LoginDeserializer;
import com.jcuentas.inleggo.io.model.ServersResponse;
import com.jcuentas.inleggo.io.service.LoginService;
import com.jcuentas.inleggo.soporte.Constantes;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 11:41 AM.
 * E-mail: jcuentast@gmail.com
 */
public class LoginAdapter {
    private static LoginService API_SERVICE;

    public static LoginService getApiService(){
        if (API_SERVICE==null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(Constantes.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    //.setConverter(buildServersApiGsonConverter())
                    .build();

            API_SERVICE = adapter.create(LoginService.class);
        }
        return API_SERVICE;
    }

    private static GsonConverter buildServersApiGsonConverter(){
        Gson gsonConfig = new GsonBuilder()
                .registerTypeAdapter(Servers.class, new LoginDeserializer())
                .create();
        return new GsonConverter(gsonConfig);
    }

    public static Observable<ServersResponse> getServers(){
        String[] token = ObtTok();
        return getApiService().getServers(token[0], token[1]);
    }

    private static String[] ObtTok(){
        return new String[]{BuildConfig.US_INLEGGO,BuildConfig.PW_INLEGGO};
//        return new String[]{"66693de8b1137505874542be6c9ef755e7016414","f46b678e9633ed5f49cd66b7a1a30fdd20cd4f94"};
    }

}

