package com.example.vehicleAuctionSystem.SubTeamSeller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubTeamSeller {

    @Id
    private int subTeamSellerId;
    private int subTeamId;
    private int sellerId;
    private String sellerName;
    private String subTeamName;
    private boolean isLinkActive;

    public SubTeamSeller(){
        super();
    }

    public SubTeamSeller(int subTeamSellerId, int subTeamId, int sellerId, String sellerName, String subTeamName,boolean isLinkActive ){
        super();
        this.subTeamSellerId = subTeamSellerId;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.subTeamId = subTeamId;
        this.subTeamName = subTeamName;
        this.isLinkActive = isLinkActive;
    }

    public int getSubTeamSellerId() {
        return subTeamSellerId;
    }

    public void setSubTeamSellerId(int subTeamSellerId) {
        this.subTeamSellerId = subTeamSellerId;
    }

    public int getSubTeamId() {
        return subTeamId;
    }

    public void setSubTeamId(int subTeamId) {
        this.subTeamId = subTeamId;
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

    public String getSubTeamName() {
        return subTeamName;
    }

    public void setSubTeamName(String subTeamName) {
        this.subTeamName = subTeamName;
    }

    public boolean isLinkActive() {
        return isLinkActive;
    }

    public void setLinkActive(boolean linkActive) {
        isLinkActive = linkActive;
    }
}
