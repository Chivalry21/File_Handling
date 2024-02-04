package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;

public class StockFileHandler {
    public ArrayList<Stock> getFile(String fileName){ //method defination
        ArrayList<Stock> stocks = new ArrayList<>(); //Arrylist of stock to store stocks read from csv file that will be return by the function
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){ // try with resource to read csv file
            if(reader.ready()) //to check if the resource is available to use
                reader.readLine();
            Long count = 1L;
            while ((reader.ready())){
                String line = reader.readLine();
                String[]data = line.split(",");
                Stock stock = new Stock(count,Long.valueOf(data[0]),data[1], data[2],data[3],data[4],Double.valueOf(data[5]),Integer.valueOf(data[6]));
                System.out.println(stock.getColorPattern());
                    stocks.add(stock);
                    count++;

                }
            }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return stocks;
    }

}

