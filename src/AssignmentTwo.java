import java.util.Comparator;

/**
 * AssignmentTwo class - Main class containing main method and demonstration methods for each part
 */
public class AssignmentTwo {
    
    /**
     * Main method - Program entry point
     */
    public static void main(String[] args) {
        System.out.println("=== Park Rides Visitor Management System (PRVMS) ===");
        
        // Run Part 4 demonstration
        demonstratePartFour();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Run specific partFourA and partFourB methods
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partFourA();
        assignment.partFourB();
    }
    
    /**
     * Demonstrates Part 4's history management and sorting functionality
     */
    private static void demonstratePartFour() {
        System.out.println("\n=== Part 4: Ride History Management and Sorting ===");
        
        // Create visitors for testing
        System.out.println("\n1. Creating visitors for testing:");
        Visitor visitor1 = new Visitor("Alice Brown", 25, "alice@email.com", "V2001", "DayPass");
        Visitor visitor2 = new Visitor("Bob Wilson", 12, "bob@email.com", "V2002", "Single");
        Visitor visitor3 = new Visitor("Carol Davis", 30, "carol@email.com", "V2003", "SeasonPass");
        Visitor visitor4 = new Visitor("David Lee", 18, "david@email.com", "V2004", "DayPass");
        Visitor visitor5 = new Visitor("Emma Garcia", 28, "emma@email.com", "V2005", "SeasonPass");
        Visitor visitor6 = new Visitor("Frank Miller", 35, "frank@email.com", "V2006", "Single");
        Visitor visitor7 = new Visitor("Grace Taylor", 15, "grace@email.com", "V2007", "DayPass");
        
        System.out.println("Created " + 7 + " visitors for testing");
        
        // Create ride object
        System.out.println("\n2. Creating ride object:");
        Ride rollerCoaster = new Ride("Thunder Bolt", "RollerCoaster", 140);
        System.out.println("Created: " + rollerCoaster);
        
        // Part 4A demonstration
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PART 4A: RIDE HISTORY WITH LINKEDLIST");
        System.out.println("=".repeat(60));
        
        // 3. Add visitors to ride history
        System.out.println("\n3. Adding visitors to ride history:");
        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);
        
        // 4. Check if visitors are in history
        System.out.println("\n4. Checking visitors in history:");
        rollerCoaster.checkVisitorFromHistory(visitor3); // Should exist
        rollerCoaster.checkVisitorFromHistory(visitor6); // Should not exist
        
        // 5. Print number of visitors
        System.out.println("\n5. Number of visitors in history:");
        rollerCoaster.numberOfVisitors();
        
        // 6. Print ride history (using Iterator)
        System.out.println("\n6. Printing ride history (using Iterator):");
        rollerCoaster.printRideHistory();
        
        // Part 4B demonstration
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PART 4B: SORTING RIDE HISTORY");
        System.out.println("=".repeat(60));
        
        // 7. Create new ride for sorting demonstration
        System.out.println("\n7. Creating new ride for sorting demonstration:");
        Ride waterRide = new Ride("Splash Mountain", "WaterRide", 120);
        
        // Add visitors with varied data for sorting
        System.out.println("\n8. Adding visitors with varied data for sorting:");
        waterRide.addVisitorToHistory(new Visitor("Zoe Adams", 22, "zoe@email.com", "V3001", "Single"));
        waterRide.addVisitorToHistory(new Visitor("Charlie Brown", 35, "charlie@email.com", "V3002", "SeasonPass"));
        waterRide.addVisitorToHistory(new Visitor("Alice Cooper", 18, "alice@email.com", "V3003", "DayPass"));
        waterRide.addVisitorToHistory(new Visitor("Bob Marley", 28, "bob@email.com", "V3004", "Single"));
        waterRide.addVisitorToHistory(new Visitor("David Bowie", 45, "david@email.com", "V3005", "SeasonPass"));
        
        // 9. Demonstrate sorting by name
        System.out.println("\n9.1 Sorting by name:");
        System.out.println("Before sorting:");
        waterRide.printRideHistory();
        
        waterRide.sortHistoryByName();
        System.out.println("After sorting by name:");
        waterRide.printRideHistory();
        
        // 10. Demonstrate sorting by age
        System.out.println("\n9.2 Sorting by age:");
        // Reset order
        waterRide.getRideHistory().clear();
        waterRide.addVisitorToHistory(new Visitor("Zoe Adams", 22, "zoe@email.com", "V3001", "Single"));
        waterRide.addVisitorToHistory(new Visitor("Charlie Brown", 35, "charlie@email.com", "V3002", "SeasonPass"));
        waterRide.addVisitorToHistory(new Visitor("Alice Cooper", 18, "alice@email.com", "V3003", "DayPass"));
        waterRide.addVisitorToHistory(new Visitor("Bob Marley", 28, "bob@email.com", "V3004", "Single"));
        waterRide.addVisitorToHistory(new Visitor("David Bowie", 45, "david@email.com", "V3005", "SeasonPass"));
        
        System.out.println("Before sorting:");
        waterRide.printRideHistory();
        
        waterRide.sortHistoryByAge();
        System.out.println("After sorting by age:");
        waterRide.printRideHistory();
        
        // 11. Demonstrate sorting by ticket type
        System.out.println("\n9.3 Sorting by ticket type:");
        // Reset order
        waterRide.getRideHistory().clear();
        waterRide.addVisitorToHistory(new Visitor("Zoe Adams", 22, "zoe@email.com", "V3001", "Single"));
        waterRide.addVisitorToHistory(new Visitor("Charlie Brown", 35, "charlie@email.com", "V3002", "SeasonPass"));
        waterRide.addVisitorToHistory(new Visitor("Alice Cooper", 18, "alice@email.com", "V3003", "DayPass"));
        waterRide.addVisitorToHistory(new Visitor("Bob Marley", 28, "bob@email.com", "V3004", "Single"));
        waterRide.addVisitorToHistory(new Visitor("David Bowie", 45, "david@email.com", "V3005", "SeasonPass"));
        
        System.out.println("Before sorting:");
        waterRide.printRideHistory();
        
        waterRide.sortHistoryByTicketType();
        System.out.println("After sorting by ticket type:");
        waterRide.printRideHistory();
        
        System.out.println("\n=== Part 4 Demonstration Completed ===");
    }
    
    /**
     * Part 4A method - Specific demonstration as required
     */
    public void partFourA() {
        System.out.println("\n=== Executing Part FourA Method ===");
        
        // Create new Ride object
        Ride ride = new Ride("Dragon Coaster", "RollerCoaster", 130);
        System.out.println("Created new ride: " + ride.getRideName());
        
        // Create at least 5 Visitor objects
        Visitor v1 = new Visitor("John Smith", 20, "john@email.com", "V4001", "DayPass");
        Visitor v2 = new Visitor("Maria Rodriguez", 25, "maria@email.com", "V4002", "SeasonPass");
        Visitor v3 = new Visitor("Tom Johnson", 18, "tom@email.com", "V4003", "Single");
        Visitor v4 = new Visitor("Lisa Wang", 22, "lisa@email.com", "V4004", "DayPass");
        Visitor v5 = new Visitor("Mike Chen", 30, "mike@email.com", "V4005", "SeasonPass");
        
        // Add at least 5 Visitors to history
        System.out.println("\nAdding visitors to ride history:");
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);
        
        // Check if a Visitor is in the collection
        System.out.println("\nChecking if visitor is in history:");
        ride.checkVisitorFromHistory(v3); // Should exist
        ride.checkVisitorFromHistory(new Visitor("Unknown", 0, "unknown", "V9999", "Single")); // Should not exist
        
        // Print number of Visitors in the collection
        System.out.println("\nNumber of visitors in history:");
        ride.numberOfVisitors();
        
        // Print all Visitors in the collection (using Iterator)
        System.out.println("\nPrinting all visitors in history (using Iterator):");
        ride.printRideHistory();
        
        System.out.println("\n=== Part FourA Method Completed ===");
    }
    
    /**
     * Part 4B method - Specific demonstration as required
     */
    public void partFourB() {
        System.out.println("\n=== Executing Part FourB Method ===");
        
        // Create new Ride object
        Ride ride = new Ride("Space Adventure", "MotionRide", 110);
        System.out.println("Created new ride: " + ride.getRideName());
        
        // Create at least 5 Visitor objects (with different data for sorting)
        Visitor v1 = new Visitor("Charlie Brown", 15, "charlie@email.com", "V5001", "Single");
        Visitor v2 = new Visitor("Alice Smith", 28, "alice@email.com", "V5002", "SeasonPass");
        Visitor v3 = new Visitor("Bob Wilson", 22, "bob@email.com", "V5003", "DayPass");
        Visitor v4 = new Visitor("Diana Prince", 35, "diana@email.com", "V5004", "SeasonPass");
        Visitor v5 = new Visitor("Eve Johnson", 19, "eve@email.com", "V5005", "Single");
        
        // Add at least 5 Visitors to collection
        System.out.println("\nAdding visitors to ride history:");
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);
        
        // Print all Visitors in the collection (before sorting)
        System.out.println("\nBefore sorting:");
        ride.printRideHistory();
        
        // Sort the collection (using Comparator)
        System.out.println("\nSorting ride history by name...");
        ride.sortHistoryByName();
        
        // Print all Visitors in the collection again to show sorting
        System.out.println("\nAfter sorting by name:");
        ride.printRideHistory();
        
        System.out.println("\n=== Part FourB Method Completed ===");
    }
    
    /**
     * Part 3: Queue management demonstration method
     */
    public void partThree() {
        System.out.println("Part 3: Queue management for waiting visitors");
        // Already implemented previously
    }
    
    /**
     * Part 5: Ride cycle execution demonstration method
     * To be implemented in Part 5
     */
    public void partFive() {
        System.out.println("Part 5: Running ride cycles");
        // To be implemented in future part
    }
    
    /**
     * Part 6: File writing demonstration method
     * To be implemented in Part 6
     */
    public void partSix() {
        System.out.println("Part 6: Writing ride history to file");
        // To be implemented in future part
    }
    
    /**
     * Part 7: File reading demonstration method
     * To be implemented in Part 7
     */
    public void partSeven() {
        System.out.println("Part 7: Reading ride history from file");
        // To be implemented in future part
    }
}