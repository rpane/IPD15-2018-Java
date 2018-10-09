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
        String dbUrl = "jdbc:mysql://localhost:3306/auto";
        conn = DriverManager.getConnection(dbUrl, "root", "root");
    }

    ArrayList<Car> getAllCars() throws SQLException {
        ArrayList<Car> resultList = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM  cars");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("id");
            String makeModel = rs.getString("makeModel");
            BigDecimal engineSize = rs.getBigDecimal("engineSize");
            String fuel = rs.getString("fuelType");
            FuelType fuelType = FuelType.valueOf(fuel);
            resultList.add(new Car(id, makeModel, engineSize, fuelType));
        }
        return resultList;
    }

    void addCar(Car car) throws SQLException {
        String sql = "INSERT INTO cars VALUES (NULL, ?, ? ,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, car.getMakeModel());
        pstmt.setBigDecimal(2, car.getEngineSize());
        pstmt.setString(3, car.getFuelType().name());
        pstmt.executeUpdate();
    }

    void updateCar(Car car) throws SQLException {
        String sql = "UPDATE cars SET id = ?, makeModel = ?, engineSize = ? ,FuelType =? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, car.getId());
        pstmt.setString(2, car.getMakeModel());
        pstmt.setBigDecimal(3, car.getEngineSize());        
        pstmt.setString(4, car.getFuelType().name());
        pstmt.setLong(5,car.getId());
        pstmt.executeUpdate();
    }

    void deleteCarById(long id) throws SQLException {
        String sql = "DELETE FROM cars WHERE ID = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        // set the corresponding param
        pstmt.setLong(1, id);
        // execute the delete statement
        pstmt.executeUpdate();

    }

}
