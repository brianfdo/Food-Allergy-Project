package com.example.ingredientallergyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InputIngredientActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText ingredientInput;
    Button addIngredient, confirmInput;

    ArrayList<String> ingredients = new ArrayList<>();
    ArrayAdapter arrayAdapter1;

    Integer indexValue;
    String item;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_ingredient);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        addIngredient = (Button) findViewById(R.id.addIngredient);
        confirmInput = (Button) findViewById(R.id.confirmInput);
        ingredientInput = (EditText) findViewById(R.id.ingredientInput);

        //setup arrayAdapter for listView
        arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ingredients);
        recyclerView.setAdapter(arrayAdapter1);


        //add ingredients to listView
        addIngredient.setOnClickListener(v -> {
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
            }
            arrayAdapter1.notifyDataSetChanged();
            ingredientInput.setText("");
        });

        //delete ingredients from listView
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString() + "has been deleted";
                Toast.makeText(InputIngredientActivity.this, item, Toast.LENGTH_SHORT).show();

                ingredients.remove(position);
                arrayAdapter1.notifyDataSetChanged();
                
                return true;
            }
        });

    }




}
