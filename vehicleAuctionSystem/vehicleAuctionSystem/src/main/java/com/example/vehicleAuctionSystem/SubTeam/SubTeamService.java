package com.example.vehicleAuctionSystem.SubTeam;

import com.example.vehicleAuctionSystem.Address.Address;
import com.example.vehicleAuctionSystem.Address.AddressService;
import com.example.vehicleAuctionSystem.DTO.SubTeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTeamService {

    @Autowired
    SubTeamMapper subTeamMapper;

    @Autowired
    AddressService addressService;

    //Service method to create Sub Team
    public boolean createSubTeam(SubTeamDTO subTeamDTO){

        Address address = getAddressFromDTO(subTeamDTO);
        int aId = addressService.insertAddress(address);
        SubTeam subTeam = getSubTeamFromDTO(subTeamDTO);
        subTeam.setAddressId(aId);
        boolean result = subTeamMapper.createSubTeam(subTeam);

        return result;

    }

    // Service method to get all subteams
    public List<SubTeam> getSubTeams(){
        List<SubTeam> result = subTeamMapper.getSubTeams();
        return result;
    }

    // Service to get sub teams under a company
    public List<SubTeam> getSubTeamsForCompany(int companyId){
        List<SubTeam> result = subTeamMapper.getSubTeamsForCompany(companyId);
        return result;
    }

    // Service method to get address details from DTO
    public Address getAddressFromDTO(SubTeamDTO subTeamDTO){
        Address address = new Address();
        address.setLine1(subTeamDTO.getLine1());
        address.setLine2(subTeamDTO.getLine2());
        address.setCity(subTeamDTO.getCity());
        address.setState(subTeamDTO.getState());
        address.setZipCode(subTeamDTO.getZipCode());
        address.setCountry(subTeamDTO.getCountry());

        return address;
    }

    // Service method to get sub team POJO from DTO
    public SubTeam getSubTeamFromDTO(SubTeamDTO subTeamDTO){
        SubTeam subTeam = new SubTeam();

        subTeam.setSubTeamName(subTeamDTO.getSubTeamName());
        subTeam.setCountry(subTeamDTO.getCountry());
        subTeam.setCompanyId(subTeamDTO.getCompanyId());

        return subTeam;
    }
}
