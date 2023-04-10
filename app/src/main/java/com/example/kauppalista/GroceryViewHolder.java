package com.example.kauppalista;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

// Create class what extends recyclerviewer
public class GroceryViewHolder extends RecyclerView.ViewHolder {
    ImageView ibDelete, ibEdit;
    TextView txtProduct, txtRemember;


    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        txtProduct = itemView.findViewById(R.id.txtProduct);
        txtRemember = itemView.findViewById(R.id.txtRemember);

    }


}