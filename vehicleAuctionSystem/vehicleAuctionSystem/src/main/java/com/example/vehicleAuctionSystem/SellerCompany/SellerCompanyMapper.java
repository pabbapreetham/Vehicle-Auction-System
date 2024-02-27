package com.example.vehicleAuctionSystem.SellerCompany;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SellerCompanyMapper {

    // SELECT query to get all company details
    @Select("SELECT * from SellerCompany sc")
    List<SellerCompany> getCompanies();

    // INSERT query to add seller company details
    @Insert("INSERT INTO SellerCompany (companyName, addressId, country) " +
            "VALUES (#{companyName}, #{addressId} , #{country});")
    boolean createCompany(SellerCompany company);
}
