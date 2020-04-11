package org.solutione.rancho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import org.solutione.rancho.api.Borre;
import org.solutione.rancho.api.ShowBorre;
import org.solutione.rancho.api.addborre;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private TextView txtDayN1;
    private TextView txtDayN2;
    private TextView txtDayN3;
    private TextView txtDayN4;
    private TextView txtDayN5;
    private TextView txtDayN6;
    private TextView txtDayN7;
    private AdView mAdView;


    private ImageView imgMenu;
    private ImageView imgNotification;
    private ImageView imgJob;
    private ImageView imgStadistics;
    private ImageView imgHistory;
    private ImageView imgButtonAction;
    private ImageView imgButtonaddChep;
    private LinearLayout lytMenu;
    private LinearLayout lytMenuClose;
    private LinearLayout lytNotification;
    private LinearLayout lytJob;
    private LinearLayout lytStadistics;
    private LinearLayout lytHistory;
    private LinearLayout salir;
    private FirebaseAuth mAuth;
    private InterstitialAd mInterstitialAd;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FirebaseRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.list);

        this.imageView = findViewById(R.id.imageView);

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
        this.imgButtonaddChep = findViewById(R.id.imgButtonAddCheep);
        this.lytMenu = findViewById(R.id.lytMenu);
        this.lytMenuClose = findViewById(R.id.lytMenuClose);
        this.lytNotification = findViewById(R.id.lytNotification);
        this.lytJob = findViewById(R.id.lytJob);
        this.lytStadistics = findViewById(R.id.lytStadistics);
        this.lytHistory = findViewById(R.id.lytHistory);
        this.salir=findViewById(R.id.lytsalir);

        fetch();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        try{
          Glide.with(this).load(user.getPhotoUrl()).skipMemoryCache(true).circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
                  .into(imageView);

        }catch (NullPointerException e){
            Toast.makeText(getApplicationContext(),"imagen no encontrada",Toast.LENGTH_LONG).show();
        }

        setActions();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9987707406222525/5470084142");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { }
        });



        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "salir", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent1 = new Intent(v.getContext(), SplashActivity.class);
                startActivity(intent1);



            }
        });

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
                imgButtonaddChep.setVisibility(View.GONE);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    mInterstitialAd.show();


                }

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
                imgButtonaddChep.setVisibility(View.GONE);



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
                imgButtonaddChep.setVisibility(View.GONE);



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
                imgButtonaddChep.setVisibility(View.VISIBLE);

                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setHasFixedSize(true);



            }



        });

        imgButtonaddChep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new addborre().show(getSupportFragmentManager(), "SimpleDialog");


            }
        });

    }

    private void fetch() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String consuulta = user.getUid() + "/borres";
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child(consuulta);

        FirebaseRecyclerOptions<Borre> options =
                new FirebaseRecyclerOptions.Builder<Borre>()
                        .setQuery(query, new SnapshotParser<Borre>() {
                            @NonNull


                            @Override
                            public Borre parseSnapshot(@NonNull DataSnapshot snapshot) {


                                return new Borre(snapshot.child("nombrecarnero").getValue().toString(),
                                        snapshot.child("nombrecarnero").getValue().toString(),
                                        snapshot.child("fechaparto").getValue().toString()
                                        ,snapshot.child("proposito").getValue().toString()
                                        ,snapshot.child("raza").getValue().toString()
                                        ,snapshot.child("peso").getValue().toString()
                                        ,snapshot.child("genero").getValue().toString());
                            }
                        })
                        .build();

        adapter = new FirebaseRecyclerAdapter<Borre,ShowBorre>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ShowBorre holder,final int position, @NonNull Borre model) {
                   holder.setTxtTitle(model.getNombrecarnero());
                   holder.setFecha_nacimiento(model.getFechaparto());
                   holder.setProposito(model.getProposito());
                   holder.setTxtDesc(model.getraza());
                   holder.setPeso(model.getpeso());
                   holder.setGenero(model.getGenero());

                }


            @Override
            public ShowBorre onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item, parent, false);

                return new ShowBorre(view);
            }


        };

        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
    private void setCalendar(){
        Calendar c1 = Calendar.getInstance();

        //first day of week
        c1.set(Calendar.DAY_OF_WEEK, 1);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);

        txtDayN1.setText(""+(day1));
        txtDayN2.setText(""+(day1+1));
        txtDayN3.setText(""+(day1+2));
        txtDayN4.setText(""+(day1+3));
        txtDayN5.setText(""+(day1+4));
        txtDayN6.setText(""+(day1+5));
        txtDayN7.setText(""+(day1+6));
    }


}
