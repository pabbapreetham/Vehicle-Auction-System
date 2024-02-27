package com.example.vehicleAuctionSystem.User;

import com.example.vehicleAuctionSystem.Seller.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    @Autowired
    SellerMapper sellerMapper;

    // Service method to create User
    public boolean createUser(User user){
        return sellerMapper.createUser(user);
    }

    // Service method to verify the login details entered by user
    public ResponseEntity<User> login(User user){
        User result = sellerMapper.login(user);
        if(result != null && result.getPassword() != null && result.getPassword().equalsIgnoreCase(user.getPassword()) && result.isUserActive()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if(result != null && result.getPassword() != null && result.getPassword().equalsIgnoreCase(user.getPassword())){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
