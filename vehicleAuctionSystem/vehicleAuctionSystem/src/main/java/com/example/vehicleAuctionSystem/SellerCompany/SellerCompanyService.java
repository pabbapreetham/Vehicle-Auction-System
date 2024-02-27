package com.example.vehicleAuctionSystem.SellerCompany;

import com.example.vehicleAuctionSystem.Address.Address;
import com.example.vehicleAuctionSystem.Address.AddressMapper;
import com.example.vehicleAuctionSystem.Address.AddressService;
import com.example.vehicleAuctionSystem.DTO.SellerCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerCompanyService {

    @Autowired
    SellerCompanyMapper sellerCompanyMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    AddressService addressService;


    // Service method to create seller company
    public boolean createCompany(SellerCompanyDTO companyDTO){

        Address address = getAddressFromDTO(companyDTO);
        int aId = addressService.insertAddress(address);
        SellerCompany sellerCompany = getSellerCompanyFromDTO(companyDTO);
        sellerCompany.setAddressId(aId);
        boolean result = sellerCompanyMapper.createCompany(sellerCompany);

        return result;

    }

    // Service method to get companyDTOs
    public List<SellerCompanyDTO> getCompanieDTOs(){
        List<SellerCompany> sc = sellerCompanyMapper.getCompanies();

        List<SellerCompanyDTO> result = new ArrayList<>();

        for(SellerCompany temp: sc){
            int adId = temp.getAddressId();
            Address address = addressMapper.getAddressById(adId);

            SellerCompanyDTO scd = setAddressToDTO(address);
            scd.setCompanyName(temp.getCompanyName());
            scd.setCompanyId(temp.getCompanyId());

            result.add(scd);
        }

        return result;
    }

    // Service method to get companies
    public List<SellerCompany> getCompanies(){
        System.out.println("get all companies: service");
        List<SellerCompany> result = sellerCompanyMapper.getCompanies();
        return result;
    }

    // Service method to get address details from DTO
    public Address getAddressFromDTO(SellerCompanyDTO companyDTO){
        Address address = new Address();
        address.setLine1(companyDTO.getLine1());
        address.setLine2(companyDTO.getLine2());
        address.setCity(companyDTO.getCity());
        address.setState(companyDTO.getState());
        address.setZipCode(companyDTO.getZipCode());
        address.setCountry(companyDTO.getCountry());

        return address;
    }

    // Service method to set address details to DTO
    public SellerCompanyDTO setAddressToDTO(Address address){
        SellerCompanyDTO sellerCompanyDTO = new SellerCompanyDTO();

        sellerCompanyDTO.setLine1(address.getLine1());
        sellerCompanyDTO.setLine2(address.getLine2());
        sellerCompanyDTO.setCity(address.getCity());
        sellerCompanyDTO.setState(address.getState());
        sellerCompanyDTO.setZipCode(address.getZipCode());
        sellerCompanyDTO.setCountry(address.getCountry());

        return sellerCompanyDTO;
    }

    // Service method to get company details from DTO
    public SellerCompany getSellerCompanyFromDTO(SellerCompanyDTO sellerCompanyDTO){
        SellerCompany sellerCompany = new SellerCompany();
        sellerCompany.setCompanyName(sellerCompanyDTO.getCompanyName());
        sellerCompany.setCountry(sellerCompanyDTO.getCountry());

        return sellerCompany;
    }
}
