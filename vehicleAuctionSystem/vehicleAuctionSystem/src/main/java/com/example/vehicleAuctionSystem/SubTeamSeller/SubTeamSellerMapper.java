package com.example.vehicleAuctionSystem.SubTeamSeller;

import com.example.vehicleAuctionSystem.Seller.Seller;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubTeamSellerMapper {

    // INSERT query to add link detaisl between seller and sub team
    @Insert("INSERT INTO SubTeamSeller (subTeamId, sellerId, sellerName, subTeamName, isLinkActive) " +
            "VALUES (#{subTeamId}, #{sellerId} , #{sellerName},  #{subTeamName}, true);")
    boolean createSubTeamSeller(SubTeamSeller subTeamSeller);
}
