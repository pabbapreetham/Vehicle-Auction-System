package com.example.vehicleAuctionSystem.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private int userId;
    private int sellerId;
    private String userName;
    private String password;
    private boolean isUserActive;

    public User(){
        super();
    }

    public User(int userId, int sellerId, String userName, String password,boolean isUserActive ){
        super();
        this.userId = userId;
        this.sellerId = sellerId;
        this.userName = userName;
        this.password = password;
        this.isUserActive = isUserActive;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserActive() {
        return isUserActive;
    }

    public void setUserActive(boolean userActive) {
        isUserActive = userActive;
    }
}
