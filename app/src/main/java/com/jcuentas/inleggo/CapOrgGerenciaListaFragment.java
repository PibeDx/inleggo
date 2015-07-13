package com.jcuentas.inleggo;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CapOrgGerenciaListaFragment extends Fragment {




    public static CapOrgGerenciaListaFragment newInstance(){
        CapOrgGerenciaListaFragment fragment = new CapOrgGerenciaListaFragment();
        return fragment;
    }

    public CapOrgGerenciaListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root  = inflater.inflate(R.layout.fragment_cap_org_gerencia_lista, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_gerencia);
        

        return root;
    }


}
