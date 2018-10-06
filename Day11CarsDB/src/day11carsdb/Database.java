

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day11carsdb;

import day11carsdb.Car.FuelType;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MrSkud
 */
public class Database {
    
    private Connection conn;

    public Database() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/automotive";
        conn = DriverManager.getConnection(dbUrl, "root", "root");
    }

    ArrayList<Car> getAllCars() throws SQLException {
        ArrayList<Car> resultList = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM  dbo.cars");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("id");
            String makeModel = rs.getString("makeModel");
            BigDecimal engineSize = rs.getBigDecimal("engineSize");
            FuelType fuelType = rs.("fuelType");
            resultList.add(new Car(id,makeModel, engineSize, fuelType));
        }
        return resultList;
    }
        
}
