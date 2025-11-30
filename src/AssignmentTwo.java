/**
 * AssignmentTwo class - Main class containing main method and demonstration methods for each part
 */
public class AssignmentTwo {
    
    public static void main(String[] args) {
        System.out.println("=== Theme Park Management System ===");
        System.out.println("Part 1: Classes and Inheritance Implementation");
        
        // Create test objects
        testPartOne();
    }
    
    /**
     * Test implementation of Part 1
     */
    private static void testPartOne() {
        System.out.println("\n--- Testing Part 1: Classes and Inheritance ---");
        
        // Create employees
        Employee employee1 = new Employee("John Smith", 28, "john.smith@themepark.com", "E1001", "Ride Operations");
        Employee employee2 = new Employee("Sarah Johnson", 32, "sarah.j@themepark.com", "E1002", "Ride Operations");
        
        // Create visitors
        Visitor visitor1 = new Visitor("Alice Brown", 25, "alice.brown@email.com", "V2001", "DayPass");
        Visitor visitor2 = new Visitor("Bob Wilson", 12, "bob.wilson@email.com", "V2002", "Single");
        Visitor visitor3 = new Visitor("Carol Davis", 30, "carol.davis@email.com", "V2003", "SeasonPass");
        
        // Create rides
        Ride rollerCoaster = new Ride("Thunder Bolt", "RollerCoaster", 140);
        Ride waterRide = new Ride("Splash Mountain", "WaterRide", 120);
        
        // Assign operators
        rollerCoaster.setOperator(employee1);
        waterRide.setOperator(employee2);
        
        // Test functionality
        System.out.println("\nCreated Employees:");
        System.out.println(employee1);
        System.out.println(employee2);
        
        System.out.println("\nCreated Visitors:");
        System.out.println(visitor1);
        System.out.println(visitor2);
        System.out.println(visitor3);
        
        System.out.println("\nCreated Rides:");
        System.out.println(rollerCoaster);
        System.out.println(waterRide);
        
        // Test ride access
        System.out.println("\nTesting Ride Access:");
        System.out.println(visitor1.getName() + " can ride Thunder Bolt: " + rollerCoaster.canVisitorRide(visitor1));
        System.out.println(visitor2.getName() + " can ride Thunder Bolt: " + rollerCoaster.canVisitorRide(visitor2));
    }
    
    // Placeholder methods for subsequent parts
    public void partThree() {}
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}