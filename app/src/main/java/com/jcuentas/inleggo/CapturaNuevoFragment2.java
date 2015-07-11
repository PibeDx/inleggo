package com.jcuentas.inleggo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jcuentas.inleggo.data.model.Ribot;
import com.jcuentas.inleggo.data.remote.RibotsImpl;
import com.jcuentas.inleggo.view.RibotView;

import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CapturaNuevoFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CapturaNuevoFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CapturaNuevoFragment2 extends Fragment  implements RibotView {

    public static final String TAG = "CapturaNuevoFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MaterialSpinner mspTipoCaptura, mspTipoSede, mspTipoGerencia, mspTipoArea, mspTipoEquipo, mspTipoLocal, mspTipoPiso, mspTipoUbicacion, mspTipoUsuario, mspTipoProyecto;
    private Spinner spTest1;

    RibotsImpl ribots;


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CapturaNuevoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CapturaNuevoFragment2 newInstance(String param1, String param2) {
        CapturaNuevoFragment2 fragment = new CapturaNuevoFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CapturaNuevoFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_captura_nuevo, container, false);

        String[] ITEMS = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        inicializaVariables(root);
//        mspTipoCaptura= (MaterialSpinner)root.findViewById(R.id.sp_tipo_captura);
        mspTipoCaptura.setAdapter(createAdapter(R.array.ar_tipo_captura));
        mspTipoSede.setAdapter(createAdapter(R.array.ar_tipo_sede));
        mspTipoGerencia.setAdapter(createAdapter(R.array.ar_tipo_gerencia));
        mspTipoArea.setAdapter(createAdapter(R.array.ar_tipo_area));
        mspTipoEquipo.setAdapter(createAdapter(R.array.ar_tipo_equipo));
        mspTipoLocal.setAdapter(createAdapter(R.array.ar_tipo_local));
        mspTipoPiso.setAdapter(createAdapter(R.array.ar_tipo_piso));
        mspTipoUbicacion.setAdapter(createAdapter(R.array.ar_tipo_ubicacion));
        mspTipoUsuario.setAdapter(createAdapter(R.array.ar_tipo_usuario));
        mspTipoProyecto.setAdapter(createAdapter(R.array.ar_tipo_proyecto));




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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        ribots = new RibotsImpl(this);

    }

    @Override
    public void setMensaje(String mensaje) {
        Log.d(TAG, mensaje);
    }

    @Override
    public void setSp1(List list) {
        String[] ITEMS = new String[list.size()];
        List<Ribot> lista = list;
        int i=0;
        for (Ribot ribot : lista) {
            ITEMS[i]=lista.get(i).id;
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspTipoCaptura.setAdapter(adapter);
    }


    private ArrayAdapter<CharSequence> createAdapter(int resource){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), resource, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
