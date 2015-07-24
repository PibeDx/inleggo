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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.jcuentas.inleggo.R;
import com.jcuentas.inleggo.data.db.DBHelper;
import com.jcuentas.inleggo.data.db.dao.ServerDao;
import com.jcuentas.inleggo.data.model.Server;
import com.jcuentas.inleggo.io.adapter.LoginAdapter;
import com.jcuentas.inleggo.io.model.ServersResponse;
import com.jcuentas.inleggo.presenter.LoginPresenter;
import com.jcuentas.inleggo.presenter.impl.LoginPresenterImpl;
import com.jcuentas.inleggo.ui.adapter.ServerAdapter;
import com.jcuentas.inleggo.view.LoginView;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class LoginActivity extends ActionBarActivity implements LoginView{
    public static final String TAG = "LoginActivity";
    LoginPresenter mLoginPresenter;
    Button btnLogin;
    MaterialSpinner mSpServer;
    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition_login));
        }
        setContentView(R.layout.activity_login);
        mActivity = this;
        mSpServer = (MaterialSpinner) findViewById(R.id.sp_servidor);
        btnLogin = (Button) findViewById(R.id.btn_sign);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.validateLogin("a", "a");
//                startActivity(new Intent(LoginActivity.this, MainActivityPrincipal.class));
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
        mLoginPresenter = new LoginPresenterImpl((LoginView)this,(Activity)this);
        mSpServer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d(TAG, "i: "+i);
//                if (i!=-1) {
                Server server = getSelectItemServere();
                Log.d(TAG, (server!=null)? server.getNoEmpresa():"Selection");
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void goToMain() {
        startActivity(new Intent(this,MainActivityPrincipal.class));
    }

    @Override
    public void cargarServers(List servers) {
        ServerAdapter adapter = new ServerAdapter(mActivity, android.R.layout.simple_spinner_item, (ArrayList<Server>)servers);
        mSpServer.setAdapter(adapter);
    }

    @Override
    public String obtenerSelectItemServers() {
        return "as";
    }

    @Override
    public void setMennsaje(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Server getSelectItemServere() {
        Server server = null;
        Log.d(TAG, "i: "+mSpServer.getSelectedItemPosition());
        if (mSpServer.getSelectedItemPosition()!=0) {
            return (Server) mSpServer.getSelectedItem();
        }
        return  server;
    }
}
