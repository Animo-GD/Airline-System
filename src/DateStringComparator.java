
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class DateStringComparator {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        public int compare(String date1, String date2) {
            try {
                Date dateObj1 = (Date) dateFormat.parse(date1);
                Date dateObj2 = (Date) dateFormat.parse(date2);
                return dateObj1.compareTo(dateObj2);
            } catch (ParseException e) {
                // Handle parsing exception if needed
                e.printStackTrace();
                return 0;
            }
        }
}
