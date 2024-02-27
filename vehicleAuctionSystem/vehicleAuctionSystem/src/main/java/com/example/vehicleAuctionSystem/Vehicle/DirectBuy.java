package com.example.vehicleAuctionSystem.Vehicle;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DirectBuy {

    @Id
    private int directBuyId;
    private int vehicleId;
    private int price;
    private boolean vehicleStatus;

    public DirectBuy(){
        super();
    }

    public DirectBuy(int directBuyId, int vehicleId, int price, boolean vehicleStatus){
        super();
        this.directBuyId = directBuyId;
        this.vehicleId = vehicleId;
        this.price = price;
        this.vehicleStatus = vehicleStatus;
    }

    public int getDirectBuyId() {
        return directBuyId;
    }

    public void setDirectBuyId(int directBuyId) {
        this.directBuyId = directBuyId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(boolean vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

}
