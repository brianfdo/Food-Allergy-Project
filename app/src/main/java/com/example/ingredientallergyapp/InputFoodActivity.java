package com.example.ingredientallergyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class InputFoodActivity extends AppCompatActivity {


    public static String foodName;
    Button searchInput;
    EditText ingredientInput;

    public static String getFoodName() {
        return foodName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_foodname);

        searchInput = (Button) findViewById(R.id.searchInput);
        ingredientInput = (EditText) findViewById(R.id.ingredientInput);

        String space = " ";
        searchInput.setOnClickListener(v -> {
            String input = ingredientInput.getText().toString();
            input = input.toUpperCase();
            input = space.concat(input);

            boolean add = true;
            if (input == null || input.equals("")) {
                add = false;
            }
            for (int i = 32; i < 65; i++) {
                if (input.contains(String.format("%s", (char) i))) {
                    add = false;
                }
            }
            if (add) {
                foodName = input;
            }
        });

        searchInput.setOnClickListener(this::enterOptions);
    }

    public void enterOptions(View view) {
        Intent intent = new Intent(this, FoodOptionsActivity.class);
        startActivity(intent);
    }




}