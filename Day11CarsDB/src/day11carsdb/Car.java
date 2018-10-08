/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day11carsdb;

import java.math.BigDecimal;

/**
 *
 * @author MrSkud
 */
public class Car {
    private long id;
    private String makeModel;
    private BigDecimal engineSize;
    FuelType fuelType;	
    enum FuelType { Gasoline, Diesel, Propane, Other };

    public Car(long id, String makeModel, BigDecimal engineSize, FuelType fuelType) {
        this.id = id;
        this.makeModel = makeModel;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public BigDecimal getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(BigDecimal engineSize) {
        this.engineSize = engineSize;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return  id + " " + makeModel + " " + engineSize + " " + fuelType;
    }
    
    
}
