package com.jcuentas.inleggo.io.adapter;

import com.jcuentas.inleggo.BuildConfig;
import com.jcuentas.inleggo.io.model.GerenciaResponse;
import com.jcuentas.inleggo.io.service.GerenciaService;
import com.jcuentas.inleggo.soporte.Constantes;

import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by Jose Cuentas Turpo on 22/07/2015 - 03:18 PM.
 * E-mail: jcuentast@gmail.com
 */
public class GerenciaAdapter {

    private static GerenciaService API_SERVICE;

    public static GerenciaService getApiService(){
        if (API_SERVICE==null) {
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(Constantes.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE =  adapter.create(GerenciaService.class);
        }
        return API_SERVICE;
    }
    public static Observable<GerenciaResponse> getGerencias(String db){
        String [] token = ObtTok();
        return getApiService().getGerencias(db, token[0], token[1]);
    }

    private static String[] ObtTok(){
        return new String[]{BuildConfig.US_INLEGGO,BuildConfig.PW_INLEGGO};
//        return new String[]{"66693de8b1137505874542be6c9ef755e7016414","f46b678e9633ed5f49cd66b7a1a30fdd20cd4f94"};
    }


}
