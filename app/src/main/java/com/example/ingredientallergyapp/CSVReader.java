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

                //extract nbdNumber for easy id
                int index = line.indexOf(",");
                nbdNumber = Integer.parseInt(line.substring(0, index));
                line = line.substring(index + 1);

                //extract foodName
                if (line.startsWith("\"")) {
                    line = line.substring(1);
                    index = line.indexOf("\"");
                    foodname = line.substring(0, index);
                    line = line.substring(index + 1);
                } else {
                    index = line.indexOf(",");
                    foodname = line.substring(0, index);
                    line = line.substring(index);
                }

                //extract manufacturer
                

                line = bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

