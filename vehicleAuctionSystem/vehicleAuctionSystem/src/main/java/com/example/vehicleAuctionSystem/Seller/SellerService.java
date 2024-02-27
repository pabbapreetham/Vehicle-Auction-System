package com.example.vehicleAuctionSystem.Seller;

import com.example.vehicleAuctionSystem.DTO.SellerDTO;
import com.example.vehicleAuctionSystem.SubTeamSeller.SubTeamSeller;
import com.example.vehicleAuctionSystem.SubTeamSeller.SubTeamSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    SubTeamSellerService subTeamSellerService;


    // Service method to create a Seller
    public boolean createSeller(SellerDTO sellerDTO){

        Seller seller = getSellerFromDTO(sellerDTO);
        sellerMapper.createSeller(seller);

        int sellerId = sellerMapper.getSellerId(seller);
        boolean res = false;

        List<Integer> subTeamIds = sellerDTO.getSubTeamIds();

        for(int subTeamId : subTeamIds) {

            SubTeamSeller subTeamSeller = new SubTeamSeller();
            subTeamSeller.setSellerId(sellerId);
            subTeamSeller.setSubTeamId(subTeamId);
            subTeamSeller.setLinkActive(true);

            res = subTeamSellerService.addLinkForSellerAndSubTeam(subTeamSeller);
        }

        return res;
    }

    // Service method to get seller POJO from DTO
    public Seller getSellerFromDTO(SellerDTO sellerDTO){
        Seller seller = new Seller();

        seller.setSellerName(sellerDTO.getSellerName());
        seller.setEmail(sellerDTO.getEmail());
        seller.setPhone(sellerDTO.getExt());
        seller.setExt(sellerDTO.getExt());
        seller.setSellerActive(sellerDTO.isSellerActive());

        return seller;
    }

    // Service method to get sellers who do not have users
    public List<Seller> getSellersOfNonUsers(){
        List<Seller> result = sellerMapper.getSellersOfNoUser();
        return result;
    }

    // Service method to get all sellers
    public List<Seller> getSellers(){
        List<Seller> result = sellerMapper.getSellers();
        return result;
    }

    //Service method to update the seller status for given seller id
    public boolean updateSellerStatus(int sellerId, boolean status){
        boolean result = sellerMapper.updateSellerStatus(sellerId, status);
        return result;
    }
}
