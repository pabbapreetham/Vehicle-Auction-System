package com.example.vehicleAuctionSystem.SellerCompany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SellerCompany {

    @Id
    @Column(name="companyId")
    private int companyId;

    @Column(name="companyName")
    private String companyName;

    @Column(name="addressId")
    private int addressId;

    @Column(name="country")
    private String country;

    public SellerCompany(){
        super();
    }

    public SellerCompany(int companyId, String companyName, int addressId, String country ){
        //super();
        this.companyId = companyId;
        this.addressId = addressId;
        this.companyName = companyName;
        this.country = country;
    }
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    @Override
    public String toString() {
        return "SellerCompany{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", addressId=" + addressId +
                ", country='" + country + '\'' +
                '}';
    }
}
