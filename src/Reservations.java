/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
/**
 *
 * @author Moaaz 
 */
public class Reservations {
    String pay = "not Confirmed";
    public static int reservationNumber = 1;
    private Date ReservationDate;
    ScheduledFlight SchFl;


    public Reservations(Date ReservationDate, ScheduledFlight SchFl) {
        this.ReservationDate = ReservationDate;
        this.SchFl = SchFl;
        reservationNumber++;
    }

    public final int ticketNum = reservationNumber;

    public Date getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(Date ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

    public ScheduledFlight getSchFl() {
        return SchFl;
    }

    public void setSchFl(ScheduledFlight SchFl) {
        this.SchFl = SchFl;
    }

    
}
