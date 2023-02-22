package com.dam.proyectobadt2_rubenbalboa.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.dam.proyectobadt2_rubenbalboa.MainActivity;
import com.dam.proyectobadt2_rubenbalboa.R;
import com.dam.proyectobadt2_rubenbalboa.dao.PaisesDao;
import com.dam.proyectobadt2_rubenbalboa.db.TerremotosDB;

import java.util.ArrayList;

public class FiltroDialog extends DialogFragment {

    Spinner spnMes;
    EditText etAnio;
    Spinner spnPais;

    OnFiltroListener listener;

    TerremotosDB db;
    PaisesDao pDao;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_filtro, null);

        spnMes = view.findViewById(R.id.spMes);
        etAnio = view.findViewById(R.id.etAnio);
        spnPais = view.findViewById(R.id.spPais);

        db = TerremotosDB.getDatabase(getActivity());
        pDao = db.paisesDAO();
        ArrayList<String> paises = (ArrayList<String>) pDao.getAllPaises();
        paises.add(0, MainActivity.TODOS_CAMPOS);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, paises);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPais.setAdapter(adaptador);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setTitle(R.string.title_dialog_filtro)
                .setPositiveButton(R.string.btnAceptar, null)
                .setNegativeButton(R.string.btnCancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button btnAceptar = ((AlertDialog) dialogInterface).getButton(AlertDialog.BUTTON_POSITIVE);
                btnAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String mes = spnMes.getSelectedItem().toString();
                        String anio = etAnio.getText().toString();
                        String pais = spnPais.getSelectedItem().toString();
                        if ( etAnio.getText().toString().isEmpty() || Integer.parseInt(etAnio.getText().toString()) <= 2023) {
                            listener.onFiltroListener(mes, anio, pais);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(getActivity(), R.string.no_anio, Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        return dialog;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFiltroListener) {
            listener = (OnFiltroListener) context;
        } else {
            throw new RuntimeException(context + " debe implementar la interfaz: 'OnFiltroListener'");
        }
    }

    @Override
    public void onDetach() {
        if (listener != null) {
            listener = null;
        }
        super.onDetach();
    }
}
