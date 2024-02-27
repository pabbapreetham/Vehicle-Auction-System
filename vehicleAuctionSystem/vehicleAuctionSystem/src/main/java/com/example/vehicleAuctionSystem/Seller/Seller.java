package com.example.vehicleAuctionSystem.Seller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seller {

    @Id
    private int sellerId;
    private String sellerName;
    private String email;
    private int phone;
    private int ext;
    private boolean isSellerActive;

    public Seller(){
        super();
    }

    public Seller(int sellerId, String sellerName, String email, int phone, int ext, boolean isSellerActive ){
        super();
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.email = email;
        this.phone = phone;
        this.ext = ext;
        this.isSellerActive = isSellerActive;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getExt() {
        return ext;
    }

    public void setExt(int ext) {
        this.ext = ext;
    }

    public boolean isSellerActive() {
        return isSellerActive;
    }

    public void setSellerActive(boolean sellerActive) {
        isSellerActive = sellerActive;
    }

}
