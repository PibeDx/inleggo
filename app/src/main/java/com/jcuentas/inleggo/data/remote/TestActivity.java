package com.jcuentas.inleggo.data.remote;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.jcuentas.inleggo.view.RibotView;

import java.util.List;

/**
 * Created by Jose Cuentas Turpo on 09/07/2015 - 04:46 PM.
 * E-mail: jcuentast@gmail.com
 */
public class TestActivity extends Activity implements RibotView {
    public static final String TAG = "TestActivity";
    RibotsImpl ribots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ribots = new RibotsImpl(this);
    }

    @Override
    public void setMensaje(String mensaje) {
        Log.d(TAG,mensaje);
    }

    @Override
    public void setSp1(List list) {

    }
}
