package com.jcuentas.inleggo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcuentas.inleggo.R;

/**
 * Created by Jose Cuentas Turpo on 13/07/2015 - 06:07 PM.
 * E-mail: jcuentast@gmail.com
 */
public class GerenciaAdapter extends RecyclerView.Adapter<GerenciaAdapter.GerenciaViewHolder> {
    public static class GerenciaViewHolder extends RecyclerView.ViewHolder {


        TextView txvItem;
        ImageView imvPreview;

        GerenciaViewHolder(View itemView) {
            super(itemView);

            txvItem = (TextView) itemView.findViewById(R.id.txv_item);
            imvPreview = (ImageView) itemView.findViewById(R.id.imv_preview);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public GerenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cap_org_gerencia, parent, false);
        GerenciaViewHolder viewHolder = new GerenciaViewHolder(root);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GerenciaViewHolder holder, int position) {

    }
}
