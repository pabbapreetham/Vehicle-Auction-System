package com.example.vehicleAuctionSystem.DTO;

public class SubTeamDTO {

    private int subTeamId;
    private String subTeamName;
    private int companyId;
    private int addressId;

    private String country;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zipCode;

    public SubTeamDTO(){
        super();
    }

    public SubTeamDTO(int subTeamId, String subTeamName, int companyId, int addressId, String line1, String line2, String city, String state, String zipCode, String country ){
        super();
        this.subTeamId = subTeamId;
        this.companyId = companyId;
        this.addressId = addressId;
        this.subTeamName = subTeamName;
        this.country = country;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
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

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
