
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Moaaz
 */
public class LoadData {
    public boolean isAdmin = false;
    public LoadData(){
        
    }
     private static Connection con = null;
    private static Connection openConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinesystem", "root", "");
        }catch(Exception e){
            System.out.println("Failed To Establish Connection "+e);
        }
        return null;
    }
    /*Log in Function*/
    public boolean LogIn(String username,String Password) throws SQLException{
        /*Check if the username and password in the database*/
        String psw ="";
        try{
            con = openConnection();
            String query = "SELECT * FROM passenger WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet res = ps.executeQuery();
            
            // If The user founded in the database
            if(res.next()){
                Airline.setLogIn(new Passenger(
                        res.getString("username"),
                        res.getString("password"),
                        res.getString("city"),
                        res.getString("country"),
                        res.getString("passportID")));
                
                    psw = Airline.logIn.getPassword();
                    isAdmin = res.getBoolean("admin");
                    
            }
        }catch(Exception e){
            System.out.print("Error When Log In: "+ e);
            return false;
        }finally{
            con.close();
        }
        if(Airline.logIn != null)
        {
            Airline.logIn.details();
        }
        
        return Password.equals(psw);

    }
    
    //This Function To Get Flight Description

    /**
     *
     * @return
     */
    public Vector<FlightDescriptions> getFlightDescription() throws SQLException{
        Vector<FlightDescriptions> flights = new Vector<>();
        try{
            con = openConnection();
            String query = "SELECT * FROM flightdescription";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                String airportID = res.getString("airportID");
                String flightCode = res.getString("flightCode");
                String deprature = res.getString("deprature");
                Date depratureTime = res.getDate("depratureTime");
                String arrival = res.getString("arrival");
                Date arrivalTime = res.getDate("arrivalTime");
                int flightCapacity = res.getInt("flightCapacity");
                float ticketPrice = res.getFloat("ticketPrice");
                
                //Load The Data Into The Airline System.
                FlightDescriptions fd = new FlightDescriptions(
                        flightCode,
                        depratureTime,
                        arrivalTime,
                        new AirPort(airportID,arrival),
                        new AirPort(airportID,deprature),
                        flightCapacity,
                        ticketPrice
                );
                flights.add(fd);
            }
        }catch(Exception e){
            System.out.print("Failed To Load Passenger Data: "+e);
        }finally{
            con.close();
        }
        return flights;
    }
    
    public Vector<FlightDescriptions> searchFlight(String FlightTo) throws SQLException{
        Vector<FlightDescriptions> flights = new Vector<>();
        try{
            con = openConnection();
            String query = "SELECT * FROM flightdescription WHERE arrival = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,FlightTo);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                String airportID = res.getString("airportID");
                String flightCode = res.getString("flightCode");
                String deprature = res.getString("deprature");
                Date depratureTime = res.getDate("depratureTime");
                String arrival = res.getString("arrival");
                Date arrivalTime = res.getDate("arrivalTime");
                int flightCapacity = res.getInt("flightCapacity");
                float ticketPrice = res.getFloat("ticketPrice");
                
                //Load The Data Into The Airline System.
                FlightDescriptions fd = new FlightDescriptions(
                        flightCode,
                        depratureTime,
                        arrivalTime,
                        new AirPort(airportID,arrival),
                        new AirPort(airportID,deprature),
                        flightCapacity,
                        ticketPrice
                );
                flights.add(fd);
            }
        }catch(Exception e){
            System.out.print("Failed To Load Passenger Data: "+e);
        }finally{
            con.close();
        }
        return flights;
    }
    
    /*This Function To load the Passenger Data From The Data Base into a Table*/
    public Vector<Vector<Object>> getPassengerData() throws SQLException{ 
        Vector<Vector<Object>> tableData = new Vector<>();
        try{
            con = openConnection();
            String query = "SELECT * FROM passenger";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Vector<Object> rowData = new Vector<>();
                rowData.add(res.getString("username"));
                rowData.add(res.getString("passportID"));
                rowData.add(res.getString("password"));
                rowData.add(res.getString("city"));
                rowData.add(res.getString("country"));
                rowData.add(res.getBoolean("admin"));
                tableData.add(rowData);
            }
        }catch(Exception e){
            System.out.print("Failed To Load Passenger Data: "+e);
        }finally{
            con.close();
        }
        return tableData;
    }
    
    //This Function To Search for a user in the database and retrive it's information.
    public Vector<Object> findUser(String PassportID) throws SQLException{
        Vector<Object> user = new Vector<>();
        try{
            con = openConnection();
            String query = "SELECT * FROM passenger WHERE passportID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, PassportID);
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                user.add(res.getString("username"));
                user.add(res.getString("passportID"));
                user.add(res.getString("password"));
                user.add(res.getString("city"));
                user.add(res.getString("country"));
                user.add(res.getBoolean("admin"));
            }
        }catch(Exception e){
            System.out.print(e);
        }finally{
            con.close();
        }
        return user;
    }
    
    public static String findAirportID(String airportName ) throws SQLException
    {
        String airportID = "EG-";
        try{
            con = openConnection();
            String query = "SELECT airportID FROM airport WHERE airportName = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,airportName);
            ResultSet res = ps.executeQuery();
            
            if(res.next()){
                airportID = res.getString("airportID");
            }
            System.out.println("AirportName: "+airportName+" AirportID: "+airportID);
        }catch(Exception e){
            System.out.print("Failed To Load Passenger Data: "+e);
        }finally{
            con.close();
        }
        return airportID;
    }
    
    
    public Vector<Vector<Object>> getLuggage() throws SQLException{
        Vector<Vector<Object>> tableData = new Vector<>();
        try{
            con = openConnection();
            String query = "SELECT item,weight FROM luggage WHERE username=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Airline.logIn.getName());
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Vector<Object> rowData = new Vector<>();
                rowData.add(res.getString("item"));
                rowData.add(res.getString("weight"));
                tableData.add(rowData);
            }
        }catch(Exception e){
            System.out.print("Failed To Load Luggage Data: "+e);
        }finally{
            con.close();
        }
        return tableData;

        
    }
    
    public Vector<Vector<Object>> getValidTicket() throws SQLException{
        Vector<Vector<Object>> tableData = new Vector<>();
        try{
            con = openConnection();
            String query = "SELECT* FROM(SELECT username,flightDate,flightdescription.* from scheduleflight"
                    + "  JOIN flightdescription ON scheduleflight.flightCode =flightdescription.flightCode) AS t "
                    + " JOIN reservation AS r ON t.flightCode = r.flightCode  WHERE username=? and depratureTime > CURRENT_TIMESTAMP"
                    +" ORDER BY depratureTime ASC";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Airline.logIn.getName());
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Vector<Object> rowData = new Vector<>();
                rowData.add(res.getString("deprature"));
                rowData.add(res.getString("arrival"));
                rowData.add(res.getDate("depratureTime"));
                rowData.add(res.getDate("arrivalTime"));
                rowData.add(res.getDate("reservationDate"));
                rowData.add(res.getFloat("ticketPrice"));
                
                tableData.add(rowData);
            }
            Set<Vector<Object>> uniqueSet = new LinkedHashSet<>(tableData);
            tableData = new Vector<>(uniqueSet);
        }catch(Exception e){
            System.out.print("Failed To Load Ticket Data: "+e);
        }finally{
            con.close();
        }
        return tableData;

        
    }
    /*This Function To Get The Data which will be displied in the Cancel Ticket Frame*/
    public static Vector<Vector<Object>> getBriefTicket() throws SQLException{
         Vector<Vector<Object>> tableData = new Vector<>();
        try{
           con = openConnection();
            String query = "SELECT * FROM(SELECT username,flightDate,flightdescription.* from scheduleflight"
                    + "  JOIN flightdescription ON scheduleflight.flightCode =flightdescription.flightCode) AS t "
                    + " JOIN reservation AS r ON t.flightCode = r.flightCode  WHERE username=? and depratureTime > CURRENT_TIMESTAMP"
                    +" ORDER BY depratureTime ASC";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Airline.logIn.getName());
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Vector<Object> rowData = new Vector<>();
                rowData.add(res.getString("flightCode"));
                rowData.add(res.getString("deprature"));
                rowData.add(res.getString("arrival"));
                rowData.add(res.getFloat("ticketPrice"));
                
                tableData.add(rowData);
            }
            tableData = new Vector<>(Set.copyOf(tableData));
        }catch(Exception e){
            System.out.print("Failed To Load Ticket Data: "+e);
        }finally{
            con.close();
        }
        return tableData;
    }
    public Vector<Vector<Object>> getInValidTicket() throws SQLException{
        Vector<Vector<Object>> tableData = new Vector<>();
        try{
            con = openConnection();
            String query = "SELECT* FROM(SELECT username,flightDate,flightdescription.* from scheduleflight"
                    + "  JOIN flightdescription ON scheduleflight.flightCode =flightdescription.flightCode) AS t "
                    + "JOIN reservation AS r ON t.flightCode = r.flightCode  WHERE username=? and depratureTime < CURRENT_TIMESTAMP";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Airline.logIn.getName());
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Vector<Object> rowData = new Vector<>();
                rowData.add(res.getString("deprature"));
                rowData.add(res.getString("arrival"));
                rowData.add(res.getDate("depratureTime"));
                rowData.add(res.getDate("arrivalTime"));
                rowData.add(res.getFloat("ticketPrice"));
                
                tableData.add(rowData);
            }
            tableData = new Vector<>(Set.copyOf(tableData));
        }catch(Exception e){
            System.out.print("Failed To Load Ticket Data: "+e);
        }finally{
            con.close();
        }
        return tableData;

        
    }
    public static Vector<Vector<Object>> getReservation() throws SQLException{
        Vector<Vector<Object>> tableData = new Vector<>();
        try{
            con = openConnection();
            String query = "SELECT * FROM reservation";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Vector<Object> rowData = new Vector<>();
                rowData.add(res.getString("reservationNum"));
                rowData.add(res.getString("owner"));
                rowData.add(res.getInt("payConfirm"));
                rowData.add(res.getDate("reservationDate"));
                rowData.add(res.getString("flightCode"));
                tableData.add(rowData);
            }
        }catch(Exception e){
            System.out.print("Failed To Load Ticket Data: "+e);
        }finally{
            con.close();
        }
        return tableData;
    }
    public static int getReservationCount(String username) throws SQLException{
        int count = 0;
        try{
            con = openConnection();
            String query = "SELECT COUNT(*) as row_count FROM reservation WHERE owner=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet res = ps.executeQuery();
            if(res.next()){
                count = res.getInt("row_count");
            }
        }catch(Exception e){
            System.out.println("Failed To Get Reservation Count: "+e);
        }finally{
            con.close();
        }
        return count;
    }
}
