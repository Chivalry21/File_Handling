package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class StockRepository {
    private Connection connection;
    private String dbName;
    private String user;
    private String pwd;
    public StockRepository(){
        Properties env = LoadProperties.getEnvProperties("./src/.env");
        this.dbName = env.getProperty("DB_NAME");
        this.user = env.getProperty("DB_USER");
        this.pwd= env.getProperty("DB_PWD");
    }
    private void createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, pwd);
            if (connection != null) {
                System.out.println("connection established");
            } else {
                System.out.println("connection failed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void  save(ArrayList<Stock> stocks) throws SQLException {
        createConnection();
        String INSERT_STOCKS_SQL = "INSERT INTO stocks (serial_num, name, size, color_pattern, material, price, qty) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(INSERT_STOCKS_SQL);

            int count = 0;

            for (Stock stock : stocks) {
                pstmt.setLong(1, stock.getSerialNum());
                pstmt.setString(2, stock.getName());
                pstmt.setString(3, stock.getSize());
                pstmt.setString(4, stock.getColorPattern());
                pstmt.setString(5, stock.getMaterial());
                pstmt.setDouble(6, stock.getPrice());
                pstmt.setInt(7, stock.getQty());

                pstmt.addBatch();

                if (++count % 1000 == 0 || count == stocks.size()) {
                    pstmt.executeBatch(); // Execute every 1000 items or at the end of the list
                }
            }
            System.out.println("Inserted " + count + " records into the database.");


        }

    public void createTable() throws SQLException {
        createConnection();
        String cTable = "CREATE TABLE stocks ( " +
                "id SERIAL PRIMARY KEY, " +
                "serial_num BIGINT, " +
                "name VARCHAR(255), " +
                "size VARCHAR(50), " +
                "color_pattern VARCHAR(100), " +
                "material VARCHAR(100), " +
                "price NUMERIC(10, 2), " +
                "qty INTEGER" +
                ");";

        Statement statement = connection.createStatement();
        statement.execute(cTable);
    }
    public void close() throws SQLException {
        connection.close();
    }
}