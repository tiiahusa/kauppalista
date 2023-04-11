package com.example.kauppalista;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder> {

    private Context context;
    private ArrayList<Grocery> list;


    public GroceryListAdapter(Context context, ArrayList<Grocery> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroceryViewHolder(LayoutInflater.from(context).inflate(R.layout.product, parent, false));
    }

    @Override // Add values to labels
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {

        holder.txtProduct.setText(list.get(position).getGrocery());
        holder.txtRemember.setText("Muista: " + list.get(position).getId());
        holder.tbEditGrocery.setText(list.get(position).getGrocery());
        holder.tbEditRem.setText(list.get(position).getRem());

        holder.remove.setOnClickListener(view -> {
            int pos =  holder.getAdapterPosition();
            GroceryList.getInstance().deleteGroceryFromList(list.get(pos).getId());
            notifyItemRemoved(pos);
        });

        holder.edit.setOnClickListener(view -> {

            int pos = holder.getAdapterPosition();
            if(holder.tbEditGrocery.getVisibility() == View.VISIBLE) {
                Grocery grocery = GroceryList.getInstance().getGroceryById(pos);
                grocery.setGrocery(holder.tbEditGrocery.getText().toString());
                grocery.setRem(holder.tbEditRem.getText().toString());
                holder.tbEditRem.setVisibility(View.GONE);
                notifyDataSetChanged();

            } else {
                holder.tbEditGrocery.setVisibility(View.VISIBLE);
                holder.tbEditRem.setVisibility(View.VISIBLE);
            }


        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}