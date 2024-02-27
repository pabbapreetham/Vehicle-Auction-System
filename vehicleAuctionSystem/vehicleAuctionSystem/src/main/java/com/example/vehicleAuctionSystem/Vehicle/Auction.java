package com.example.vehicleAuctionSystem.Vehicle;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Auction {

    @Id
    private int auctionId;
    private int vehicleId;

    private String auctionDate;
    private int basePrice;
    private boolean auctionStatus;

    public Auction(){
        super();
    }

    public Auction(int auctionId, int vehicleId, int basePrice, String date, boolean auctionStatus ){
        super();
        this.auctionId = auctionId;
        this.vehicleId = vehicleId;
        this.auctionDate = date;
        this.basePrice = basePrice;
        this.auctionStatus = auctionStatus;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(String auctionDate) {
        this.auctionDate = auctionDate;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(boolean auctionStatus) {
        this.auctionStatus = auctionStatus;
    }
}
