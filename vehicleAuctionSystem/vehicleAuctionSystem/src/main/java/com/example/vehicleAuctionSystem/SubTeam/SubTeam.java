package com.example.vehicleAuctionSystem.SubTeam;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubTeam {

    @Id
    private int subTeamId;
    private String subTeamName;
    private int companyId;
    private int addressId;

    private String country;

    public SubTeam(){
        super();
    }

    public SubTeam(int subTeamId, String subTeamName, int companyId, int addressId, String country ){
        super();
        this.subTeamId = subTeamId;
        this.companyId = companyId;
        this.addressId = addressId;
        this.subTeamName = subTeamName;
        this.country = country;
    }

    public int getSubTeamId() {
        return subTeamId;
    }

    public void setSubTeamId(int subTeamId) {
        this.subTeamId = subTeamId;
    }

    public String getSubTeamName() {
        return subTeamName;
    }

    public void setSubTeamName(String subTeamName) {
        this.subTeamName = subTeamName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
