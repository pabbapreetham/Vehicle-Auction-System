package com.example.vehicleAuctionSystem.Vehicle;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    private int vehicleId;
    private int userId;
    private String VIN;
    private String modelName;
    private String vehicleCompany;
    private boolean isAuction;


    public Vehicle(){
        super();
    }

    public Vehicle(int vehicleId, int userId, String VIN, String modelName, String vehicleCompany, boolean isAuction ){
        super();
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.VIN = VIN;
        this.modelName = modelName;
        this.vehicleCompany = vehicleCompany;
        this.isAuction = isAuction;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVehicleCompany() {
        return vehicleCompany;
    }

    public void setVehicleCompany(String vehicleCompany) {
        this.vehicleCompany = vehicleCompany;
    }

    public boolean isAuction() {
        return isAuction;
    }

    public void setAuction(boolean auction) {
        isAuction = auction;
    }
}
