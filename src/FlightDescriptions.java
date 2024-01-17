
import java.sql.Date;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class FlightDescriptions {

    private String flightCode;
    private Date departureTime;
    private Date arrivalTime;
    AirPort arrival;
    AirPort departure;
    private int flightCapacity;
    private float ticketPrice;

    public FlightDescriptions() {
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public FlightDescriptions(String flightCode, Date departureTime, Date arrivalTime, AirPort departure, AirPort arrival, int flightCapacity, float ticketPrice) {
        this.flightCode = flightCode;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.arrival = arrival;
        this.departure = departure;
        this.flightCapacity = flightCapacity;
        this.ticketPrice = ticketPrice;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightName) {
        this.flightCode = flightName;
    }

    public AirPort getArrival() {
        return arrival;
    }

    public void setArrival(AirPort arrival) {
        this.arrival = arrival;
    }

    public AirPort getDeparture() {
        return departure;
    }

    public void setDeparture(AirPort departure) {
        this.departure = departure;
    }

    public int getFlightCapacity() {
        return flightCapacity;
    }

    public void setFlightCapacity(int flightCapacity) {
        this.flightCapacity = flightCapacity;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void details() {
        System.out.println(departure.getAirportID() + " " + flightCode + " " + departureTime + " " + arrivalTime + " "
                + arrival.getAirportLocation() + " " + departure.getAirportLocation() + " " + flightCapacity + " " + ticketPrice);
    }

    //This Code To Generate Random Flight Code
    private static String generateRandomFlightCode(String prefix, int length) {
        StringBuilder randomPart = new StringBuilder();
        Random random = new Random();

        // Generate a random alphanumeric part
        String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(alphanumericCharacters.length());
            randomPart.append(alphanumericCharacters.charAt(randomIndex));
        }

        // Combine the prefix and the random part
        return prefix + randomPart.toString();
    }

    public String getNewFlightCode() {
        return FlightDescriptions.generateRandomFlightCode("EG-", 5);
    }
}
