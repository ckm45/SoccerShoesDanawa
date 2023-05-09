package com.example.danawa;

import static com.example.danawa.R.id.textName;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> implements OnProductItemClickListener{
    ArrayList<Product> items = new ArrayList<Product>();
    OnProductItemClickListener listener;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.product_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(Product item){
        items.add(item);
    }
    public void setItems(ArrayList<Product> items){
        this.items = items;
    }
    public Product getItem(int position){
        return items.get(position);
    }
    public void setItem(int position,Product item){
        items.set(position,item);
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }
    public void setOnItemClickListener(OnProductItemClickListener listener){
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textName;
        TextView textCost;
        TextView textFootlevel;



        public ViewHolder(View itemView, final OnProductItemClickListener listener){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textCost = itemView.findViewById(R.id.textCost);
            textFootlevel = itemView.findViewById(R.id.textfootlevel);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view,position);
                    }
                }
            });
        }

        public void setItem(Product item){
            textFootlevel.setText(item.getFootlevel());
            textName.setText(item.getName());
            textCost.setText(item.getCost());
            imageView.setImageResource(item.getPic());
        }
    }
}