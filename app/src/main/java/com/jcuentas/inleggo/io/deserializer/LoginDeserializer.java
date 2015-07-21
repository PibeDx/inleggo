package com.jcuentas.inleggo.io.deserializer;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.jcuentas.inleggo.data.model.Servers;

import java.lang.reflect.Type;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 02:52 PM.
 * E-mail: jcuentast@gmail.com
 */
public class LoginDeserializer implements JsonDeserializer<Servers> {


    @Override
    public Servers deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject serverData = json.getAsJsonObject();
        Servers servers = Servers.buildServersFromJson(serverData);
        Log.d("asd", json.toString());
        return servers;
    }
}
