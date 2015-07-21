package com.jcuentas.inleggo.ui.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jcuentas.inleggo.R;
import com.jcuentas.inleggo.data.db.DBHelper;
import com.jcuentas.inleggo.data.db.dao.ServerDao;
import com.jcuentas.inleggo.data.model.Server;
import com.jcuentas.inleggo.io.adapter.LoginAdapter;
import com.jcuentas.inleggo.io.model.ServersResponse;
import com.jcuentas.inleggo.ui.adapter.ServerAdapter;

import java.util.ArrayList;

import fr.ganfra.materialspinner.MaterialSpinner;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class LoginActivity extends ActionBarActivity {
    public static final String TAG = "LoginActivity";
    Button btnLogin;
    MaterialSpinner mSpServer;
    Activity mActivity;
    DBHelper mDBHelper;
    ServerDao mServerDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition_login));
        }
        setContentView(R.layout.activity_login);
        mActivity = this;
        mDBHelper = new DBHelper(this);
        mServerDao = new ServerDao(mDBHelper, Server.class);
        mSpServer = (MaterialSpinner) findViewById(R.id.sp_servidor);
        btnLogin = (Button) findViewById(R.id.btn_sign);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivityPrincipal.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Server> servers = (ArrayList<Server>) mServerDao.obtenerTodos();
        if (servers.isEmpty()) {
            Log.i(TAG, "onResume: Se llena la informacion por el Servicio");
            EjecutarServicioServer();
        } else {
            Log.i(TAG, "onResume: Se llena la informacion por SQLite");
            llenarSpServer(servers);
        }
    }

    private void EjecutarServicioServer() {
        LoginAdapter.getServers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ServersResponse>() {
                    @Override
                    public void call(ServersResponse serversResponse) {
                        //Insertamos Datos
                        DBInsertarServer(serversResponse);
                        llenarSpServer(serversResponse.getServers());
                    }
                });
    }

    private void DBInsertarServer(ServersResponse serversResponse) {
        ArrayList<Server> servers =serversResponse.getServers();
        for (Server server : servers) {
            mServerDao.crear(server);
        }
    }
    private void llenarSpServer(ArrayList<Server> servers){
        ServerAdapter adapter = new ServerAdapter(mActivity, android.R.layout.simple_spinner_item, servers);
        mSpServer.setAdapter(adapter);
    }


}
