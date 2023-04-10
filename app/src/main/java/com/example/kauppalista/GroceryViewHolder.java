package com.example.kauppalista;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Create class what extends recyclerviewer
public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView txtProduct, txtRemember;
    GroceryList grocerylist;
    private GroceryListAdapter adapter;
    private Grocery grocery;

    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        grocerylist = GroceryList.getInstance();
        txtProduct = itemView.findViewById(R.id.txtProduct);
        txtRemember = itemView.findViewById(R.id.txtRemember);
        itemView.findViewById(R.id.ibDelete).setOnClickListener(view -> {
            grocery = adapter.list.get(getAdapterPosition());
            grocerylist.deleteGroceryFromList(grocery);
        });
        itemView.findViewById(R.id.ibEdit).setOnClickListener(view -> {});

    }

    public GroceryViewHolder linkAdapter(GroceryListAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

}