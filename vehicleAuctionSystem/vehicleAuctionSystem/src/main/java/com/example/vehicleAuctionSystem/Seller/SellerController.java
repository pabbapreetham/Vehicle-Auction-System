package com.example.vehicleAuctionSystem.Seller;

import com.example.vehicleAuctionSystem.DTO.ResponseDTO;
import com.example.vehicleAuctionSystem.DTO.SellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    // POST method to accept API request from web page to create seller
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public ResponseEntity<ResponseDTO> createSeller(@RequestBody SellerDTO sellerDTO)
    {
        try{
            boolean result = sellerService.
                    createSeller(sellerDTO);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        String res="Added Succesfully";
        return new ResponseEntity<>(new ResponseDTO(res), HttpStatus.OK);
    }

    // GET method to accept API request from web page to retrieve all Sellers who don't have user
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/allnonusers")
    public ResponseEntity<List<Seller>> getSellersofNonUser(){
        List<Seller> result = sellerService.getSellersOfNonUsers();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET method to accept API request from web page to retrieve all Sellers
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public ResponseEntity<List<Seller>> getSellers(){
        List<Seller> result = sellerService.getSellers();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // PUT method to accept API request from web page to update Seller Status
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/updatestatus/{sellerId}/{status}")
    public ResponseEntity<ResponseDTO> updateSellerStatus(@PathVariable("sellerId") int sellerId,@PathVariable("status") int status){
        boolean updateStatus = (status == 0)? false : true;

        boolean result = sellerService.updateSellerStatus(sellerId, updateStatus);

        if(result){
            return new ResponseEntity<>(new ResponseDTO("Seller Status updated successfully"), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new ResponseDTO("Error occurred while updating status"), HttpStatus.BAD_REQUEST);
        }
    }
}
