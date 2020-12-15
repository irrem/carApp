package com.example.carlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Model> modelArrayList= new ArrayList<>();
    private Context context;
    //constructor bruh
    public Adapter(Context context, ArrayList<Model> modelArrayList){
        this.modelArrayList=modelArrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.nameTxt.setText(modelArrayList.get(position).getName());
            holder.descriptionTxt.setText(modelArrayList.get(position).getDesc());
            Picasso.get().load(modelArrayList.get(position).getImage()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView nameTxt,descriptionTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=(ImageView)itemView.findViewById(R.id.cardImage);
            nameTxt=(TextView)itemView.findViewById(R.id.name);
            descriptionTxt=(TextView)itemView.findViewById(R.id.description);
        }
    }


}
