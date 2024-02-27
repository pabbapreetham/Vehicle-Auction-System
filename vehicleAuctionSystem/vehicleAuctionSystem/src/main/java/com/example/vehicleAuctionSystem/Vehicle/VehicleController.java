package com.example.vehicleAuctionSystem.Vehicle;

import com.example.vehicleAuctionSystem.DTO.ResponseDTO;
import com.example.vehicleAuctionSystem.DTO.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    // POST method to accept API request from web page to add Vehicle Details
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public ResponseEntity<ResponseDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO)
    {
        try{
            boolean result = vehicleService.createVehicle(vehicleDTO);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        String res="Added Succesfully";
        return new ResponseEntity<>(new ResponseDTO(res), HttpStatus.OK);
    }

    // GET method to accept API request from web page to retrieve Vehicle details by userId
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/all/{userId}")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByUserId(@PathVariable("userId") int userId){
        List<VehicleDTO> result = vehicleService.getVehiclesByUserId(userId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
