package com.example.medicaresapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SearchAreaActivity extends AppCompatActivity {

    EditText inputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<Model> options;
    FirebaseRecyclerAdapter<Model,MyViewHolder> adapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_area);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Shop Details");
        inputSearch=findViewById(R.id.editTextSearch);
        recyclerView=findViewById(R.id.rvs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        loadData("");
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString()!=null){

                    loadData(s.toString());
                }else {
                    loadData("");
                }

            }
        });
    }

    private void loadData(String data) {
        Query query=databaseReference.orderByChild("Area").startAt(data).endAt(data+"\uf8ff");
        options=new FirebaseRecyclerOptions.Builder<Model>().setQuery(query,Model.class).build();
        adapter=new FirebaseRecyclerAdapter<Model, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i, @NonNull Model model) {
                myViewHolder.text_view1.setText(model.getShopName());
                myViewHolder.text_view2.setText(model.getAddress());
                myViewHolder.text_view3.setText(model.getArea());
                myViewHolder.text_view4.setText(model.getName());
                myViewHolder.text_view5.setText(model.getNumber());
                myViewHolder.text_view6.setText(model.getEmail());
                myViewHolder.text_view7.setText(model.getMedicalTypes());
                myViewHolder.text_view8.setText(model.getCityName());

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_layout,parent,false);
                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }


}