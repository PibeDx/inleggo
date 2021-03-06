package com.jcuentas.inleggo.io.model;

import com.google.gson.annotations.SerializedName;
import com.jcuentas.inleggo.io.JsonKeys;
import com.jcuentas.inleggo.data.model.Server;

import java.util.ArrayList;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 12:37 PM.
 * E-mail: jcuentast@gmail.com
 */
public class ServersResponse {
    @SerializedName(JsonKeys.SERVER_RESPONSE)
    private ArrayList<Server> mServers;
    public ArrayList<Server> getServers() {
        return mServers;
    }

    public void setServers(ArrayList<Server> servers) {
        mServers = servers;
    }

    private class MainResponse {


    }
}
