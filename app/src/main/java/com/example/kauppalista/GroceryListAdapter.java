package com.example.kauppalista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder> {

    private Context context;
    protected ArrayList<Grocery> list;

    public GroceryListAdapter(Context context, ArrayList<Grocery> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product, parent, false);
        return new GroceryViewHolder(view).linkAdapter(this);
    }

    @Override // Add values to labels
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {

        holder.txtProduct.setText(list.get(position).getGrocery());
        holder.txtRemember.setText("Muista: " + list.get(position).getRem());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}