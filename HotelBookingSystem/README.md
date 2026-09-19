# Hotel Booking System

A console-based Hotel Room Booking & Management System written in Java.

## Features
- Search available rooms by availability or category
- Create and cancel reservations
- Calculate booking totals from check-in/check-out dates
- Simulate payment status updates
- View booking details
- Persist room and reservation data using text files

## Java concepts demonstrated
- Object-oriented programming with multiple classes
- Encapsulation with fields, getters and setters
- Collections using List and ArrayList
- File I/O with BufferedReader, FileReader and PrintWriter
- Exception handling with try-with-resources
- Date handling with LocalDate and ChronoUnit
- Console input using Scanner
- Control flow with loops and switch expressions

## How to run

    javac *.java
    java HotelSystem

## Project structure
- HotelSystem.java — application flow, menu, booking logic and persistence
- Room.java — room model
- Reservation.java — reservation model and serialization helpers
- rooms.txt — generated room data
- bookings.txt — generated reservation data
