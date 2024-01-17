/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ScheduledFlight {
     private String flightDate;
    FlightDescriptions flightDescrip = new FlightDescriptions();
    

    ScheduledFlight() {
    }

    public ScheduledFlight(String flightDate, FlightDescriptions flightDescrip) {
        this.flightDate = flightDate;
        this.flightDescrip = flightDescrip;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public FlightDescriptions getFlightDescrip() {
        return flightDescrip;
    }

    public void setFlightDescrip(FlightDescriptions flightDescrip) {
        this.flightDescrip = flightDescrip;
    }

    public void details() {
        System.out.println("[ The Flight Date ] ----> " + flightDate);
        this.flightDescrip.details();

    }
}
