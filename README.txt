Welcome To Airline Reservation and Management System.
-- To Run This Program You Will Need To Install This Tools First.
1-NetBeans
2-XAMPP
3-jCalendar Jar
4- MySql Connector Jar

===========================================================
--- After Downloading This Programs You Need To Setup the Database First
1- Open XAMPP Then Click Start `Apache` and `MySQL`
2- Click The Admin Button Next To The `MySQL` And It will Open The Database
3- Create Your Database By Going To SQL Bar In the Top Right
4- Execute The SQL queries That Attached With The Project with the name `airlinesystem.sql` right click on it then open with notepad.
5- After Creating The Database And All Tables Using the file `airlinesystem.sql` Go And Open NetBeans.
6- Now In NetBeans Go To File Choose Open Project Then Select The Airline Project from where you downloaded it.
7- After Opening The Project Go The Project Window (CTRL + 1) then go to the Library File
8- Right Mouse Click In The Library File -> Add File/JAR
9- Select `jcalendar-1.4.jar` And Click Open Then Repeat The JAR Selection And Select mysql-connector-j-8.2.0.jar
10- After Adding The Jar Try To Build/Clean The Project To Make Sure there is no errors.
11- Click Run.
============================================================
-- How To Use The Program
1- As A passenger You need to make a new account by clicking signup, make sure to fill all fields.
2- After Making a new account go and log in, as a passenger you will be able to.
	.. Adding and Removing Luggage 
	.. Book Tickets And Search Flights
	.. Check Schedule Flight 
	.. Check The Neastflights and missed flights.
	.. Canceling Your Ticket
3- As An Admin you can sign into by writing `admin` for user name, `admin` for password And It will take you to the Manager Dashboard
	.. Editing Flights Tickets (Add, Delete)
	.. Check All Passengers Reservation And You Can Cancel Any Reservation
	.. Check All Passengers Account And You will Be Able To (Delete, Update) Any Passenger.
	.. Also You Can Assign Any Account As An Admin By Checking The `isAdmin` Box.
=============================================================
Project By:
Eng/ Moaaz Anwar Mohamed Soliman
For Any Criteria : moaazanwarsoliman@gmail.com