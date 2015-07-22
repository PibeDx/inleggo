package com.jcuentas.inleggo.ui.activity;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jcuentas.inleggo.R;
import com.jcuentas.inleggo.ui.fragment.CapOrgGerenciaFragment;
import com.jcuentas.inleggo.ui.fragment.CapOrgGerenciaListaFragment;
import com.jcuentas.inleggo.ui.fragment.CapturaNuevoFragment;


public class MainActivityPrincipal extends AppCompatActivity {
private DrawerLayout drawerLayout;
private String drawerTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);

        setToolbar();

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        if (navigationView!=null) {
            setupDrawerContent(navigationView);
        }
        drawerTitle = "Probando el title";
        if (savedInstanceState==null) {
            selectItem(R.id.nav_captura_organigrama_area);
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        String title = menuItem.getTitle().toString();
                        int idMenu = menuItem.getItemId();
                        selectItem(idMenu);
                        return true;
                    }


                }
        );
    }

    private void selectItem(int idMenu) {
        Fragment fragment = null;
        switch (idMenu){
            case R.id.nav_captura_organigrama_area:
                fragment = CapOrgGerenciaFragment.newInstance(1);
                break;
            case R.id.nav_captura_organigrama_equipo:
                fragment = CapOrgGerenciaFragment.newInstance(2);
                break;
            case R.id.nav_captura_organigrama_gerencia:
                fragment = CapOrgGerenciaFragment.newInstance(3);
                break;
            case R.id.nav_captura_nuevo:
//                fragment = CapturaNuevoFragment2.newInstance("","");
                fragment = CapOrgGerenciaListaFragment.newInstance();
                break;
            default:
                fragment = CapturaNuevoFragment.newInstance();
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();
        drawerLayout.closeDrawers(); //Cerrar drawer
        //TODO: asignar titulo

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab!=null) {
            // Poner icono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
        // Inflate the menu; this adds items to the action bar if it is present.
    return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


}
