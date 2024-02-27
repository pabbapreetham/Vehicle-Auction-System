package com.example.vehicleAuctionSystem.SubTeamSeller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTeamSellerService {

    @Autowired
    SubTeamSellerMapper subTeamSellerMapper;

    // Service method to add link for seller and subteam
    public boolean addLinkForSellerAndSubTeam(SubTeamSeller subTeamSeller){

        return subTeamSellerMapper.createSubTeamSeller(subTeamSeller);

    }
}
