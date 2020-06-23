package org.solutione.rancho.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.solutione.rancho.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class addnotifi {

    public void selenio(){
        Notifications Ntfselenio= new Notifications("1","Inyeccion de selenio","El selenio se inyecta al tercer dia","1");
        String date = new SimpleDateFormat("dd/M/yyyy").format(new Date());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getUid() + "/notificaciones";
        DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef = myRef1.child(email);
        myRef.push().setValue(Ntfselenio);


        email = user.getUid() + "/borres";
        DatabaseReference myRef11 = FirebaseDatabase.getInstance().getReference();
        DatabaseReference myRef12 = myRef1.child(email);
        Query query = myRef12.orderByChild("username").equalTo("toto");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot user: snapshot.getChildren()) {
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });





}

}
