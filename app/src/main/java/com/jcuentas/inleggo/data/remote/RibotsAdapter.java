package com.jcuentas.inleggo.data.remote;

import retrofit.RestAdapter;

/**
 * Created by Jose Cuentas Turpo on 09/07/2015 - 04:22 PM.
 * E-mail: jcuentast@gmail.com
 */
public class RibotsAdapter {

    private static RibotsService API_SERVICE;

    public static RibotsService getApiServiceJC() {
        if (API_SERVICE ==null) {
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(RibotsService.ENDPOINT)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE = adapter.create(RibotsService.class);
        }
        return API_SERVICE;
    }

}
