package com.example.ingredientallergyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class InputFoodActivity extends AppCompatActivity {

    Button searchInput;
    EditText ingredientInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_foodname);

        searchInput = (Button) findViewById(R.id.searchInput);
        ingredientInput = (EditText) findViewById(R.id.ingredientInput);


    }

    ArrayList<String> ingredients = InputIngredientActivity.getIngredients();




}