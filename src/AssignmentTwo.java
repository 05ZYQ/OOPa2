/**
 * AssignmentTwo class - Main class containing main method and demonstration methods for each part
 * Main entry point for the theme park management system
 */
public class AssignmentTwo {
    
    /**
     * Main method - Program entry point
     */
    public static void main(String[] args) {
        System.out.println("=== Park Rides Visitor Management System (PRVMS) ===");
        
        // Demonstrate Part 3 functionality
        demonstratePartThree();
    }
    
    /**
     * Demonstrate waiting line management functionality for Part 3
     */
    private static void demonstratePartThree() {
        System.out.println("\n=== Part 3: Waiting Line Management with Queue ===");
        
        // Create visitors for testing
        System.out.println("\n1. Creating visitors for testing:");
        Visitor visitor1 = new Visitor("Alice Brown", 25, "alice@email.com", "V2001", "DayPass");
        Visitor visitor2 = new Visitor("Bob Wilson", 12, "bob@email.com", "V2002", "Single");
        Visitor visitor3 = new Visitor("Carol Davis", 30, "carol@email.com", "V2003", "SeasonPass");
        Visitor visitor4 = new Visitor("David Lee", 8, "david@email.com", "V2004", "Single"); // Too young
        Visitor visitor5 = new Visitor("Emma Garcia", 28, "emma@email.com", "V2005", "DayPass");
        Visitor visitor6 = new Visitor("Frank Miller", 35, "frank@email.com", "V2006", "SeasonPass");
        Visitor visitor7 = new Visitor("Grace Taylor", 15, "grace@email.com", "V2007", "Single");
        
        System.out.println("Created " + 7 + " visitors for testing");
        
        // Create ride object
        System.out.println("\n2. Creating ride object:");
        Ride rollerCoaster = new Ride("Thunder Bolt", "RollerCoaster", 140);
        System.out.println("Created: " + rollerCoaster);
        
        // 3. Add visitors to queue
        System.out.println("\n3. Adding visitors to queue:");
        System.out.println("3.1 Adding eligible visitors:");
        rollerCoaster.addVisitorToQueue(visitor1); // Eligible
        rollerCoaster.addVisitorToQueue(visitor2); // Eligible
        rollerCoaster.addVisitorToQueue(visitor3); // Eligible
        rollerCoaster.addVisitorToQueue(visitor5); // Eligible
        rollerCoaster.addVisitorToQueue(visitor6); // Eligible
        
        System.out.println("\n3.2 Testing ineligible visitor:");
        rollerCoaster.addVisitorToQueue(visitor4); // Ineligible - Too young
        
        System.out.println("\n3.3 Adding more visitors to reach minimum 5:");
        rollerCoaster.addVisitorToQueue(visitor7); // Eligible
        
        // 4. Print current queue status
        System.out.println("\n4. Current queue status:");
        rollerCoaster.printQueue();
        
        // 5. Remove visitors from queue
        System.out.println("\n5. Removing visitors from queue:");
        System.out.println("5.1 First removal:");
        rollerCoaster.removeVisitorFromQueue(); // Remove first (Alice)
        
        System.out.println("\n5.2 Second removal:");
        rollerCoaster.removeVisitorFromQueue(); // Remove second (Bob)
        
        // 6. Print queue status after removals
        System.out.println("\n6. Queue status after removals:");
        rollerCoaster.printQueue();
        
        // 7. Test FIFO behavior of queue
        System.out.println("\n7. Demonstrating FIFO (First-In-First-Out) behavior:");
        System.out.println("Current queue order:");
        rollerCoaster.printQueue();
        
        System.out.println("\nRemoving next visitor (should be Carol - the next in line):");
        Visitor nextInLine = rollerCoaster.peekQueue();
        if (nextInLine != null) {
            System.out.println("Next in line: " + nextInLine.getName());
        }
        rollerCoaster.removeVisitorFromQueue();
        
        System.out.println("\nQueue after removing Carol:");
        rollerCoaster.printQueue();
        
        // 8. Test helper methods
        System.out.println("\n8. Testing helper methods:");
        System.out.println("Queue size: " + rollerCoaster.getQueueSize());
        System.out.println("Is queue empty: " + rollerCoaster.isQueueEmpty());
        
        Visitor headVisitor = rollerCoaster.peekQueue();
        if (headVisitor != null) {
            System.out.println("Visitor at head of queue: " + headVisitor.getName());
        }
        
        // 9. Test edge cases
        System.out.println("\n9. Testing edge cases:");
        System.out.println("9.1 Removing from empty queue:");
        Ride emptyRide = new Ride("Test Ride", "Test", 100);
        emptyRide.removeVisitorFromQueue();
        
        System.out.println("\n9.2 Adding null visitor:");
        emptyRide.addVisitorToQueue(null);
        
        System.out.println("\n9.3 Printing empty queue:");
        emptyRide.printQueue();
        
        System.out.println("\n=== Part 3 Demonstration Completed ===");
        System.out.println("✓ Successfully demonstrated Queue operations:");
        System.out.println("  - Added visitors to queue with eligibility checks");
        System.out.println("  - Removed visitors from queue (FIFO behavior)");
        System.out.println("  - Printed queue contents in order");
        System.out.println("  - Tested edge cases and error handling");
    }
    
    /**
     * Part 3 method - Specific demonstration as required
     */
    public void partThree() {
        System.out.println("\n=== Executing Part Three Method ===");
        
        // Create new Ride object
        Ride ride = new Ride("Dragon Coaster", "RollerCoaster", 130);
        System.out.println("Created new ride: " + ride.getRideName());
        
        // Create at least 5 Visitor objects
        Visitor v1 = new Visitor("John Smith", 20, "john@email.com", "V3001", "DayPass");
        Visitor v2 = new Visitor("Maria Rodriguez", 25, "maria@email.com", "V3002", "SeasonPass");
        Visitor v3 = new Visitor("Tom Johnson", 18, "tom@email.com", "V3003", "Single");
        Visitor v4 = new Visitor("Lisa Wang", 22, "lisa@email.com", "V3004", "DayPass");
        Visitor v5 = new Visitor("Mike Chen", 30, "mike@email.com", "V3005", "SeasonPass");
        Visitor v6 = new Visitor("Sarah Kim", 16, "sarah@email.com", "V3006", "Single"); // One extra for removal test
        
        // Add at least 5 Visitors to Queue
        System.out.println("\nAdding visitors to queue:");
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.addVisitorToQueue(v6); // Add one more
        
        // Print all Visitors in Queue
        System.out.println("\nPrinting queue after adding visitors:");
        ride.printQueue();
        
        // Remove one Visitor from Queue
        System.out.println("\nRemoving one visitor from queue:");
        ride.removeVisitorFromQueue();
        
        // Print all Visitors in Queue again
        System.out.println("\nPrinting queue after removal:");
        ride.printQueue();
        
        System.out.println("\n=== Part Three Method Completed ===");
    }
    
    /**
     * Part 4A: Ride history demonstration method
     * To be implemented in Part 4A
     */
    public void partFourA() {
        System.out.println("Part 4A: Ride history with LinkedList");
        // To be implemented in later part
    }
    
    /**
     * Part 4B: History sorting demonstration method
     * To be implemented in Part 4B
     */
    public void partFourB() {
        System.out.println("Part 4B: Sorting ride history");
        // To be implemented in later part
    }
    
    /**
     * Part 5: Ride cycle operation demonstration method
     * To be implemented in Part 5
     */
    public void partFive() {
        System.out.println("Part 5: Running ride cycles");
        // To be implemented in later part
    }
    
    /**
     * Part 6: File writing demonstration method
     * To be implemented in Part 6
     */
    public void partSix() {
        System.out.println("Part 6: Writing ride history to file");
        // To be implemented in later part
    }
    
    /**
     * Part 7: File reading demonstration method
     * To be implemented in Part 7
     */
    public void partSeven() {
        System.out.println("Part 7: Reading ride history from file");
        // To be implemented in later part
    }
    
    /**
     * Method to test all parts
     */
    public static void testAllParts() {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("=== Testing All Parts ===");
        
        // Test Part 3
        System.out.println("\n--- Testing Part 3 ---");
        assignment.partThree();
        
        // Later parts will be implemented in respective Parts
        System.out.println("\n--- Other Parts (To be implemented) ---");
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Park Rides Visitor Management System (PRVMS) ===");
        
        // Run Part 3 demonstration
        demonstratePartThree();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Run specific partThree method
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
    }
}