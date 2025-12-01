import java.io.File;

/**
 * AssignmentTwo class - Main class containing all demonstration methods
 */
public class AssignmentTwo {

    /**
     * Main method - Program entry point
     */
    public static void main(String[] args) {
        System.out.println("=== Park Rides Visitor Management System (PRVMS) ===");

        // Run Part 6 demonstration
        demonstratePartSix();
    }

    /**
     * Demonstrate Part 6 file writing functionality
     */
    private static void demonstratePartSix() {
        System.out.println("\n=== Part 6: Writing to File ===");

        // 1. Create new Ride object
        Ride ride = new Ride("Space Mountain", "RollerCoaster", 135, 4);
        System.out.println("Created new ride: " + ride.getRideName());

        // 2. Create and add at least 5 visitors to ride history
        System.out.println("\n2. Adding visitors to ride history:");
        Visitor v1 = new Visitor("Alex Johnson", 25, "alex@email.com", "V6001", "DayPass");
        Visitor v2 = new Visitor("Maria Garcia", 30, "maria@email.com", "V6002", "SeasonPass");
        Visitor v3 = new Visitor("David Smith", 22, "david@email.com", "V6003", "Single");
        Visitor v4 = new Visitor("Sarah Wilson", 28, "sarah@email.com", "V6004", "DayPass");
        Visitor v5 = new Visitor("James Brown", 35, "james@email.com", "V6005", "SeasonPass");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        // 3. Display current ride history
        System.out.println("\n3. Current ride history:");
        ride.printRideHistory();

        // 4. Export visitors to file
        System.out.println("\n4. Exporting ride history to file:");
        String filename = "ride_history.csv";
        ride.exportRideHistory(filename);

        // 5. Verify file creation
        System.out.println("\n5. Verifying file creation:");
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Success: File " + filename + " created successfully");
            System.out.println("  File size: " + file.length() + " bytes");
            System.out.println("  File path: " + file.getAbsolutePath());
        } else {
            System.out.println("Error: File " + filename + " was not created");
        }

        System.out.println("\n=== Part 6 Demonstration Completed ===");
    }

    /**
     * Part 6 method - Specific demonstration as required
     */
    public void partSix() {
        System.out.println("\n=== Executing Part Six Method ===");

        // 1. Create new Ride
        Ride ride = new Ride("Adventure Ride", "MotionRide", 110, 5);
        System.out.println("Created new ride: " + ride.getRideName());

        // 2. Add at least 5 Visitors to ride history
        System.out.println("\n2. Adding visitors to ride history:");
        Visitor[] visitors = new Visitor[5];
        visitors[0] = new Visitor("John Doe", 20, "john@email.com", "V7001", "DayPass");
        visitors[1] = new Visitor("Jane Smith", 25, "jane@email.com", "V7002", "SeasonPass");
        visitors[2] = new Visitor("Mike Jones", 18, "mike@email.com", "V7003", "Single");
        visitors[3] = new Visitor("Lisa Wang", 22, "lisa@email.com", "V7004", "DayPass");
        visitors[4] = new Visitor("Tom Chen", 30, "tom@email.com", "V7005", "SeasonPass");

        for (Visitor visitor : visitors) {
            ride.addVisitorToHistory(visitor);
        }

        // 3. Export visitors to file
        System.out.println("\n3. Exporting ride history to file:");
        String filename = "part6_ride_history.csv";
        ride.exportRideHistory(filename);

        System.out.println("\n=== Part Six Method Completed ===");
    }

    /**
     * Part 3: Queue management demonstration method
     */
    public void partThree() {
        System.out.println("Part 3: Queue management for waiting visitors");
        // Already implemented
    }

    /**
     * Part 4A: Ride history demonstration method
     */
    public void partFourA() {
        System.out.println("Part 4A: Ride history with LinkedList");
        // Already implemented
    }

    /**
     * Part 4B: Ride history sorting demonstration method
     */
    public void partFourB() {
        System.out.println("Part 4B: Sorting ride history");
        // Already implemented
    }

    /**
     * Part 5: Running ride cycles demonstration method
     */
    public void partFive() {
        System.out.println("Part 5: Running ride cycles");
        // Already implemented
    }

    /**
     * Part 7: Reading from file demonstration method
     * To be implemented in Part 7
     */
    public void partSeven() {
        System.out.println("Part 7: Reading ride history from file");
        // To be implemented
    }
}