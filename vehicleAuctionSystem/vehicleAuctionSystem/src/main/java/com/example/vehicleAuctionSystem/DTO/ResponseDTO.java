package com.example.vehicleAuctionSystem.DTO;

public class ResponseDTO {
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private String response;

    public ResponseDTO(){
        super();
    }
    public ResponseDTO(String response){
        super();
        this.response = response;
    }
}
