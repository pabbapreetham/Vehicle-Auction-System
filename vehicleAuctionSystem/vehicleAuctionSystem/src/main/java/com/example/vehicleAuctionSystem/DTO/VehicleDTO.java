package com.example.vehicleAuctionSystem.DTO;

public class VehicleDTO {

    private int vehicleId;
    private int userId;
    private String VIN;
    private String modelName;
    private String vehicleCompany;
    private boolean auctionOrDirect;
    private int auctionId;
    private String auctionDate;
    private int basePrice;
    private boolean auctionStatus;
    private int directBuyId;
    private int price;
    private boolean vehicleStatus;

    public VehicleDTO(){
        super();
    }

    public VehicleDTO(int vehicleId, int userId, String VIN, String modelName, String vehicleCompany,
                      boolean auctionOrDirect ,int directBuyId, int price, boolean vehicleStatus,
                      int auctionId, int basePrice, String date, boolean auctionStatus){
        super();
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.VIN = VIN;
        this.modelName = modelName;
        this.vehicleCompany = vehicleCompany;
        this.auctionOrDirect = auctionOrDirect;
        this.directBuyId = directBuyId;
        this.price = price;
        this.vehicleStatus = vehicleStatus;
        this.auctionId = auctionId;
        this.auctionDate = date;
        this.basePrice = basePrice;
        this.auctionStatus = auctionStatus;
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

    public boolean getAuctionOrDirect() {
        return auctionOrDirect;
    }

    public void setAuctionOrDirect(boolean auctionOrDirect) {
        this.auctionOrDirect = auctionOrDirect;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
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

    public int getDirectBuyId() {
        return directBuyId;
    }

    public void setDirectBuyId(int directBuyId) {
        this.directBuyId = directBuyId;
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
