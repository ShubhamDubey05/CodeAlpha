package task2;
import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Room
class Room {
    int roomNumber;
    String roomType;
    boolean isAvailable;

    Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;
    }
}

// Class representing a Booking
class Booking {
    int bookingId;
    int roomNumber;
    String guestName;

    Booking(int bookingId, int roomNumber, String guestName) {
        this.bookingId = bookingId;
        this.roomNumber = roomNumber;
        this.guestName = guestName;
    }
}

// Main Hotel Reservation System
public class HotelReservationSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static int bookingCounter = 1;

    public static void main(String[] args) {
        // Initialize some sample rooms
        initializeRooms();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View All Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewAvailableRooms();
                case 2 -> bookRoom(scanner);
                case 3 -> viewAllBookings();
                case 4 -> {
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Initialize rooms
    private static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Single"));
        rooms.add(new Room(105, "Double"));
    }

    // View all available rooms
    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        boolean found = false;
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println("Room " + room.roomNumber + " - " + room.roomType);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available.");
        }
    }

    // Book a room
    private static void bookRoom(Scanner scanner) {
        System.out.println("\nEnter your name: ");
        scanner.nextLine(); // Consume newline
        String guestName = scanner.nextLine();

        System.out.println("Enter room number to book: ");
        int roomNumber = scanner.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                room.isAvailable = false;
                bookings.add(new Booking(bookingCounter++, roomNumber, guestName));
                System.out.println("Room " + roomNumber + " booked successfully for " + guestName + ".");
                return;
            }
        }
        System.out.println("Room not available or invalid room number.");
    }

    // View all bookings
    private static void viewAllBookings() {
        System.out.println("\nAll Bookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.bookingId +
                               ", Room Number: " + booking.roomNumber +
                               ", Guest Name: " + booking.guestName);
        }
    }
}
