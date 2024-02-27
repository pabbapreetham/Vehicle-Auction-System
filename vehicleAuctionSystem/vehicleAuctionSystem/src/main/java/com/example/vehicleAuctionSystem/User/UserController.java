package com.example.vehicleAuctionSystem.User;

import com.example.vehicleAuctionSystem.DTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // POST method to accept API request from web page to add User details
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody User user)
    {
        try{
            boolean result = userService.createUser(user);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        String res="Added Succesfully";
        return new ResponseEntity<>(new ResponseDTO(res), HttpStatus.OK);
    }

    // POST method to accept API request from web page to verify user login details
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/login")
    public ResponseEntity<User> login(@RequestBody User user)
    {
        ResponseEntity<User> result = userService.login(user);
        return result;
    }
}
