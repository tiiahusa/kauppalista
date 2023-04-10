package com.example.kauppalista;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditGrocery extends AppCompatActivity {

    private EditText tbGrocery, tbRem;
    private GroceryList list;
    private  Grocery grocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);

        tbGrocery = findViewById(R.id.tbGroceryName); // Link textboxes to code
        tbRem = findViewById(R.id.tbRemText);
        list = GroceryList.getInstance();

    }

    public void Add(View view) {
        // Create new Grocery // Get text from textboxes and add those to Grocery
        grocery = new Grocery(tbGrocery.getText().toString(), tbRem.getText().toString());
        list.addGroceryToList(grocery); // Add grocery to list

        BackToMainPage();
    }

    public void BackToMainPage(){
        // Go back to main page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}