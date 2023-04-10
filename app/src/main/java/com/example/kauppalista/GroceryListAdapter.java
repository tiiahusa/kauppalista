package com.example.kauppalista;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.PortUnreachableException;
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
        holder.txtRemember.setText("Muista: " + list.get(position).getRem());

        /*/holder.ibDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Grocery theRemovedItem = list.get(position);
                // remove your item from data base
                list.remove(position);  // remove the item from list
                notifyItemRemoved(position); // notify the adapter about the removed item
            }
        });

        holder.ibEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });/*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}