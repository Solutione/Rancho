package org.solutione.rancho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ImageView imgMenu;
    private ImageView imgNotification;
    private ImageView imgJob;
    private ImageView imgStadistics;
    private ImageView imgHistory;
    private ImageView imgButtonAction;

    private LinearLayout lytMenu;
    private LinearLayout lytMenuClose;
    private LinearLayout lytNotification;
    private LinearLayout lytJob;
    private LinearLayout lytStadistics;
    private LinearLayout lytHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        this.imgMenu = findViewById(R.id.imgMenu);
        this.imgNotification = findViewById(R.id.imgNotification);
        this.imgJob = findViewById(R.id.imgJob);
        this.imgStadistics = findViewById(R.id.imgStadistics);
        this.imgHistory = findViewById(R.id.imgHistory);
        this.imgButtonAction = findViewById(R.id.imgButtonAction);

        this.lytMenu = findViewById(R.id.lytMenu);
        this.lytMenuClose = findViewById(R.id.lytMenuClose);
        this.lytNotification = findViewById(R.id.lytNotification);
        this.lytJob = findViewById(R.id.lytJob);
        this.lytStadistics = findViewById(R.id.lytStadistics);
        this.lytHistory = findViewById(R.id.lytHistory);


        setButtons();

    }

    private void setButtons(){
        //Boton Menu
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lytMenu.setVisibility(View.VISIBLE);
            }
        });

        //Boton Cerrar Menu
        lytMenuClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lytMenu.setVisibility(View.GONE);
            }
        });

        //Boton Capa de Notificaciones

        imgNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lytJob.setVisibility(View.GONE);
                lytStadistics.setVisibility((View.GONE));
                lytHistory.setVisibility(View.GONE);
                lytNotification.setVisibility(View.VISIBLE);

                imgNotification.setImageResource(R.drawable.notificationb);
                imgJob.setImageResource(R.drawable.check);
                imgStadistics.setImageResource(R.drawable.stadistics);
                imgHistory.setImageResource(R.drawable.piece);

                imgButtonAction.setVisibility(View.GONE);

            }
        });
        //Boton Capa de Tareas y Eventos

        imgJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lytNotification.setVisibility(View.GONE);
                lytStadistics.setVisibility((View.GONE));
                lytHistory.setVisibility(View.GONE);
                lytJob.setVisibility(View.VISIBLE);

                imgNotification.setImageResource(R.drawable.notification);
                imgJob.setImageResource(R.drawable.checkb);
                imgStadistics.setImageResource(R.drawable.stadistics);
                imgHistory.setImageResource(R.drawable.piece);

                imgButtonAction.setVisibility(View.VISIBLE);
            }
        });
        //Boton Capa de estadisticas

        imgStadistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lytNotification.setVisibility(View.GONE);
                lytJob.setVisibility((View.GONE));
                lytHistory.setVisibility(View.GONE);
                lytStadistics.setVisibility(View.VISIBLE);

                imgNotification.setImageResource(R.drawable.notification);
                imgJob.setImageResource(R.drawable.check);
                imgStadistics.setImageResource(R.drawable.stadisticsb);
                imgHistory.setImageResource(R.drawable.piece);

                imgButtonAction.setVisibility(View.GONE);
            }
        });

        //Boton Capa de Historial

        imgHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lytNotification.setVisibility(View.GONE);
                lytJob.setVisibility((View.GONE));
                lytStadistics.setVisibility(View.GONE);
                lytHistory.setVisibility(View.VISIBLE);

                imgNotification.setImageResource(R.drawable.notification);
                imgJob.setImageResource(R.drawable.check);
                imgStadistics.setImageResource(R.drawable.stadistics);
                imgHistory.setImageResource(R.drawable.pieceb);

                imgButtonAction.setVisibility(View.GONE);
            }
        });
    }
}
