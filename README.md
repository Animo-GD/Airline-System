# Airline Reservation And Management System
## UML Design
![UML Design](https://github.com/Animo-GD/Airline-System/blob/main/Data/UML%20Design.png)
-----------------------------------------------------------------------------------------
## User Story

- As a passenger, I want to be able to easily search for and book my e-tickets online without having to visit a physical ticketing office or wait in long lines at the airport.

- The system should validate the input and show an error message if any of the fields are invalid or empty.

- When searching for flights, I want to be able to specify my preferred travel dates, departure and arrival cities, and departure and arrival dates and times.

   I also want to be able to filter my search results based on the airline, departure, and arrival times, and ticket prices.
 
- Once I have selected my preferred flight, I also want to be able to select any additional services such as extra baggage allowance.

- The payment process should be simple and secure such as credit/debit card payment method.

   After the payment is completed, I want to receive an e-ticket confirmation via SMS.

- The system should show the flight details such as airline, flight number, departure and arrival time, and baggage allowance for each flight option.

- In case of any changes to my travel plans, I should be able to easily cancel my reservation online.

- If I need to cancel my reservation, I want to be able to do so easily online and receive a refund according to the airline's cancellation policy.

- Overall, I want the online e-ticket reservation system to be user-friendly and efficient, allowing me to quickly and easily book my flights,

   make changes if necessary, and receive timely updates about my itinerary.

-----------------------------------------------------------------------------------------
## How To Install
- **To Run This Program You Will Need To Install This Tools First**
1. [NetBeans](https://netbeans.apache.org/front/main/download/index.html)
2. [XAMPP](https://www.apachefriends.org/)
3. [jCalendar Jar](http://www.java2s.com/Code/Jar/j/Downloadjcalendar114jar.htm)
4. [MySql Connector Jar](https://www.mysql.com/products/connector/)

- **After Downloading This Program You Need To Setup the Database First**
1. Open XAMPP Then Click Start `Apache` and `MySQL`
2. Click The Admin Button Next To The `MySQL` And It will Open The Database
3. Create Your Database By Going To SQL Bar In the Top Right
4. Execute The SQL queries That are Attached to the Project with the name `airlinesystem.sql` right click on it then open it with Notepad.
5. After Creating The Database And All Tables Using the file `airlinesystem.sql` Go And Open NetBeans.
6. Now In NetBeans Go To File Choose Open Project Then Select The Airline Project from where you downloaded it.
7. After Opening The Project Go to The Project Window (CTRL + 1) then go to the Library File
8. Right Mouse Click In The Library File -> Add File/JAR
9. Select `jcalendar-1.4.jar` And Click Open Then Repeat The JAR Selection And Select mysql-connector-j-8.2.0.jar
10. After Adding The Jar Try To Build/Clean The Project To Make Sure there are no errors.
11. Click Run.


- **How To Use The Program**
1. As A passenger You need to make a new account by clicking signup, make sure to fill in all fields.
2. After Making a new account go and log in, as a passenger you will be able to.
        - Adding and Removing Luggage
   	- Book Tickets And Search Flights
   	- Check Schedule Flight
   	- Check the nearest flights and missed flights.
   	- Canceling Your Ticket
4. As An Admin, you can sign in by writing `admin` for your name, and `admin` for your password It will take you to the Manager Dashboard
   	- Editing Flights Tickets (Add, Delete)
   	- Check All Passenger Reservations And You Can Cancel Any Reservation
   	- Check All Passengers' Accounts And You Will Be Able To (Delete and Update) Any Passenger.
   	- Also You Can Assign Any Account As An Admin By Checking The `isAdmin` Box.
=============================================================
Project By:
Eng/ Moaaz Anwar Mohamed Soliman
For Any Criteria: moaazanwarsoliman@gmail.com
