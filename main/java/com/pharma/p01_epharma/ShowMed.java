package com.abubaker.p01_epharma;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ShowMed extends AppCompatActivity {
    RecyclerView rv;
    List<OrderMedModel> ls;
    OrderRVAdapter adapter;
    TextView title;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference mStorageReference=storage.getReference().child("Images");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_med);
        rv=findViewById(R.id.rv);
        title=findViewById(R.id.title_type_med);
        ls=new ArrayList<>();
        mStorageReference= FirebaseStorage.getInstance().getReference("Images");

        adapter=new OrderRVAdapter(ls);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(ShowMed.this);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(adapter);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("medicine");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ls.add(dataSnapshot.getValue(OrderMedModel.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Intent intent=getIntent();
            String medType=intent.getStringExtra("type");
            title.setText(medType);
        }

}
