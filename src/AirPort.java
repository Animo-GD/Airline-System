/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class AirPort {
    private String airportID;
    private String airportName;
    private String airportCity;
    private String airportLocation;

    public AirPort() {
    }
    public AirPort(String airportID,String airportLocation){
        this.airportID = airportID;
        this.airportLocation = airportLocation;
    }
    public AirPort(String airportID, String airportName, String airportCity, String airportLocation) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportLocation = airportLocation;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }


    public String getAirportID() {
        return airportID;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }


    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }


    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    public void details(){
        
    }
    
}
