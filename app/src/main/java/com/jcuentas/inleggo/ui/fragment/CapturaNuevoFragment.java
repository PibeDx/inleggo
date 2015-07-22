package com.jcuentas.inleggo.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jcuentas.inleggo.R;
import com.jcuentas.inleggo.data.model.Gerencia;
import com.jcuentas.inleggo.presenter.GerenciaPresenter;
import com.jcuentas.inleggo.presenter.impl.GerenciaPresenterImpl;
import com.jcuentas.inleggo.view.GerenciaView;

import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;


public class CapturaNuevoFragment extends Fragment implements GerenciaView {

    public static final String TAG = "CapturaNuevoFragment";

    private MaterialSpinner mspTipoCaptura, mspTipoSede, mspTipoGerencia, mspTipoArea, mspTipoEquipo, mspTipoLocal, mspTipoPiso, mspTipoUbicacion, mspTipoUsuario, mspTipoProyecto;
    private Spinner spTest1;
    private GerenciaPresenter mGerenciaPresenter;

    public static CapturaNuevoFragment newInstance() {
        CapturaNuevoFragment fragment = new CapturaNuevoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public CapturaNuevoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_captura_nuevo, container, false);
        inicializaVariables(root);
        return root;
    }

    private void inicializaVariables(View root) {
        mspTipoCaptura= (MaterialSpinner)root.findViewById(R.id.sp_tipo_captura);
        mspTipoSede= (MaterialSpinner)root.findViewById(R.id.sp_tipo_sede);
        mspTipoGerencia= (MaterialSpinner)root.findViewById(R.id.sp_tipo_gerencia);
        mspTipoArea= (MaterialSpinner)root.findViewById(R.id.sp_tipo_area);
        mspTipoEquipo= (MaterialSpinner)root.findViewById(R.id.sp_tipo_equipo);
        mspTipoLocal= (MaterialSpinner)root.findViewById(R.id.sp_tipo_local);
        mspTipoPiso= (MaterialSpinner)root.findViewById(R.id.sp_tipo_piso);
        mspTipoUbicacion= (MaterialSpinner)root.findViewById(R.id.sp_tipo_ubicacion);
        mspTipoUsuario= (MaterialSpinner)root.findViewById(R.id.sp_tipo_usuario);
        mspTipoProyecto= (MaterialSpinner)root.findViewById(R.id.sp_tipo_proyecto);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mGerenciaPresenter = new GerenciaPresenterImpl(this);
        mGerenciaPresenter.validateCargaInfo();
//        GerenciaInteractor gerenciaInteractor = new GerenciaInteractorImpl();
//        gerenciaInteractor.cargarSP(this);

    }

    private ArrayAdapter<CharSequence> createAdapter(int resource){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), resource, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }
    private ArrayAdapter<String> createAdapter(String[] strings){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, strings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    @Override
    public void setListArea() {
        mspTipoArea.setAdapter(createAdapter(R.array.ar_tipo_area));
    }

    @Override
    public void setMensaje(String mensaje) {

    }

    @Override
    public void setListCaptura() {
        mspTipoCaptura.setAdapter(createAdapter(R.array.ar_tipo_captura));

    }

    @Override
    public void setListSede() {
        mspTipoSede.setAdapter(createAdapter(R.array.ar_tipo_sede));

    }

    @Override
    public void setListGerencia(List gerencia) {
        String[] ITEMS = new String[gerencia.size()];
        int i=0;
        for (Gerencia mgerencia : (List<Gerencia>)gerencia) {
            ITEMS[i]=mgerencia.getNoGerencia();
            i++;
        }
        mspTipoGerencia.setAdapter(createAdapter(ITEMS));
    }

    @Override
    public void setListEquipo() {
        mspTipoEquipo.setAdapter(createAdapter(R.array.ar_tipo_equipo));

    }

    @Override
    public void setListLocal() {
        mspTipoLocal.setAdapter(createAdapter(R.array.ar_tipo_local));

    }

    @Override
    public void setListPiso() {
        mspTipoPiso.setAdapter(createAdapter(R.array.ar_tipo_piso));

    }

    @Override
    public void setListUbicacion() {
        mspTipoUbicacion.setAdapter(createAdapter(R.array.ar_tipo_ubicacion));

    }

    @Override
    public void setListUsuario() {
        mspTipoUsuario.setAdapter(createAdapter(R.array.ar_tipo_usuario));

    }

    @Override
    public void setListProyecto() {
        mspTipoProyecto.setAdapter(createAdapter(R.array.ar_tipo_proyecto));
    }
}
