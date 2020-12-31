package com.example.ingredientallergyapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVReader {
    public static ArrayList<BrandedFood> brandedFoods = new ArrayList<>();

    public static void addFood(BrandedFood item) {
        brandedFoods.add(item);
    }
    
    public static void readFile() {
        File f = new File("Products.csv");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            int counter = 0;
            String line = bfr.readLine();
            while (line != null) {
                while (counter < 2) {
                    line = bfr.readLine();
                    counter++;
                }
                int nbdNumber;
                String foodName;
                String manufacturer;
                String ingredients;

                //extract nbdNumber for easy id
                int index = line.indexOf(",");
                nbdNumber = Integer.parseInt(line.substring(0, index));
                line = line.substring(index + 1);

                //extract foodName
                if (line.startsWith("\"")) {
                    line = line.substring(1);
                    index = line.indexOf("\"");
                    foodName = line.substring(0, index);
                    line = line.substring(index + 2);
                } else {
                    index = line.indexOf(",");
                    foodName = line.substring(0, index);
                    line = line.substring(index + 1);
                }

                //extract manufacturer
                for (int i = 0; i < 2; i++) {
                    index = line.indexOf(",");
                    line = line.substring(index + 1);
                }
                if (line.startsWith("\"")) {
                    line = line.substring(1);
                    index = line.indexOf("\"");
                    manufacturer = line.substring(0, index);
                    line = line.substring(index + 2);
                } else {
                    index = line.indexOf(",");
                    manufacturer = line.substring(0, index);
                    line = line.substring(index + 1);
                }
                if (manufacturer == null || manufacturer.equals("")) {
                    manufacturer = "N/A";
                }

                //extract ingredients
                for (int i = 0; i < 2; i++) {
                    index = line.indexOf(",");
                    line = line.substring(index + 1);
                }
                if (line.startsWith("\"")) {
                    line = line.substring(1);
                    index = line.indexOf("\"");
                    ingredients = line.substring(0, index);
                } else {
                    ingredients = line;
                }

                //create food item object
                BrandedFood brandedFood = new BrandedFood(nbdNumber, foodName, manufacturer, ingredients);
                addFood(brandedFood);

                line = bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

