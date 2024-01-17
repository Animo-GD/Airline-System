
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Moaaz
 */
public class SaveData {
    private static Connection con = null;
    private static Connection openConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinesystem", "root", "");
        }catch(Exception e){
            System.out.println("Failed To Establish Connection "+e);
        }
        return null;
    }
    public static int cancelTicket(String flightCode) throws SQLException {
        int rowAffected = 0;
        try {
            con = openConnection();
            PreparedStatement ps;
            String query = "DELETE FROM `reservation` WHERE flightCode=? LIMIT 1";
            ps = con.prepareStatement(query);
            ps.setString(1, flightCode);
            rowAffected = ps.executeUpdate();
            query = "DELETE FROM `scheduleflight` WHERE flightCode = ? LIMIT 1";
            ps = con.prepareStatement(query);
            ps.setString(1, flightCode);
            rowAffected += ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error In CancelTicket: " + e);
        }finally{
            con.close();
        }
        return rowAffected;
    }

    static int updateUser(String username, String password, String city, String country, boolean admin) throws SQLException {
        int rowAffected = 0;
        try {
            con =openConnection();

            String query = "UPDATE `passenger` SET `password`=?,`city`=?,`country`=?,`admin`=? WHERE username=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, city);
            ps.setString(3, country);
            ps.setBoolean(4, admin);
            ps.setString(5, username);

            rowAffected = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error in Update User : " + e);
        }finally{
            con.close();
        }
        return rowAffected;
    }

    static int deleteReservation(int reservNum, String owner, String flightCode) throws SQLException {
        int rowAffected = 0;
        try {
           con = openConnection();
            PreparedStatement ps;
            String query = "DELETE FROM `reservation` WHERE reservationNum=? and owner = ? and flightCode=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, reservNum);
            ps.setString(2, owner);
            ps.setString(3, flightCode);
            rowAffected = ps.executeUpdate();
            query = "DELETE FROM `scheduleflight` WHERE username=? and flightCode =? LIMIT 1";
            ps = con.prepareStatement(query);
            ps.setString(1, owner);
            ps.setString(2, flightCode);
            rowAffected += ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error In Delete Reservation: " + e);
        }finally{
            con.close();
        }
        return rowAffected;
    }

    public static int deleteLuggage(String item) throws SQLException {
        int rowAffected = 0;
        try {
            con = openConnection();
            PreparedStatement ps;
            String query = "DELETE FROM luggage WHERE item=? LIMIT 1";
            ps = con.prepareStatement(query);
            ps.setString(1, item);
            rowAffected = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in deleteing Luggage " + e);
        }finally{
            con.close();
        }
        return rowAffected;
    }

    static int addLuggage(String itemName, float weight) throws SQLException {
        int rowAffected = 0;

        try {

            con = openConnection();
            PreparedStatement ps;
            String query = "INSERT INTO luggage(username,item,weight) VALUES (?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1,Airline.logIn.getName());
            ps.setString(2, itemName);
            ps.setFloat(3,weight);
            
            rowAffected = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error Add Luggage " + e);
        }finally{
            con.close();
        }
        return rowAffected;
    }

    public SaveData() {

    }

    public static int newPassenger(String username, String password, String city, String country, String passportID) throws SQLException {
        /*
        First We need To check if the user has been inserted, already registered.
         */
        int rowAffected = 0;
        try {
           con = openConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM passenger";
            ResultSet res = st.executeQuery(query);
            int validUsername = 1;
            while (res.next()) {
                String un = res.getString("username");
                if (username.equals(un)) {
                    validUsername = 0;
                    break;
                }
            }
            /*
            If Not So We Will Insert the new user into the database
             */
            if (validUsername == 1) {
                //insertInto the data base
                query = "INSERT INTO `passenger`(`username`, `password`, `city`, `country`, `passportID`) VALUES (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, city);
                ps.setString(4, country);
                ps.setString(5, passportID);
                rowAffected = ps.executeUpdate();
            }

        } catch (Exception e) {
            System.out.print(e);
        }finally{
            con.close();
        }
        return rowAffected;
    }
    public static int addFlight(FlightDescriptions flight) throws SQLException{
        int rowAffected = 0;
        try{  
            con = openConnection();
            PreparedStatement ps;
            String query = "INSERT INTO `flightdescription`(`airportID`, `flightCode`, `deprature`, `depratureTime`, `arrival`, `arrivalTime`, `flightCapacity`, `ticketPrice`)"
                    + " VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1,flight.getDeparture().getAirportID());
            ps.setString(2,flight.getFlightCode());
            ps.setString(3,flight.getDeparture().getAirportLocation());
            ps.setDate(4,flight.getDepartureTime());
            ps.setString(5,flight.getArrival().getAirportLocation());
            ps.setDate(6, flight.getArrivalTime());
            ps.setInt(7, flight.getFlightCapacity());
            ps.setFloat(8,flight.getTicketPrice());
            
            rowAffected = ps.executeUpdate();
        
            
        }catch(Exception e){
            System.out.println("addFlight Error "+e);
        }finally{
            con.close();
        }
        return rowAffected;
    }
    public static int deleteFlight(String flightCode) throws SQLException {
        int rowAffected = 0;
        try {
           con = openConnection();
            String query = "DELETE FROM `flightdescription` WHERE flightCode=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, flightCode);
            rowAffected = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error in deletingFlight Function: " + e);
        }finally{
            con.close();
        }
        return rowAffected;

    }

    public static int insertSchFl(String flightCode, Date depratureTime) throws SQLException {
        int rowAffected = 0;
        try {
            con = openConnection();
            String query = "INSERT INTO `scheduleflight`(`username`, `flightCode`, `flightDate`) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Airline.logIn.getName());
            ps.setString(2, flightCode);
            ps.setDate(3, depratureTime);
            rowAffected = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error In insertSchF1: " + e);
        }finally{
            con.close();
        }
        return rowAffected;
    }

    public static int saveTicket(String flightCode) throws SQLException {
        int rowAffected = 0;
        try {
            con = openConnection();
            String query = "INSERT INTO `reservation`( `owner`,`flightCode`) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Airline.logIn.getName());
            ps.setString(2, flightCode);
            rowAffected = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error in SaveTicket: " + e);
        }finally{
            con.close();
        }
        return rowAffected;
    }
    
    public static int deleteUser(String username) throws SQLException{
        int rowAffected = 0;
        
        try{
            con = openConnection();
            PreparedStatement ps;
            String query;
            //Delete Luggage
            query = "DELETE FROM luggage WHERE username=?";
            ps = con.prepareStatement(query);
            ps.setString(1,username);
            
            rowAffected = ps.executeUpdate();
                        
            //Delete Reservation
            query = "DELETE FROM reservation WHERE owner=?";
            ps = con.prepareStatement(query);
            ps.setString(1,username);
            
            rowAffected = ps.executeUpdate();
            //Delete Schedule Flight
            query = "DELETE FROM scheduleflight WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1,username);
            rowAffected = ps.executeUpdate();
            //Delete User Account
            query = "DELETE FROM passenger WHERE username=?";
            ps = con.prepareStatement(query); //Request
            ps.setString(1, username); 
            
            rowAffected  = ps.executeUpdate();
            

        }catch(Exception e){
            System.out.println("Error in delete user: "+e);
        }finally{
            con.close();
        }
        
        return rowAffected;
    }
}
