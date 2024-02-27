package com.example.vehicleAuctionSystem.Vehicle;

import com.example.vehicleAuctionSystem.DTO.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleMapper vehicleMapper;

    // Service method to create vehicle details
    public boolean createVehicle(VehicleDTO vehicleDTO){

//        Vehicle vehicle = getVehicleFromDTO(vehicleDTO);
//        vehicleMapper.createVehicle(vehicle);
//        int vehId = vehicleMapper.getVehicleId(vehicle);
//
//        if(vehicleDTO.getAuctionOrDirect()){
//            Auction auction = getAuctionFromDTO(vehicleDTO);
//            auction.setVehicleId(vehId);
//
//            vehicleMapper.addAuction(auction);
//        }
//        else{
//            DirectBuy directBuy = getDirectBuyFromDTO(vehicleDTO);
//            directBuy.setVehicleId(vehId);
//
//            vehicleMapper.addDirectBuy(directBuy);
//        }

        vehicleMapper.
                createVehicleOBJ(vehicleDTO.getUserId(), vehicleDTO.getVIN(), vehicleDTO.getModelName(), vehicleDTO.getVehicleCompany(),
                            vehicleDTO.getAuctionOrDirect(), vehicleDTO.getAuctionDate(), vehicleDTO.getBasePrice(), true, vehicleDTO.getPrice(), true);

        return true;
    }

    // Service method to get vehicle details by userId
    public List<VehicleDTO> getVehiclesByUserId(int userId){
        List<Vehicle> vehicles = vehicleMapper.getVehiclesForUserId(userId);

        List<VehicleDTO> res = new ArrayList<>();

        for(Vehicle v: vehicles){
            int vehicleId = v.getVehicleId();
            if(v.isAuction()){
                Auction auction = vehicleMapper.getAuctionData(vehicleId);
                VehicleDTO vehicleDTO = this.setAuctionDataToDTO(v, auction);
                res.add(vehicleDTO);
            }
            else{
                DirectBuy directBuy = vehicleMapper.getDirectBuyData(vehicleId);
                VehicleDTO vehicleDTO = this.setDirectBuyDataToDTO(v, directBuy);
                res.add(vehicleDTO);
            }
        }

        return res;
    }

    // Service method to set auction data to DTO
    public VehicleDTO setAuctionDataToDTO(Vehicle vehicle, Auction auction){
        VehicleDTO res = new VehicleDTO();
        res.setVehicleId(vehicle.getVehicleId());
        res.setUserId(vehicle.getUserId());
        res.setVIN(vehicle.getVIN());
        res.setModelName(vehicle.getModelName());
        res.setVehicleCompany(vehicle.getVehicleCompany());
        res.setAuctionOrDirect(true);

        res.setAuctionId(auction.getAuctionId());
        res.setAuctionDate(auction.getAuctionDate());
        res.setBasePrice(auction.getBasePrice());
        res.setAuctionStatus(auction.isAuctionStatus());

        return res;
    }

    // Service method to set directbuy data to DTO
    public VehicleDTO setDirectBuyDataToDTO(Vehicle vehicle, DirectBuy directBuy){
        VehicleDTO res = new VehicleDTO();
        res.setVehicleId(vehicle.getVehicleId());
        res.setUserId(vehicle.getUserId());
        res.setVIN(vehicle.getVIN());
        res.setModelName(vehicle.getModelName());
        res.setVehicleCompany(vehicle.getVehicleCompany());
        res.setAuctionOrDirect(false);

        res.setDirectBuyId(directBuy.getDirectBuyId());
        res.setPrice(directBuy.getPrice());
        res.setVehicleStatus(directBuy.isVehicleStatus());

        return res;
    }

    // Service method to get vehicle details from DTO
    public Vehicle getVehicleFromDTO(VehicleDTO vehicleDTO){
        Vehicle vehicle =  new Vehicle();

        vehicle.setVehicleCompany(vehicleDTO.getVehicleCompany());
        vehicle.setVIN(vehicleDTO.getVIN());
        vehicle.setModelName(vehicleDTO.getModelName());
        vehicle.setUserId(vehicleDTO.getUserId());
        vehicle.setAuction(vehicleDTO.getAuctionOrDirect());

        return vehicle;
    }

    // Service method to get direct buy details from DTO
    public DirectBuy getDirectBuyFromDTO(VehicleDTO vehicleDTO){
        DirectBuy directBuy = new DirectBuy();

        directBuy.setVehicleId(vehicleDTO.getVehicleId());
        directBuy.setPrice(vehicleDTO.getPrice());
        directBuy.setVehicleStatus(vehicleDTO.isVehicleStatus());

        return directBuy;
    }

    // Service method to get auction details from DTO
    public Auction getAuctionFromDTO(VehicleDTO vehicleDTO){
        Auction auction =new Auction();
        auction.setVehicleId(vehicleDTO.getVehicleId());
        auction.setAuctionDate(vehicleDTO.getAuctionDate());
        auction.setBasePrice(vehicleDTO.getBasePrice());
        auction.setAuctionStatus(vehicleDTO.isAuctionStatus());

        return auction;
    }
}
