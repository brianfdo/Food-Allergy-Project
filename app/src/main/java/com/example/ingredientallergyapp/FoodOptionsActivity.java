package com.example.ingredientallergyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FoodOptionsActivity extends AppCompatActivity {

    RecyclerView foodOptions;

    private static ArrayList<String> foodNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_options);

        foodOptions = (RecyclerView) findViewById(R.id.options);
        
    }
}