/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3travelplans;

import java.util.Date;

/**
 *
 * @author 0639300
 */
public class Trip {

    long id;
    String destination;
    int dailyBudget;
    Date departureDate;
    Date returnDate;
    TransMode transport;

    enum TransMode {
        Car, Train, Plane, Other
    }

    public Trip(long id, String destination, int dailyBudget, Date departureDate, Date returnDate, TransMode transport) {
        this.id = id;
        this.destination = destination;
        this.dailyBudget = dailyBudget;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.transport = transport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination.length() > 100 || destination.length() < 1) {
            throw new IllegalArgumentException("Length needs to be between 1 and 100");

        }
        if (!destination.matches("[a-zA-Z0-9/\\s/-]*")) {
            throw new IllegalArgumentException("Error");
        }
        this.destination = destination;
    }

    public int getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(int dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public TransMode getTransport() {
        return transport;
    }

    public void setTransport(TransMode transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "To " + destination + " on $" + dailyBudget + "/day from " + departureDate + " to " + returnDate + " by " + transport;
    }

}
