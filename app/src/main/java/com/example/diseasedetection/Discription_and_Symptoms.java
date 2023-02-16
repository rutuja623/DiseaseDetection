package com.example.diseasedetection;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;


public class Discription_and_Symptoms extends Fragment {
    private DatabaseReference reference, reference2;
    List<String> titles;
    List<String> maininfo;
    String diseaseName;
    DiseaseInfoAdapter adapter;


    public Discription_and_Symptoms(String dname) {
        // Required empty public constructor
        this.diseaseName = dname;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_discription, container, false);
        titles = new ArrayList<>();
        maininfo = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("1w9FzSbUKlVa8VYfh7GrgnQEGGm9sgl_gk-8x68mQVPQ");
        reference2 = reference.child("Disease_Data");
        reference2.child(diseaseName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                Disease inform = dataSnapshot.getValue(Disease.class);
                assert inform != null;

                titles.add("Disease Name");
                titles.add("Plant Name");
                titles.add("Description and Symptoms");
                titles.add("Causes");
                titles.add("Prevention and Treatment");

                maininfo.add(inform.diseaseName);
                maininfo.add(inform.plantName);
                maininfo.add(inform.descriptionAndSymptoms);
                maininfo.add(inform.causes);
                maininfo.add(inform.preventionAndTreatment);

                RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setHasFixedSize(true);
                adapter = new DiseaseInfoAdapter(getContext(), titles, maininfo);


                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


        return rootView;
    }
}