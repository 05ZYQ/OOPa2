import java.io.File;

/**
 * AssignmentTwo class - Main class containing main method and demonstration methods for all parts
 */
public class AssignmentTwo {

    /**
     * Main method - Program entry point
     */
    public static void main(String[] args) {
        System.out.println("=== Park Rides Visitor Management System (PRVMS) ===");

        // Run Part 7 demonstration
        demonstratePartSeven();

        System.out.println("\n" + "=".repeat(50));

        // Run specific partSeven method
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partSeven();
    }

    /**
     * Demonstrate Part 7 file reading functionality
     */
    private static void demonstratePartSeven() {
        System.out.println("\n=== Part 7: Reading from File ===");

        // First, create a file to import (using Part 6 functionality)
        System.out.println("\n1. First, creating a test file using export functionality:");

        Ride testRide = new Ride("Test Coaster", "RollerCoaster", 130, 4);

        // Add test visitors
        testRide.addVisitorToHistory(new Visitor("Test Visitor 1", 20, "test1@email.com", "V8001", "DayPass"));
        testRide.addVisitorToHistory(new Visitor("Test Visitor 2", 25, "test2@email.com", "V8002", "SeasonPass"));
        testRide.addVisitorToHistory(new Visitor("Test Visitor 3", 18, "test3@email.com", "V8003", "Single"));
        testRide.addVisitorToHistory(new Visitor("Test Visitor 4", 22, "test4@email.com", "V8004", "DayPass"));
        testRide.addVisitorToHistory(new Visitor("Test Visitor 5", 30, "test5@email.com", "V8005", "SeasonPass"));

        // Export to file
        String testFilename = "test_import_file.csv";
        boolean exportSuccess = testRide.exportRideHistory(testFilename);

        if (!exportSuccess) {
            System.out.println("Error: Failed to create test file. Cannot demonstrate import.");
            return;
        }

        System.out.println("Test file created: " + testFilename);
        System.out.println("File size: " + new File(testFilename).length() + " bytes");

        // 2. Create a new Ride for import testing
        System.out.println("\n2. Creating new ride for import testing:");
        Ride ride = new Ride("Imported Coaster", "RollerCoaster", 140, 3);
        System.out.println("Created: " + ride);

        // Check initial state (should be empty)
        System.out.println("\n3. Initial state before import:");
        System.out.println("Number of visitors in history: " + ride.numberOfVisitors());
        ride.printRideHistory();

        // 4. Import the file
        System.out.println("\n4. Importing file: " + testFilename);
        int importedCount = ride.importRideHistory(testFilename);

        if (importedCount > 0) {
            System.out.println("Successfully imported " + importedCount + " visitors!");
        } else if (importedCount == 0) {
            System.out.println("No visitors were imported.");
        } else {
            System.out.println("Import failed with error.");
        }

        // 5. Confirm import by checking LinkedList
        System.out.println("\n5. Confirming import results:");
        System.out.println("Number of visitors in LinkedList: " + ride.numberOfVisitors());

        // Print all visitors to confirm details were imported correctly
        System.out.println("\n6. Printing all imported visitors:");
        ride.printRideHistory();

        // 7. Test importing the same file again (should not add duplicates)
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTING DUPLICATE IMPORT");
        System.out.println("=".repeat(50));

        System.out.println("\n7. Importing the same file again (should not add duplicates):");
        int secondImportCount = ride.importRideHistory(testFilename);
        System.out.println("Second import added " + secondImportCount + " new visitors");
        System.out.println("Total visitors after second import: " + ride.numberOfVisitors());

        // 8. Test different file formats
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTING DIFFERENT FILE FORMATS");
        System.out.println("=".repeat(50));

        // Create file without ride information
        System.out.println("\n8.1 Testing import without ride information:");
        String simpleFilename = "simple_visitors.csv";

        // Manually create a simple CSV file
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(simpleFilename))) {
            writer.println("Visitor Name,Visitor ID,Age,Email,Ticket Type");
            writer.println("Simple Visitor 1,SV1001,21,simple1@email.com,DayPass");
            writer.println("Simple Visitor 2,SV1002,26,simple2@email.com,SeasonPass");
            writer.println("Simple Visitor 3,SV1003,19,simple3@email.com,Single");
            System.out.println("Created simple CSV file: " + simpleFilename);
        } catch (java.io.IOException e) {
            System.out.println("Error creating simple CSV file: " + e.getMessage());
        }

        Ride simpleRide = new Ride("Simple Ride", "FamilyRide", 100, 6);
        int simpleImportCount = simpleRide.importRideHistory(simpleFilename, false);
        System.out.println("Imported " + simpleImportCount + " visitors from simple format");
        simpleRide.printRideHistory();

        // 9. Test error cases
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTING ERROR CASES");
        System.out.println("=".repeat(50));

        // 9.1 Test non-existent file
        System.out.println("\n9.1 Testing import of non-existent file:");
        Ride errorRide = new Ride("Error Ride", "Test", 100, 2);
        int nonExistentImport = errorRide.importRideHistory("nonexistent_file.csv");
        if (nonExistentImport == -1) {
            System.out.println("Expected error: File not found");
        }

        // 9.2 Test empty file
        System.out.println("\n9.2 Testing import of empty file:");
        String emptyFilename = "empty_file.csv";
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(emptyFilename))) {
            // Create empty file
        } catch (java.io.IOException e) {
            System.out.println("Error creating empty file: " + e.getMessage());
        }

        int emptyImport = errorRide.importRideHistory(emptyFilename);
        System.out.println("Empty file import result: " + emptyImport + " visitors imported");

        // 9.3 Test file with invalid format
        System.out.println("\n9.3 Testing import of file with invalid format:");
        String invalidFilename = "invalid_format.csv";
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(invalidFilename))) {
            writer.println("Invalid,Header");
            writer.println("Only,Two,Fields"); // Only 2 fields instead of 8
            writer.println("1,2,3,4,5,6,7");   // 7 fields instead of 8
            System.out.println("Created invalid format file: " + invalidFilename);
        } catch (java.io.IOException e) {
            System.out.println("Error creating invalid file: " + e.getMessage());
        }

        int invalidImport = errorRide.importRideHistory(invalidFilename);
        System.out.println("Invalid format import result: " + invalidImport + " visitors imported");

        // 10. Clean up test files
        System.out.println("\n10. Cleaning up test files:");
        deleteFile(testFilename);
        deleteFile(simpleFilename);
        deleteFile(emptyFilename);
        deleteFile(invalidFilename);

        System.out.println("\n=== Part 7 Demonstration Completed ===");
    }

    /**
     * Helper method to delete test files
     */
    private static void deleteFile(String filename) {
        File file = new File(filename);
        if (file.exists() && file.delete()) {
            System.out.println("  Deleted: " + filename);
        }
    }

    /**
     * Part 7 method - Specific demonstration as required
     */
    public void partSeven() {
        System.out.println("\n=== Executing Part Seven Method ===");

        // 1. First, export a file using Part 6 functionality
        System.out.println("1. Creating a file to import (using export functionality):");

        Ride exportRide = new Ride("Export Coaster", "RollerCoaster", 135, 4);

        // Create at least 5 visitors and add to ride history
        exportRide.addVisitorToHistory(new Visitor("Alice Importer", 24, "alice@import.com", "V9001", "DayPass"));
        exportRide.addVisitorToHistory(new Visitor("Bob Importer", 31, "bob@import.com", "V9002", "SeasonPass"));
        exportRide.addVisitorToHistory(new Visitor("Carol Importer", 19, "carol@import.com", "V9003", "Single"));
        exportRide.addVisitorToHistory(new Visitor("David Importer", 27, "david@import.com", "V9004", "DayPass"));
        exportRide.addVisitorToHistory(new Visitor("Emma Importer", 22, "emma@import.com", "V9005", "SeasonPass"));
        exportRide.addVisitorToHistory(new Visitor("Frank Importer", 35, "frank@import.com", "V9006", "Single")); // Extra visitor

        // Export to file
        String importFilename = "part7_import_file.csv";
        boolean exportSuccess = exportRide.exportRideHistory(importFilename);

        if (!exportSuccess) {
            System.out.println("Error: Failed to create import file. Exiting.");
            return;
        }

        System.out.println("File created for import: " + importFilename);

        // 2. Create a new Ride
        System.out.println("\n2. Creating new ride for import:");
        Ride ride = new Ride("Import Coaster", "RollerCoaster", 140, 3);
        System.out.println("Created: " + ride.getRideName());

        // 3. Import the file created in previous part
        System.out.println("\n3. Importing file: " + importFilename);
        int importedCount = ride.importRideHistory(importFilename);

        if (importedCount >= 0) {
            System.out.println("Import process completed.");
        } else {
            System.out.println("Import failed with error.");
        }

        // 4. Print the number of Visitors in LinkedList to confirm correct import
        System.out.println("\n4. Verifying import results:");
        int visitorCount = ride.numberOfVisitors();
        System.out.println("Number of visitors imported: " + visitorCount);

        // 5. Print all Visitors in LinkedList to confirm details were imported correctly
        System.out.println("\n5. Printing all visitors to confirm details:");
        ride.printRideHistory();

        // 6. Additional verification
        System.out.println("\n6. Additional verification:");
        if (visitorCount >= 5) {
            System.out.println("✓ Success: At least 5 visitors were imported as required");
        } else {
            System.out.println("✗ Error: Expected at least 5 visitors, but found " + visitorCount);
        }

        // Check if specific visitors were imported
        System.out.println("\nChecking if specific visitors were imported:");
        Visitor testVisitor = new Visitor("Alice Importer", 24, "alice@import.com", "V9001", "DayPass");
        boolean found = ride.checkVisitorFromHistory(testVisitor);
        if (found) {
            System.out.println("✓ Alice Importer was successfully imported");
        } else {
            System.out.println("✗ Alice Importer was not found in import");
        }

        // 7. Clean up
        System.out.println("\n7. Cleaning up test file:");
        File file = new File(importFilename);
        if (file.delete()) {
            System.out.println("Deleted test file: " + importFilename);
        } else {
            System.out.println("Warning: Could not delete test file");
        }

        System.out.println("\n=== Part Seven Method Completed ===");
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
     * Part 6: Writing to file demonstration method
     */
    public void partSix() {
        System.out.println("Part 6: Writing ride history to file");
        // Already implemented in previous parts
    }
}