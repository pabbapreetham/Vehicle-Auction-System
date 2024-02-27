package com.example.vehicleAuctionSystem.Address;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddressMapper {

    // Insert query to add address details
    @Insert("INSERT INTO Address (line1, line2, city, state, zipCode, country) " +
            "VALUES (#{line1}, #{line2}, #{city}, #{state}, #{zipCode}, #{country});")
    boolean insertAddress(Address address);

    // Select query to get addressId based on address details
    @Select("SELECT addressId FROM Address a WHERE a.line1 = #{line1} AND a.city = #{city} AND " +
            "a.state = #{state} AND a.zipCode = #{zipCode} LIMIT 1;")
    int getAddressId(Address address);

    // Select query to get address details for given addressId
    @Select("SELECT * FROM Address a WHERE a.addressId = #{addressId};")
    Address getAddressById(int addressId);
}
