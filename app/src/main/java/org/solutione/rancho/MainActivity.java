package org.solutione.rancho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imgMenu;
    private ImageView imgNotification;
    private ImageView imgJob;
    private ImageView imgStadistics;
    private ImageView imgHistory;

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

        this.imgMenu = (ImageView) findViewById(R.id.imgMenu);
        this.imgNotification = (ImageView) findViewById(R.id.imgNotification);
        this.imgJob = (ImageView) findViewById(R.id.imgJob);
        this.imgStadistics = (ImageView) findViewById(R.id.imgStadistics);
        this.imgHistory =  (ImageView) findViewById(R.id.imgHistory);

        this.lytMenu = (LinearLayout) findViewById(R.id.lytMenu);
        this.lytMenuClose = (LinearLayout) findViewById(R.id.lytMenuClose);
        this.lytNotification = (LinearLayout) findViewById(R.id.lytNotification);
        this.lytJob = (LinearLayout) findViewById(R.id.lytJob);
        this.lytStadistics = (LinearLayout) findViewById(R.id.lytStadistics);
        this.lytHistory =  (LinearLayout) findViewById(R.id.lytHistory);


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
                lytHistory.setVisibility(view.GONE);
                lytNotification.setVisibility(View.VISIBLE);
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
            }
        });
    }
}
