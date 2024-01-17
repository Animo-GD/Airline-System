
import java.util.Vector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/*
This Class To Set And Get Passenger Data.
*/
public class Passenger extends Person{
    private String password;
    private String passportID;
    private Vector<Luggage> luggage;

    public Passenger() {
    }

    public Passenger(String name,String password, String city, String country,String passportID) {
        super(name, city, country);
        this.password = password;
        this.passportID = passportID;
        
        
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPassword() {
        return password;
    }

    public String getPassportID() {
        return passportID;
    }

    public Vector<Luggage> getLuggage() {
        return luggage;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void setLuggage(Vector<Luggage> luggage) {
        this.luggage = luggage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    //To Check the data That user has inserted.
    public void details(){
        System.out.println("UserName: "+getName());
        System.out.println("Password: "+getPassword());
        System.out.println("City: "+getCity());
        System.out.println("Country: "+getCountry());
        System.out.println("PassportID: "+getPassportID());
        
    }
}
