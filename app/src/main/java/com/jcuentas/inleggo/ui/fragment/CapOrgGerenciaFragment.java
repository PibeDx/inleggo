package com.jcuentas.inleggo.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jcuentas.inleggo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CapOrgGerenciaFragment extends Fragment {

public static final String TIPO_ORG_GERENCIA="tipo_organicacion_gerencia";


    public static CapOrgGerenciaFragment newInstance(int tipoOrgGerencia){
        CapOrgGerenciaFragment fragment = new CapOrgGerenciaFragment();
        Bundle data = new Bundle();
        data.putInt(TIPO_ORG_GERENCIA, tipoOrgGerencia);
        fragment.setArguments(data);

        return fragment;
    }

    public CapOrgGerenciaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_cap_org_gerencia_final, container, false);
        LinearLayout linearLayout = (LinearLayout)root.findViewById(R.id.main_container);
        int tipoOrgGerencia ;
        tipoOrgGerencia =getArguments().getInt(TIPO_ORG_GERENCIA);

        switch (tipoOrgGerencia){
            case 1:
                nuevo(savedInstanceState,linearLayout);
                break;
            case 2:
                actualizar(savedInstanceState, linearLayout);
                break;
            case 3:
                aliminar(savedInstanceState, linearLayout);
                break;
        }
        return root;
    }

    private void nuevo(Bundle savedInstanceState, LinearLayout linearLayout){
        View item1= getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_cap_org_gerencia_item1,linearLayout,true);
        TextInputLayout tilNombre = (TextInputLayout)item1.findViewById(R.id.til_numero);
        tilNombre.getEditText().setText("Hola?");

        View item3= getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_cap_org_gerencia_item3,linearLayout,true);
    }

    private void actualizar(Bundle savedInstanceState, LinearLayout linearLayout){
        View item2= getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_cap_org_gerencia_item2,linearLayout,true);

        View item1= getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_cap_org_gerencia_item1,linearLayout,true);
        TextInputLayout tilNombre = (TextInputLayout)item1.findViewById(R.id.til_numero);
        tilNombre.getEditText().setText("Hola?");
    }
    private void aliminar(Bundle savedInstanceState, LinearLayout linearLayout){
        View item2= getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_cap_org_gerencia_item2,linearLayout,true);
    }








}
