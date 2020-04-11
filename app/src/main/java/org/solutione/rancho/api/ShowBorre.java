package org.solutione.rancho.api;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.solutione.rancho.R;

public class ShowBorre extends RecyclerView.ViewHolder {
    public LinearLayout root;
    public TextView txtTitle;
    public TextView txtDesc;
    public TextView peso;
    public TextView proposito;
    public TextView fecha_nacimiento;
    public TextView genero;

    public ShowBorre(View itemView) {
        super(itemView);
        root = itemView.findViewById(R.id.list_root);
        txtTitle = itemView.findViewById(R.id.list_title);
        txtDesc = itemView.findViewById(R.id.list_desc);
        peso =itemView.findViewById(R.id.pesoshow);
        proposito=itemView.findViewById(R.id.propositoshow);
        fecha_nacimiento=itemView.findViewById(R.id.fecha_nacimientoshow);
        genero=itemView.findViewById(R.id.generoshow);
    }

    public void setTxtTitle(String string) {
        txtTitle.setText(string);
    }


    public void setTxtDesc(String string) {
        txtDesc.setText(string);
    }

    public void setProposito(String string) {
      proposito.setText(string);
    }

    public void setPeso(String string) {
       peso.setText(string);
    }

    public void setFecha_nacimiento(String string) {
        fecha_nacimiento.setText(string);
    }

    public void setGenero(String string) {
       genero.setText(string);
    }
}
