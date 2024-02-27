package com.example.vehicleAuctionSystem.Vehicle;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;


@Mapper
public interface VehicleMapper {


    // SELECT query to call the STORED PROCEDURE "createVehicle" to add vehicle details
    @Select("{call createVehicle(#{userId}, #{VIN}, #{modelName}, #{vehicleCompany}, #{isAuction}, #{auctionDate}, #{basePrice}, #{auctionStatus}," +
            "#{price}, #{vehicleStatus})}")
    @Options(statementType = StatementType.CALLABLE)
    void createVehicleOBJ(int userId, String VIN, String modelName, String vehicleCompany, Boolean isAuction, String auctionDate, int
                             basePrice, Boolean auctionStatus, int price, Boolean vehicleStatus);

    // SELECT query to get vehicleId by userID and VIN
    @Select("SELECT vehicleId FROM Vehicle v WHERE v.userId = #{userId} AND v.VIN = #{VIN}")
    int getVehicleId(Vehicle vehicle);

    // INSERT query to add directBuy details
    @Insert("INSERT INTO DirectBuy (vehicleId, price, vehicleStatus)" +
            "VALUES (#{vehicleId}, #{price}, #{vehicleStatus})")
    boolean addDirectBuy(DirectBuy directBuy);

    // INSERT query to add auction details
    @Insert("INSERT INTO Auction (vehicleId, auctionDate, basePrice, auctionStatus)" +
            "VALUES (#{vehicleId}, #{auctionDate}, #{basePrice}, #{auctionStatus})")
    boolean addAuction(Auction auction);

    // SELECT query to get auction details by vehicleId
    @Select("SELECT * FROM Auction a WHERE a.vehicleId = #{vehicleId};")
    Auction getAuctionData(int vehicleId);

    // SELECT query to get direct buy details by vehicleId
    @Select("SELECT * FROM DirectBuy db WHERE db.vehicleId = #{vehicleId};")
    DirectBuy getDirectBuyData(int vehicleId);

    // Select query to get vehicle details by userId
    @Select("SELECT * FROM Vehicle v WHERE v.userId = #{userId}")
    List<Vehicle> getVehiclesForUserId(int userId);



}
