package org.solutione.rancho.api;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.solutione.rancho.R;

public class ShowNotifi extends RecyclerView.ViewHolder {
public LinearLayout root;
public TextView Title;
public TextView information;
public TextView cordero;

    public ShowNotifi(View itemView) {
        super(itemView);
        root = itemView.findViewById(R.id.list_notifi);
        information= itemView.findViewById(R.id.Informacion_notifi);
        Title= itemView.findViewById(R.id.Title_notifi);
        cordero=itemView.findViewById(R.id.Cordero_notifi);

    }

    public void setTitle(String string){
        Title.setText(string);
    }
    public void setInformation(String string){
        information.setText(string);
    }
    public void setCordero(String string){
        cordero.setText(string);
    }
}
