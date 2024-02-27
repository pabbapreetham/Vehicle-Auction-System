package com.example.vehicleAuctionSystem.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressMapper addressMapper;

    // Service method to insert address
    public int insertAddress(Address address){
        addressMapper.insertAddress(address);
        int addressId = addressMapper.getAddressId(address);
        return addressId;
    }
}
