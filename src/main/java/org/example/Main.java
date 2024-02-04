package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        String fileName = "./src/main/resources/record_sheet.csv";
        StockFileHandler fileHandler = new StockFileHandler();

        ArrayList<Stock> stocks = fileHandler.getFile(fileName);
        StockRepository stockRepository = new StockRepository();
      // stockRepository.createTable();
        stockRepository.save(stocks);
        stockRepository.close();


        git add README.md
        git commit -m "first commit"
        git branch -M main
        git remote add origin https://github.com/Chivalry21/File_Handling.git
        git push -u origin main

    }
}