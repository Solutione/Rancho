package org.solutione.rancho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView txtDayN1;
    private TextView txtDayN2;
    private TextView txtDayN3;
    private TextView txtDayN4;
    private TextView txtDayN5;
    private TextView txtDayN6;
    private TextView txtDayN7;


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

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        this.txtDayN1 = findViewById(R.id.txtDayN1);
        this.txtDayN2 = findViewById(R.id.txtDayN2);
        this.txtDayN3 = findViewById(R.id.txtDayN3);
        this.txtDayN4 = findViewById(R.id.txtDayN4);
        this.txtDayN5 = findViewById(R.id.txtDayN5);
        this.txtDayN6 = findViewById(R.id.txtDayN6);
        this.txtDayN7 = findViewById(R.id.txtDayN7);

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

        setActions();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }

    private void setActions(){
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

        setKeyPad();
        setCalendar();
    }

    private void setKeyPad(){
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
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
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

    private void setCalendar(){
        Calendar c1 = Calendar.getInstance();

        //first day of week
        c1.set(Calendar.DAY_OF_WEEK, 1);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);

        txtDayN1.setText(""+day1);
        txtDayN2.setText(""+(day1+1));
        txtDayN3.setText(""+(day1+2));
        txtDayN4.setText(""+(day1+3));
        txtDayN5.setText(""+(day1+4));
        txtDayN6.setText(""+(day1+5));
        txtDayN7.setText(""+(day1+6));
    }
}
