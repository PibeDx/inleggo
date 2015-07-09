package com.jcuentas.inleggo.data.remote;

import android.util.Log;

import com.jcuentas.inleggo.data.model.Ribot;
import com.jcuentas.inleggo.view.RibotView;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Jose Cuentas Turpo on 09/07/2015 - 04:43 PM.
 * E-mail: jcuentast@gmail.com
 */
public class RibotsImpl implements Callback<List<Ribot>> {

    private static final String TAG = "RibotsImpl";
    List<Ribot> ribots;
    RibotView ribotView;

    public RibotsImpl(RibotView ribotView) {
        RibotsAdapter.getApiServiceJC().getRibots(this);
        this.ribotView =ribotView;
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }

    @Override
    public void success(List<Ribot> ribots, Response response) {
        Log.d(TAG, "cantidad: " + ribots.size());
        this.ribots = ribots;
        ribotView.setSp1(ribots);
        ribotView.setMensaje(""+ribots.size());
    }

    public List<Ribot> getRibots() {
        return ribots;
    }
}
