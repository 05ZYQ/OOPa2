/**
 * AssignmentTwo class - Main class containing main method and demonstration methods for all parts
 */
public class AssignmentTwo {
    
    /**
     * Main method - Program entry point
     */
    public static void main(String[] args) {
        System.out.println("=== Park Rides Visitor Management System (PRVMS) ===");
        
        // Run Part 5 demonstration
        demonstratePartFive();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Run specific partFive method
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partFive();
    }
    
    /**
     * Demonstrate Part 5 ride cycle functionality
     */
    private static void demonstratePartFive() {
        System.out.println("\n=== Part 5: Running Ride Cycles ===");
        
        // 1. Create employee (operator)
        System.out.println("\n1. Creating ride operator:");
        Employee operator = new Employee("John RideMaster", 30, "john@themepark.com", "E1001", "Ride Operations");
        System.out.println("Created: " + operator);
        
        // 2. Create rides with different maxRider settings
        System.out.println("\n2. Creating rides with different capacities:");
        Ride rollerCoaster = new Ride("Thunder Bolt", "RollerCoaster", 140, 2);  // 2 visitors per cycle
        Ride waterRide = new Ride("Splash Mountain", "WaterRide", 120, 4);       // 4 visitors per cycle
        Ride ferrisWheel = new Ride("Sky Wheel", "FamilyRide", 100, 6);          // 6 visitors per cycle
        
        System.out.println("Roller Coaster: " + rollerCoaster);
        System.out.println("Water Ride: " + waterRide);
        System.out.println("Ferris Wheel: " + ferrisWheel);
        
        // 3. Assign operators to rides
        System.out.println("\n3. Assigning operators to rides:");
        rollerCoaster.setOperator(operator);
        waterRide.setOperator(operator);
        // Ferris Wheel not assigned operator for error testing
        
        // 4. Create test visitors
        System.out.println("\n4. Creating visitors for testing:");
        Visitor[] visitors = new Visitor[15];
        for (int i = 0; i < visitors.length; i++) {
            String ticketType = (i % 3 == 0) ? "SeasonPass" : (i % 3 == 1) ? "DayPass" : "Single";
            visitors[i] = new Visitor("Visitor" + (i+1), 15 + i, "visitor" + (i+1) + "@email.com", 
                                    "V" + (3000 + i), ticketType);
            System.out.println("  " + (i+1) + ". " + visitors[i].getName() + " (" + ticketType + ")");
        }
        
        // 5. Add visitors to roller coaster queue (at least 10)
        System.out.println("\n5. Adding visitors to roller coaster queue:");
        for (int i = 0; i < 10; i++) {
            rollerCoaster.addVisitorToQueue(visitors[i]);
        }
        
        // 6. Print queue status before running cycle
        System.out.println("\n6. Queue status before running cycle:");
        rollerCoaster.printQueue();
        
        // 7. Run one cycle
        System.out.println("\n7. Running one cycle:");
        rollerCoaster.runOneCycle();
        
        // 8. Print queue status after running cycle
        System.out.println("\n8. Queue status after running cycle:");
        rollerCoaster.printQueue();
        
        // 9. Print ride history
        System.out.println("\n9. Ride history after running cycle:");
        rollerCoaster.printRideHistory();
        
        // 10. Test error cases
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTING ERROR CASES");
        System.out.println("=".repeat(50));
        
        // 10.1 Test ride without operator
        System.out.println("\n10.1 Testing ride without operator:");
        ferrisWheel.runOneCycle();
        
        // 10.2 Test ride with empty queue
        System.out.println("\n10.2 Testing ride with empty queue:");
        Ride emptyRide = new Ride("Test Ride", "Test", 100, 2);
        Employee testOperator = new Employee("Test Operator", 25, "test@park.com", "E9999", "Test");
        emptyRide.setOperator(testOperator);
        emptyRide.runOneCycle();
        
        // 11. Test multiple cycle runs
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTING MULTIPLE CYCLES");
        System.out.println("=".repeat(50));
        
        // 11.1 Add visitors to water ride
        System.out.println("\n11.1 Adding visitors to water ride:");
        for (int i = 5; i < 15; i++) {
            waterRide.addVisitorToQueue(visitors[i]);
        }
        
        // 11.2 Run multiple cycles
        System.out.println("\n11.2 Running multiple cycles:");
        waterRide.printCycleInfo();
        
        System.out.println("\nRunning first cycle:");
        waterRide.runOneCycle();
        
        System.out.println("\nRunning second cycle:");
        waterRide.runOneCycle();
        
        System.out.println("\nRunning third cycle:");
        waterRide.runOneCycle();
        
        // 11.3 Final status
        System.out.println("\n11.3 Final status after multiple cycles:");
        waterRide.printCycleInfo();
        waterRide.printQueue();
        waterRide.printRideHistory();
        
        System.out.println("\n=== Part 5 Demonstration Completed ===");
    }
    
    /**
     * Part 5 method - Specific demonstration as required
     */
    public void partFive() {
        System.out.println("\n=== Executing Part Five Method ===");
        
        // 1. Create new Ride object
        Ride ride = new Ride("Dragon Coaster", "RollerCoaster", 130, 3); // Max 3 visitors per cycle
        System.out.println("Created new ride: " + ride.getRideName());
        System.out.println("Max riders per cycle: " + ride.getMaxRider());
        
        // 2. Create operator and assign to ride
        Employee operator = new Employee("Sarah Operator", 28, "sarah@park.com", "E5001", "Ride Operations");
        ride.setOperator(operator);
        
        // 3. Create at least 10 Visitor objects
        System.out.println("\n3. Creating 10+ visitors:");
        Visitor[] visitors = new Visitor[12];
        for (int i = 0; i < visitors.length; i++) {
            String ticketType = (i % 3 == 0) ? "SeasonPass" : (i % 3 == 1) ? "DayPass" : "Single";
            visitors[i] = new Visitor("Rider" + (i+1), 18 + i, "rider" + (i+1) + "@email.com", 
                                    "V" + (5000 + i), ticketType);
            System.out.println("  " + visitors[i].getName() + " (" + ticketType + ")");
        }
        
        // 4. Add at least 10 Visitors to Queue
        System.out.println("\n4. Adding visitors to queue:");
        for (int i = 0; i < 10; i++) {
            ride.addVisitorToQueue(visitors[i]);
        }
        
        // 5. Print all Visitors in queue
        System.out.println("\n5. Queue before running cycle:");
        ride.printQueue();
        
        // 6. Run one cycle
        System.out.println("\n6. Running one cycle:");
        ride.runOneCycle();
        
        // 7. Print Visitors in queue after running cycle
        System.out.println("\n7. Queue after running cycle:");
        ride.printQueue();
        
        // 8. Print all Visitors in collection (ride history)
        System.out.println("\n8. Visitors in ride history:");
        ride.printRideHistory();
        
        // 9. Display cycle information
        System.out.println("\n9. Final ride information:");
        ride.printCycleInfo();
        
        System.out.println("\n=== Part Five Method Completed ===");
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
     * Part 6: Writing to file demonstration method
     * To be implemented in Part 6
     */
    public void partSix() {
        System.out.println("Part 6: Writing ride history to file");
        // To be implemented in next part
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