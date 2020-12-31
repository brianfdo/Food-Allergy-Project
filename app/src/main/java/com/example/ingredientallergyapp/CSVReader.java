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

    //public static String foodName(int i) {
    //return ;
    //}

    public static void readFile() {
        File f = new File("Products.csv");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String line = bfr.readLine();
            while (line != null) {
                int nbdNumber;
                String foodname;
                String manufacturer;
                String ingredients;

                int commaIndex = line.indexOf(",");
                nbdNumber = Integer.parseInt(line.substring(0, commaIndex));
                line = line.substring(commaIndex + 1);
                
                if ()

                line = bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

