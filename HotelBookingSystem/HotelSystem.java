import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private final String ROOMS_FILE = "rooms.txt";
    private final String BOOKINGS_FILE = "bookings.txt";
    private Scanner scanner = new Scanner(System.in);

    public HotelSystem() {
        loadData();
        if (rooms.isEmpty()) seedRooms();
    }

    public void searchRooms() {
        System.out.println("\n--- Search Rooms ---");
        System.out.println("1. All available rooms");
        System.out.println("2. By category (Standard / Deluxe / Suite)");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\nAvailable Rooms:");
        boolean found = false;
        for (Room r : rooms) {
            if (!r.isAvailable()) continue;
            if (choice == 1) {
                System.out.println(r);
                found = true;
            } else if (choice == 2) {
                System.out.print("Enter category: ");
                String cat = scanner.nextLine().trim();
                if (r.getCategory().equalsIgnoreCase(cat)) {
                    System.out.println(r);
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No rooms found.");
    }

    public void bookRoom() {
        System.out.print("\nEnter Room ID to book: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();
        Room room = findRoom(roomId);
        if (room == null || !room.isAvailable()) {
            System.out.println("Room not available.");
            return;
        }
        System.out.print("Guest Name: ");
        String name = scanner.nextLine();
        System.out.print("Check-in (YYYY-MM-DD): ");
        LocalDate checkIn = LocalDate.parse(scanner.nextLine());
        System.out.print("Check-out (YYYY-MM-DD): ");
        LocalDate checkOut = LocalDate.parse(scanner.nextLine());
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        if (nights <= 0) {
            System.out.println("Invalid dates.");
            return;
        }
        double total = nights * room.getPricePerNight();
        String bookingId = "BK" + System.currentTimeMillis();
        Reservation res = new Reservation(bookingId, roomId, name, checkIn, checkOut, total);
        reservations.add(res);
        room.setAvailable(false);
        System.out.println("\nBooking created successfully!");
        System.out.println(res);
        processPayment(res);
        saveData();
    }

    private void processPayment(Reservation res) {
        System.out.println("\n--- Payment Simulation ---");
        System.out.printf("Total amount due: $%.2f%n", res.getTotalAmount());
        System.out.print("Proceed with payment? (yes/no): ");
        String ans = scanner.nextLine().trim().toLowerCase();
        if (ans.equals("yes")) {
            res.setPaymentStatus("PAID");
            System.out.println("Payment successful! Status -> PAID");
        } else {
            System.out.println("Payment pending.");
        }
    }

    public void cancelBooking() {
        System.out.print("\nEnter Booking ID to cancel: ");
        String id = scanner.nextLine().trim();
        Reservation res = findReservation(id);
        if (res == null) {
            System.out.println("Booking not found.");
            return;
        }
        if (res.getPaymentStatus().equals("CANCELLED")) {
            System.out.println("Already cancelled.");
            return;
        }
        res.setPaymentStatus("CANCELLED");
        Room room = findRoom(res.getRoomId());
        if (room != null) room.setAvailable(true);
        System.out.println("Booking cancelled successfully.");
        saveData();
    }

    public void viewBooking() {
        System.out.print("\nEnter Booking ID: ");
        String id = scanner.nextLine().trim();
        Reservation res = findReservation(id);
        if (res == null) System.out.println("Booking not found.");
        else {
            System.out.println("\n--- Booking Details ---");
            System.out.println(res);
        }
    }

    private Room findRoom(int id) {
        for (Room r : rooms) if (r.getRoomId() == id) return r;
        return null;
    }

    private Reservation findReservation(String id) {
        for (Reservation r : reservations) if (r.getBookingId().equals(id)) return r;
        return null;
    }

    private void seedRooms() {
        rooms.add(new Room(101, "Standard", 80, true));
        rooms.add(new Room(102, "Standard", 85, true));
        rooms.add(new Room(201, "Deluxe", 150, true));
        rooms.add(new Room(202, "Deluxe", 160, true));
        rooms.add(new Room(301, "Suite", 300, true));
        rooms.add(new Room(302, "Suite", 350, true));
        saveData();
    }

    private void saveData() {
        try (PrintWriter pw = new PrintWriter(ROOMS_FILE)) {
            for (Room r : rooms) pw.println(r.toFileString());
        } catch (IOException e) {
            System.out.println("Error saving rooms.");
        }
        try (PrintWriter pw = new PrintWriter(BOOKINGS_FILE)) {
            for (Reservation r : reservations) pw.println(r.toFileString());
        } catch (IOException e) {
            System.out.println("Error saving bookings.");
        }
    }

    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(ROOMS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) rooms.add(Room.fromFileString(line));
        } catch (IOException e) { }
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKINGS_FILE))) {
            String line;
            while ((line = br.readLine()) reservations.add(Reservation.fromFileString(line));
        } catch (IOException e) { }
    }

    public void start() {
        while (true) {
            System.out.println("\n===== HOTEL BOOKING SYSTEM =====");
            System.out.println("1. Search Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> searchRooms();
                case 2 -> bookRoom();
                case 3 -> cancelBooking();
                case 4 -> viewBooking();
                case 5 -> { System.out.println("Thank you!"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        new HotelSystem().start();
    }
}