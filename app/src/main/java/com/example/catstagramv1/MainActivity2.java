package com.example.catstagramv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    TextView tv4;
    RecyclerView recyclerView;
    List<CatPost> postList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    // display welcome message
        tv4= (TextView) findViewById(R.id.tv4);
        Intent obj = getIntent();
        String s1 = obj.getStringExtra("key");
        tv4.setText("Welcome to Catstagram "+s1+"!");

    //recycler view loading
        recyclerView= findViewById(R.id.recyclerView);
        postList = new ArrayList<>();

    //Retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CatAPI catAPI = retrofit.create(CatAPI.class);
        Call<List<CatPost>> call = catAPI.getData();

        call.enqueue(new Callback<List<CatPost>>() {
            @Override
            public void onResponse(Call<List<CatPost>> call, Response<List<CatPost>> response) {
                if(response.code() != 200){
                    return;
                }
                List<CatPost> posts= response.body();
                for (CatPost post:posts){
                    postList.add(post);
                }
                PutDataIntoRecyclerView(postList);

            }

            @Override
            public void onFailure(Call<List<CatPost>> call, Throwable t) {

            }
        });

    }

    private void PutDataIntoRecyclerView(List<CatPost> postList) {
        Adaptery adaptery = new Adaptery(this, postList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }
}