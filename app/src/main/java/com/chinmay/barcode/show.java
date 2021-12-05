package com.chinmay.barcode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class show extends AppCompatActivity {



    private FirebaseDatabase mDatabase;
    private DatabaseReference mFirebaseDatabase;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter adapter;
    private String i;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        i = getIntent().getExtras().getString("Value");





        mListView = (ListView) findViewById(R.id.ListView1);
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://asset2-35d44.firebaseio.com/All Assets/"+i);




        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        mListView.setAdapter(adapter);
        mFirebaseDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String asset = dataSnapshot.getValue(String.class);
                String key = dataSnapshot.getKey();
                arrayList.add(key+ " - " + asset);
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



    }
}
