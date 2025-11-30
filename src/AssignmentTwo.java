/**
 * AssignmentTwo class - Main class containing main method and demonstration methods for each part
 */
public class AssignmentTwo {
    
    public static void main(String[] args) {
        System.out.println("=== Theme Park Management System Part 1 Demonstration ===");
        
        // Create test object
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.testPartOne();
    }
    
    /**
     * Test the classes created in Part 1
     */
    public void testPartOne() {
        System.out.println("\n--- Part 1: Class and Inheritance Demonstration ---");
        
        // Create employees
        Employee operator1 = new Employee("Zhang San", 25, "Male", "E1001", "Roller Coaster Department");
        Employee operator2 = new Employee("Li Si", 28, "Female", "E1002", "Water Facilities Department");
        
        // Create visitors
        Visitor visitor1 = new Visitor("Wang Wu", 20, "Male", "T2001", true);
        Visitor visitor2 = new Visitor("Zhao Liu", 15, "Female", "T2002", false);
        Visitor visitor3 = new Visitor("Qian Qi", 30, "Male", "T2003", true);
        
        // Create rides
        Ride rollerCoaster = new Ride("Speed Racer", "Roller Coaster", 140, operator1);
        Ride waterRide = new Ride("Raging Rapids", "Water Ride", 120, operator2);
        
        // Demonstrate successful object creation
        System.out.println("Employee Information:");
        System.out.println(operator1);
        System.out.println(operator2);
        
        System.out.println("\nVisitor Information:");
        System.out.println(visitor1);
        System.out.println(visitor2);
        System.out.println(visitor3);
        
        System.out.println("\nRide Information:");
        System.out.println(rollerCoaster);
        System.out.println(waterRide);
        
        // Demonstrate getter and setter methods
        System.out.println("\n--- Getter and Setter Demonstration ---");
        visitor1.setAge(21); // Modify age
        System.out.println("Visitor 1's age after modification: " + visitor1.getAge());
        
        rollerCoaster.setMinHeightRequirement(145); // Modify height requirement
        System.out.println("Roller coaster's minimum height requirement after modification: " + rollerCoaster.getMinHeightRequirement() + "cm");
    }
    
    // Reserved methods for subsequent parts
    public void partThree() {}
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}