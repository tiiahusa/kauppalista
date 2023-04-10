package com.example.kauppalista;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Create class what extends recyclerviewer
public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView txtProduct, txtRemember;
    ImageView remove, edit;


    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        txtProduct = itemView.findViewById(R.id.txtProduct);
        txtRemember = itemView.findViewById(R.id.txtRemember);
        remove = itemView.findViewById(R.id.imgRemove);
        edit = itemView.findViewById(R.id.imgRemove);

    }
}