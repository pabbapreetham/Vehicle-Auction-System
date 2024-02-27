package com.example.vehicleAuctionSystem.SubTeam;

import com.example.vehicleAuctionSystem.DTO.ResponseDTO;
import com.example.vehicleAuctionSystem.DTO.SubTeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subteam")
public class SubTeamController {

    @Autowired
    SubTeamService stService;

    // POST method to accept API request from web page to create Sub Team
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/create")
    public ResponseEntity<ResponseDTO> createSubTeam(@RequestBody SubTeamDTO subTeamDTO)
    {
        try{
            boolean result = stService.
                    createSubTeam(subTeamDTO);
        }
        catch (Exception e){
            System.out.println("Exception occured " +e);
        }
        String res="Added Succesfully";
        return new ResponseEntity<>(new ResponseDTO(res), HttpStatus.OK);
    }

    // GET method to accept API request from web page to retrieve all sub teams
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all")
    public ResponseEntity<List<SubTeam>> getSubTeams()
    {
        List<SubTeam> result = stService.getSubTeams();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET method to accept API request from web page to retrieve sub-teams under a company
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/all/{companyId}")
    public ResponseEntity<List<SubTeam>> getSubTeamsForCompany(@PathVariable("companyId") int companyId)
    {
        List<SubTeam> result = stService.getSubTeamsForCompany(companyId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
