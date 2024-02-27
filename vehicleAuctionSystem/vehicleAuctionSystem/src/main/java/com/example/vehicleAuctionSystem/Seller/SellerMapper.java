package com.example.vehicleAuctionSystem.Seller;

import com.example.vehicleAuctionSystem.User.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SellerMapper {

    // INSERT query to create a Seller
    @Insert("INSERT INTO Seller (sellerName, email, phone, ext, isSellerActive) " +
            "VALUES (#{sellerName}, #{email} , #{phone},  #{ext}, true);")
    boolean createSeller(Seller seller);

    // INSERT query to create a User
    @Insert("INSERT INTO User(sellerId, userName, password, isUserActive)" +
            "VALUES (#{sellerId}, #{userName}, #{password}, true)")
    boolean createUser(User user);

    // SELECT query to create a User
    @Select("SELECT * FROM User u WHERE u.userName = #{userName}")
    User login(User user);

    // SELECT query to get all sellers
    @Select("SELECT * FROM Seller s;")
    List<Seller> getSellers();


    // SELECT query to get Sellers with no Users using the VIEW "sellerWithUser"
    @Select("SELECT * FROM Seller s WHERE s.sellerId NOT IN " +
            "(SELECT su.sellerId FROM sellerWithUser su);")
    List<Seller> getSellersOfNoUser();


    // SELECT query to get SellerId from Seller by seller name and email
    @Select("SELECT sellerId FROM Seller s WHERE s.sellerName = #{sellerName} AND s.email = #{email};")
    int getSellerId(Seller seller);

    // UPDATE query to update the seller status for given sellerId
    @Update("UPDATE Seller s SET s.isSellerActive = #{status} WHERE s.sellerId = #{sellerId}")
    boolean updateSellerStatus(int sellerId, boolean status);

}
