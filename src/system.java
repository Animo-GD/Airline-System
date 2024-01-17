
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ /**
 *
 * @author Moaaz
 */
public interface system {

    //This Function Is Used To Clear jTable Data.
    void clearData(DefaultTableModel model);

    Vector<AirPort> getAirport();

    Vector<FlightDescriptions> getFlight();

    Vector<ScheduledFlight> getSchFl();

    void setAirport(Vector<AirPort> airport);

    void setFlight();

    void setReservation(Vector<Reservations> reservation);

    void setSchFl(Vector<ScheduledFlight> SchFl);

    void viewFlight();
    
}
