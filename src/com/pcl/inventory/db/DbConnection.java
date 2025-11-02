package com.pcl.inventory.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private  final Connection connection;
    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
      this.connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymvc2","root","1234");

    }
    public static DbConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbConnection==null){
            dbConnection= new DbConnection();
        }
        return dbConnection;
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return connection;
    }
}
