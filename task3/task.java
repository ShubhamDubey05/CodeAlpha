import java.util.ArrayList;
import java.util.Scanner;

// Class to represent an Itinerary
class Itinerary {
    int itineraryId;
    String destination;
    String startDate;
    String endDate;
    ArrayList<String> activities;

    Itinerary(int itineraryId, String destination, String startDate, String endDate) {
        this.itineraryId = itineraryId;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activities = new ArrayList<>();
    }

    // Add an activity to the itinerary
    void addActivity(String activity) {
        activities.add(activity);
    }

    // Display the itinerary details
    void displayItinerary() {
        System.out.println("\n=== Itinerary Details ===");
        System.out.println("Itinerary ID: " + itineraryId);
        System.out.println("Destination: " + destination);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Activities:");
        for (String activity : activities) {
            System.out.println("- " + activity);
        }
    }
}

// Main class for Travel Itinerary Planner
public class task {
    private static ArrayList<Itinerary> itineraries = new ArrayList<>();
    private static int itineraryCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Travel Itinerary Planner ===");
            System.out.println("1. Create a New Itinerary");
            System.out.println("2. Add Activity to an Itinerary");
            System.out.println("3. View All Itineraries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createItinerary(scanner);
                case 2 -> addActivity(scanner);
                case 3 -> viewAllItineraries();
                case 4 -> {
                    System.out.println("Exiting the system. Happy Travels!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Create a new itinerary
    private static void createItinerary(Scanner scanner) {
        System.out.println("\nEnter Destination: ");
        scanner.nextLine(); // Consume newline
        String destination = scanner.nextLine();

        System.out.println("Enter Start Date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.println("Enter End Date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        Itinerary itinerary = new Itinerary(itineraryCounter++, destination, startDate, endDate);
        itineraries.add(itinerary);
        System.out.println("Itinerary created successfully!");
    }

    // Add an activity to an itinerary
    private static void addActivity(Scanner scanner) {
        System.out.println("\nEnter Itinerary ID: ");
        int itineraryId = scanner.nextInt();

        for (Itinerary itinerary : itineraries) {
            if (itinerary.itineraryId == itineraryId) {
                System.out.println("Enter Activity: ");
                scanner.nextLine(); // Consume newline
                String activity = scanner.nextLine();
                itinerary.addActivity(activity);
                System.out.println("Activity added successfully!");
                return;
            }
        }
        System.out.println("Itinerary not found!");
    }

    // View all itineraries
    private static void viewAllItineraries() {
        if (itineraries.isEmpty()) {
            System.out.println("\nNo itineraries available.");
            return;
        }

        for (Itinerary itinerary : itineraries) {
            itinerary.displayItinerary();
        }
    }
}
