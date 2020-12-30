package com.example.ingredientallergyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InputIngredientActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    RecyclerView recyclerView;
    EditText ingredientInput;
    Button addIngredient, confirmInput;

    public static ArrayList<String> ingredients = new ArrayList<>();
    RecyclerViewAdapter adapter;

    Integer indexValue;
    String item;

    public static ArrayList<String> getIngredients() {
        return ingredients;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_ingredient);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        addIngredient = (Button) findViewById(R.id.addIngredient);
        confirmInput = (Button) findViewById(R.id.confirmInput);
        ingredientInput = (EditText) findViewById(R.id.ingredientInput);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, ingredients);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        //add ingredients to RecyclerView
        addIngredient.setOnClickListener(v ->
        {
            String input = ingredientInput.getText().toString();
            boolean add = true;
            if (input.equals("")) {
                add = false;
            }
            for (int i = 32; i < 65; i++) {
                if (input.contains(String.format("%s", (char) i))) {
                    add = false;
                }
            }
            if (add) {
                ingredients.add(input);
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
            adapter.notifyDataSetChanged();
            ingredientInput.setText("");
        });

        ingredientInput.setOnClickListener(v -> {
            ingredientInput.setText("");
            adapter.notifyDataSetChanged();
        });

        confirmInput.setOnClickListener(this::enterApp);


    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    public void enterApp(View view) {
        Intent intent = new Intent(this, InputFoodActivity.class);
        startActivity(intent);
    }

}

