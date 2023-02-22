package com.dam.proyectobadt2_rubenbalboa.rvutil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectobadt2_rubenbalboa.R;
import com.dam.proyectobadt2_rubenbalboa.entity.Terremoto;


import java.util.ArrayList;

public class TerremotoAdapter extends RecyclerView.Adapter<TerremotoAdapter.TerremotoViewHolder>{

    private ArrayList<Terremoto> listaTerremotos;

    public TerremotoAdapter(ArrayList<Terremoto> listaTerremotos) {
        this.listaTerremotos = listaTerremotos;
    }

    @NonNull
    @Override
    public TerremotoAdapter.TerremotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.terremoto_item, parent, false);
        return new TerremotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TerremotoAdapter.TerremotoViewHolder holder, int position) {
        holder.bindTerremoto(listaTerremotos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaTerremotos.size();
    }

    public class TerremotoViewHolder extends RecyclerView.ViewHolder {

        TextView tvFechaHora;
        TextView tvNombre;
        TextView tvMagnitud;
        TextView tvCoordenadas;
        TextView tvLugar;
        TextView tvCantMuertos;

        public TerremotoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFechaHora = itemView.findViewById(R.id.tvFechaHora);
            tvNombre = itemView.findViewById(R.id.tvNombreTerremoto);
            tvMagnitud = itemView.findViewById(R.id.tvMagnitud);
            tvCoordenadas = itemView.findViewById(R.id.tvCoordenadasEpi);
            tvLugar = itemView.findViewById(R.id.tvLugar);
            tvCantMuertos = itemView.findViewById(R.id.tvNumMuertos);

        }


        public void bindTerremoto(Terremoto t) {
            tvFechaHora.setText(t.getFechaHora());
            tvNombre.setText(t.getNombreTerremoto());
            tvMagnitud.setText(String.format(Double.toString(t.getMagnitud())));
            tvCoordenadas.setText(t.getCoordenadas());
            tvLugar.setText(t.getLugar());
            tvCantMuertos.setText(t.getNumMuertos());
        }
    }
}
