package com.example.catstagramv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context pContext;
    private List<CatPost>postsList;

    public Adaptery(Context pContext, List<CatPost> postsList) {
        this.pContext = pContext;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public Adaptery.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(pContext);
        v=layoutInflater.inflate(R.layout.post_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptery.MyViewHolder holder, int position) {
        holder.idDisplay.setText("User: "+ postsList.get(position).getId());
        Glide.with(pContext)
                .load(postsList.get(position).getUrl())
                .into(holder.postImage);
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pContext, "Liked!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView idDisplay;
        ImageView postImage;

        CardView cardView;
        Button likeButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idDisplay=itemView.findViewById(R.id.idDisplay);
            postImage=itemView.findViewById(R.id.postImage);
            cardView=itemView.findViewById(R.id.cardView);
            likeButton = itemView.findViewById(R.id.likeButton);



        }
    }
}
