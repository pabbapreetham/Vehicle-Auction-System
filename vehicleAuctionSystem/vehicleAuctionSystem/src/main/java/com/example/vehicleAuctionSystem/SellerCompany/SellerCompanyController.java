package com.example.vehicleAuctionSystem.SellerCompany;

import com.example.vehicleAuctionSystem.DTO.ResponseDTO;
import com.example.vehicleAuctionSystem.DTO.SellerCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellercompany")
public class SellerCompanyController {

    @Autowired
    SellerCompanyService scService;

    // POST method to accept API request from web page to create Seller Company
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public ResponseEntity<ResponseDTO> createSellerCompany(@RequestBody SellerCompanyDTO sellerCompanyDTO)
    {
        try{
            boolean result = scService.
                    createCompany(sellerCompanyDTO);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        String res="Added Succesfully";
        return new ResponseEntity<>(new ResponseDTO(res), HttpStatus.OK);
    }

    // GET method to accept API request from web page to retrieve all Seller Companies
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public ResponseEntity<List<SellerCompany>> getSellerCompanies()
    {
        System.out.println("get all companies: controller");
        List<SellerCompany> res=scService.getCompanies();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // GET method to accept API request from web page to retrieve Seller companyDTOs
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/alldto")
    public ResponseEntity<List<SellerCompanyDTO>> getSellerCompanyDTOs()
    {
        System.out.println("get all companies: controller");
        List<SellerCompanyDTO> res=scService.getCompanieDTOs();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
