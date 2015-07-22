package com.jcuentas.inleggo.data.remote;

import android.util.Log;

import com.jcuentas.inleggo.io.adapter.GerenciaAdapter;
import com.jcuentas.inleggo.io.model.GerenciaResponse;
import com.jcuentas.inleggo.view.RibotView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Jose Cuentas Turpo on 09/07/2015 - 04:43 PM.
 * E-mail: jcuentast@gmail.com
 */
public class RibotsImpl /*implements Callback<List<Ribot>> */{

    private static final String TAG = "RibotsImpl";
//    List<Ribot> ribots;
    RibotView ribotView;

    public RibotsImpl(final RibotView ribotView) {
//        RibotsAdapter.getApiServiceJC().getRibots(this);
        this.ribotView =ribotView;
        GerenciaAdapter.getGerencias("inleggo_test_2014")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GerenciaResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(GerenciaResponse gerenciaResponse) {
                        Log.i(TAG, "asdasd: " + gerenciaResponse.getGerencias().size());
                        ribotView.setSp1(gerenciaResponse.getGerencias());
                        ribotView.setMensaje(""+gerenciaResponse.getGerencias().size());
                    }
                });

/*
                .subscribe(new Action1<GerenciaResponse>() {
                    @Override
                    public void call(GerenciaResponse gerenciaResponse) {
//                        Log.i(TAG, "asdasd: " + gerenciaResponse.getGerencias().size());
//                        ribotView.setSp1(ribots);
//                        ribotView.setMensaje("" + ribots.size());
                    }
                });
*/
    }



}
