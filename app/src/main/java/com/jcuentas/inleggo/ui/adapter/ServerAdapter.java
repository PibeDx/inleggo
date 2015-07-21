package com.jcuentas.inleggo.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jcuentas.inleggo.data.model.Servers;

import java.util.ArrayList;

/**
 * Created by Jose Cuentas Turpo on 21/07/2015 - 04:23 PM.
 * E-mail: jcuentast@gmail.com
 */
public class ServerAdapter extends ArrayAdapter<Servers> {
    private Context mContext;
    private int mResource;
    private ArrayList<Servers> mValues;
    private LayoutInflater mInflater;

    public ServerAdapter(Context context, int textViewResourceId,
                         ArrayList<Servers> values) {
        super(context, textViewResourceId, values);
        mContext = context;
        this.mValues =  values;
        this.mInflater = LayoutInflater.from(context);
    }
    public int getCount() {
//		return mValues.length;
        return mValues.size();
    }

    public Servers getItem(int position) {
//		return mValues[position];
        return mValues.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setPadding(10, 10, 0, 10);
        label.setTextSize(16f);
        label.setText(mValues.get(position).getNoEmpresa());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setPadding(10, 10, 0, 10);
        label.setTextSize(16f);
        label.setText(mValues.get(position).getNoEmpresa());
        return label;
    }



}
