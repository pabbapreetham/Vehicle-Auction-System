package com.example.vehicleAuctionSystem.Address;

import com.example.vehicleAuctionSystem.SellerCompany.SellerCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query(
            value = "INSERT INTO Address (line1, line2, city, state, zipCode, country)\n" +
                    "VALUES (address.line1, address.line2, address.city, address.state, address.zipCode, address.country);",
            nativeQuery = true)
    boolean insertAddress(Address address);


}
