package com.jcuentas.inleggo.ui.activity;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jcuentas.inleggo.ui.fragment.CapOrgGerenciaFragment;
import com.jcuentas.inleggo.ui.fragment.CapturaNuevoFragment2;
import com.jcuentas.inleggo.R;


public class MainActivity extends ActionBarActivity implements CapturaNuevoFragment2.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .add(R.id.main_container, CapturaNuevoFragment.newInstance("asd", "asd"))
//                .commit();
            //Use actual
//            fragmentManager.beginTransaction()
//                    .add(R.id.main_container, CapturaNuevoFragment2.newInstance("asd", "asd"))
//                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.main_container, CapOrgGerenciaFragment.newInstance(1))
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onFragmentInteraction(Uri uri) {

    }
}
