/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3travelplans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import quiz3travelplans.Trip.TransMode;

/**
 *
 * @author 0639300
 */
public class Database {

    private Connection conn;

    public Database() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/travel";
        conn = DriverManager.getConnection(dbUrl, "root", "root");
    }

    ArrayList<Trip> getAllTrips() throws SQLException {
        ArrayList<Trip> resultList = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM  trips");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("id");
            String destination = rs.getString("destination");
            int dailyBudget = rs.getInt("dailyBudget");
            Date departureDate = rs.getDate("departureDate");
            Date returnDate = rs.getDate("returnDate");
            String trans = rs.getString("transport");
            TransMode transport = TransMode.valueOf(trans);
            resultList.add(new Trip(id, destination, dailyBudget, departureDate, returnDate, transport));
        }
        return resultList;
    }
    
     void addTrip(Trip trip) throws SQLException {
        String sql = "INSERT INTO trips VALUES (NULL, ?, ? ,?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, trip.getDestination());
        pstmt.setInt(2, trip.getDailyBudget());
        //Converting
        java.util.Date utilDepDate = trip.getDepartureDate();
        java.sql.Date sqlDepDate = new java.sql.Date(utilDepDate.getTime());        
        java.util.Date utilRetDate = trip.getReturnDate();
        java.sql.Date sqlRetDate = new java.sql.Date(utilRetDate.getTime());     
        
        
        pstmt.setDate(3,  sqlDepDate);
        pstmt.setDate(4,  sqlRetDate);
        pstmt.setString(5,trip.getTransport().name());
        pstmt.executeUpdate();
    }

}
