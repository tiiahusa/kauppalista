package com.example.kauppalista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private GroceryList list;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvGroceryList); // linked code to recyclerviewer
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // set it linearlayoutmanager


        list = GroceryList.getInstance(); // Create list or get created one
        recyclerView.setAdapter(new GroceryListAdapter(getApplicationContext(), list.getListByName()));
        PrintList();


    }

    public void OrderByTime (View view) {
        recyclerView.setAdapter(new GroceryListAdapter(getApplicationContext(), list.getListByTime()));
    }

    public void OrderByName (View view) {
        recyclerView.setAdapter(new GroceryListAdapter(getApplicationContext(), list.getListByName()));
    }

    public void AddGrocery(View view) {

        Intent intent = new Intent(this, AddGrocery.class);
        startActivity(intent);

    }

    public void PrintList() {
        System.out.println("Lista aakkosjärjestyksessä: ");
        list.getListByName().forEach(item -> System.out.print(item.getGrocery() + " Muista: " + item.getRem() + " Kirjattu: " + item.getTimeToString()));
        System.out.println("");
        System.out.println("Lista aikajärjestyksessä: ");
        list.getListByTime().forEach(item -> System.out.print(item.getGrocery() + " Muista: " + item.getRem() + " Kirjattu: " + item.getTimeToString()));
        System.out.println("\n");
    }

}