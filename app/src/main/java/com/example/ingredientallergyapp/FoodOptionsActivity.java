package com.example.ingredientallergyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FoodOptionsActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    RecyclerView foodOptions;
    RecyclerViewAdapter adapter;

    private static ArrayList<String> foodNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_options);

        foodOptions = (RecyclerView) findViewById(R.id.options);

        // search for valid foods
        String food = InputFoodActivity.getFoodName();
        Pattern pattern = Pattern.compile(food, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (BrandedFood item : CSVReader.brandedFoods) {
            matcher = pattern.matcher(item.getFoodName());
            boolean matchFound = matcher.find();
            if(matchFound) {
                foodNames.add(item.getFoodName());
            }
        }

        // set up the RecyclerView
        foodOptions.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, foodNames);
        adapter.setClickListener(this);
        foodOptions.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}