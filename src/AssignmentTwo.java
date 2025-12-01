/**
 * AssignmentTwo class - Main class containing main method and demonstration methods for all parts
 */
public class AssignmentTwo {

    /**
     * Main method - Program entry point
     */
    public static void main(String[] args) {
        System.out.println("=== Park Rides Visitor Management System (PRVMS) ===");

        // Run Part 6 demonstration
        demonstratePartSix();

        System.out.println("\n" + "=".repeat(50));

        // Run specific partSix method
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partSix();
    }

    /**
     * Demonstrate Part 6 file writing functionality
     */
    private static void demonstratePartSix() {
        System.out.println("\n=== Part 6: Writing to File ===");

        // 1. Create a new ride
        System.out.println("\n1. Creating ride object:");
        Ride ride = new Ride("Thunder Bolt", "RollerCoaster", 140, 4);
        System.out.println("Created: " + ride);

        // 2. Create at least 5 visitors
        System.out.println("\n2. Creating visitors for testing:");
        Visitor visitor1 = new Visitor("Alice Johnson", 25, "alice@email.com", "V6001", "DayPass");
        Visitor visitor2 = new Visitor("Bob Smith", 30, "bob@email.com", "V6002", "SeasonPass");
        Visitor visitor3 = new Visitor("Carol Williams", 22, "carol@email.com", "V6003", "Single");
        Visitor visitor4 = new Visitor("David Brown", 18, "david@email.com", "V6004", "DayPass");
        Visitor visitor5 = new Visitor("Emma Davis", 28, "emma@email.com", "V6005", "SeasonPass");
        Visitor visitor6 = new Visitor("Frank Miller", 35, "frank@email.com", "V6006", "Single"); // Extra visitor

        System.out.println("Created " + 6 + " visitors for testing");

        // 3. Add visitors to ride history (LinkedList)
        System.out.println("\n3. Adding visitors to ride history:");
        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);
        ride.addVisitorToHistory(visitor6); // Extra visitor

        // 4. Print ride history before export
        System.out.println("\n4. Ride history before export:");
        ride.printRideHistory();

        // 5. Export ride history to file
        System.out.println("\n5. Exporting ride history to file:");
        String filename = "thunder_bolt_history.csv";
        boolean success = ride.exportRideHistory(filename);

        if (success) {
            System.out.println("\nExport successful! Check the file: " + filename);
            System.out.println("Expected file format (CSV):");
            System.out.println("Ride Name,Visitor Name,Visitor ID,Age,Email,Ticket Type,Ride Type,Min Height");
            System.out.println("Thunder Bolt,Alice Johnson,V6001,25,alice@email.com,DayPass,RollerCoaster,140");
            System.out.println("... and so on for each visitor");
        } else {
            System.out.println("\nExport failed!");
        }

        // 6. Test with default filename
        System.out.println("\n6. Testing export with default filename:");
        Ride waterRide = new Ride("Splash Mountain", "WaterRide", 120, 6);

        // Add some visitors
        waterRide.addVisitorToHistory(new Visitor("Grace Taylor", 19, "grace@email.com", "V6007", "DayPass"));
        waterRide.addVisitorToHistory(new Visitor("Henry Wilson", 32, "henry@email.com", "V6008", "SeasonPass"));
        waterRide.addVisitorToHistory(new Visitor("Ivy Moore", 24, "ivy@email.com", "V6009", "Single"));

        boolean defaultExportSuccess = waterRide.exportRideHistory();
        if (defaultExportSuccess) {
            System.out.println("Default filename export successful!");
            System.out.println("File created: Splash_Mountain_history.csv");
        }

        // 7. Test custom export options
        System.out.println("\n7. Testing custom export options:");
        Ride ferrisWheel = new Ride("Sky Wheel", "FamilyRide", 100, 8);

        // Add visitors
        ferrisWheel.addVisitorToHistory(new Visitor("Jack Lee", 15, "jack@email.com", "V6010", "DayPass"));
        ferrisWheel.addVisitorToHistory(new Visitor("Karen Chen", 29, "karen@email.com", "V6011", "SeasonPass"));

        // Export without ride information
        System.out.println("\n7.1 Exporting without ride information:");
        boolean customExport1 = ferrisWheel.exportRideHistory("sky_wheel_visitors_only.csv", false);

        // Export with ride information
        System.out.println("\n7.2 Exporting with ride information:");
        boolean customExport2 = ferrisWheel.exportRideHistory("sky_wheel_full.csv", true);

        // 8. Test error cases
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTING ERROR CASES");
        System.out.println("=".repeat(50));

        // 8.1 Test export with empty history
        System.out.println("\n8.1 Testing export with empty ride history:");
        Ride emptyRide = new Ride("Empty Ride", "Test", 100, 2);
        emptyRide.exportRideHistory("empty_history.csv");

        // 8.2 Test export to invalid directory
        System.out.println("\n8.2 Testing export to invalid directory:");
        Ride testRide = new Ride("Test Ride", "Test", 100, 2);
        testRide.addVisitorToHistory(new Visitor("Test Visitor", 20, "test@email.com", "V9999", "Single"));

        // Try to write to a non-existent directory
        boolean invalidDirExport = testRide.exportRideHistory("/nonexistent/directory/test.csv");
        if (!invalidDirExport) {
            System.out.println("Expected error occurred - directory does not exist");
        }

        System.out.println("\n=== Part 6 Demonstration Completed ===");
    }

    /**
     * Part 6 method - Specific demonstration as required
     */
    public void partSix() {
        System.out.println("\n=== Executing Part Six Method ===");

        // 1. Create a new Ride
        Ride ride = new Ride("Dragon Coaster", "RollerCoaster", 130, 3);
        System.out.println("Created new ride: " + ride.getRideName());

        // 2. Create at least 5 Visitor objects
        System.out.println("\n2. Creating 5+ visitors:");
        Visitor v1 = new Visitor("John Rider", 20, "john@email.com", "V7001", "DayPass");
        Visitor v2 = new Visitor("Maria Explorer", 25, "maria@email.com", "V7002", "SeasonPass");
        Visitor v3 = new Visitor("Tom Adventurer", 18, "tom@email.com", "V7003", "Single");
        Visitor v4 = new Visitor("Lisa Traveler", 22, "lisa@email.com", "V7004", "DayPass");
        Visitor v5 = new Visitor("Mike Voyager", 30, "mike@email.com", "V7005", "SeasonPass");
        Visitor v6 = new Visitor("Sarah Journey", 16, "sarah@email.com", "V7006", "Single"); // Extra visitor

        System.out.println("Created " + 6 + " visitors");

        // 3. Add visitors to ride history (LinkedList)
        System.out.println("\n3. Adding visitors to ride history:");
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);
        ride.addVisitorToHistory(v6); // Extra visitor

        // 4. Export visitors to a file
        System.out.println("\n4. Exporting ride history to file:");
        String filename = "dragon_coaster_history.csv";

        System.out.println("Attempting to export to file: " + filename);
        boolean exportSuccess = ride.exportRideHistory(filename);

        if (exportSuccess) {
            System.out.println("Export successful!");
            System.out.println("File created: " + filename);
            System.out.println("Total visitors exported: " + ride.numberOfVisitors());

            // Show expected file content
            System.out.println("\nExpected file content (first few lines):");
            System.out.println("Ride Name,Visitor Name,Visitor ID,Age,Email,Ticket Type,Ride Type,Min Height");
            System.out.println("Dragon Coaster,John Rider,V7001,20,john@email.com,DayPass,RollerCoaster,130");
            System.out.println("Dragon Coaster,Maria Explorer,V7002,25,maria@email.com,SeasonPass,RollerCoaster,130");
            System.out.println("... (and more)");
        } else {
            System.out.println("Export failed!");
        }

        // 5. Verify the data that was exported
        System.out.println("\n5. Verifying exported data:");
        ride.printRideHistory();

        System.out.println("\n=== Part Six Method Completed ===");
    }

    /**
     * Part 3: Queue management demonstration method
     */
    public void partThree() {
        System.out.println("Part 3: Queue management for waiting visitors");
        // Already implemented in previous parts
    }

    /**
     * Part 4A: Ride history with LinkedList demonstration method
     */
    public void partFourA() {
        System.out.println("Part 4A: Ride history with LinkedList");
        // Already implemented in previous parts
    }

    /**
     * Part 4B: Ride history sorting demonstration method
     */
    public void partFourB() {
        System.out.println("Part 4B: Sorting ride history");
        // Already implemented in previous parts
    }

    /**
     * Part 5: Running ride cycles demonstration method
     */
    public void partFive() {
        System.out.println("Part 5: Running ride cycles");
        // Already implemented in previous parts
    }

    /**
     * Part 7: Reading from file demonstration method
     * To be implemented in Part 7
     */
    public void partSeven() {
        System.out.println("Part 7: Reading ride history from file");
        // To be implemented in next part
    }
}