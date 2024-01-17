
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Airline implements system {
    static Passenger logIn;
    Vector<AirPort> airport;
    Vector<ScheduledFlight> SchFl;
    Vector<Reservations> reservation;
    Vector<FlightDescriptions> flights;
    public Airline(){
        
    }
    public Airline(Vector<AirPort> airport, Vector<ScheduledFlight> SchFl, Vector<Reservations> reservation, Vector<FlightDescriptions> flight) {
        this.airport = airport;
        this.SchFl = SchFl;
        this.reservation = reservation;
        this.flights = flight;
    }

    @Override
    public Vector<AirPort> getAirport() {
        return airport;
    }

    @Override
    public Vector<ScheduledFlight> getSchFl() {
        return SchFl;
    }
    //Every Row in this matrix has Reservation Data
    public static Vector<Vector<Object>> getReservation() throws SQLException {
        return LoadData.getReservation();
    }

    @Override
    public Vector<FlightDescriptions> getFlight() {
        return flights;
    }

    public static void setLogIn(Passenger logIn) {
        Airline.logIn = logIn;
    }

    @Override
    public void setAirport(Vector<AirPort> airport) {
        this.airport = airport;
    }

    @Override
    public void setSchFl(Vector<ScheduledFlight> SchFl) {
        this.SchFl = SchFl;
    }

    @Override
    public void setReservation(Vector<Reservations> reservation) {
        this.reservation = reservation;
    }

    @Override
    public void setFlight() {
        LoadData ld = new LoadData();
        try {
            this.flights = ld.getFlightDescription();
        } catch (SQLException ex) {
            Logger.getLogger(Airline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    @Override
    public void viewFlight(){
        for(FlightDescriptions flight:flights ){
            flight.details();
        }
        
    }
    public static int bookTicket(String flightCode) throws SQLException{
        return SaveData.saveTicket(flightCode);
        
    }
    public static int cancelTicket(String flightCode) throws SQLException{
        
        return SaveData.cancelTicket(flightCode);
    }
    //This Function Is Used To Clear jTable Data.
    //clearData is a built in bunction in DefaultTableModel Class
    @Override
    public void clearData(DefaultTableModel model){
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
    }
    /*A helper Function To get the Nearest Flight*/
    public static long calculateDaysDifference(LocalDate date) {
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(date, today);
    }
    public static void main(String args[]){
        new MainFrame().setVisible(true);
        
    }
    
}
