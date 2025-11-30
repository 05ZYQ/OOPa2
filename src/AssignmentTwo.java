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
        System.out.println("Part 2: Abstract Class and Interface Implementation");

        // Demonstrate Part 2 functionality
        demonstratePartTwo();
    }

    /**
     * Demonstrate abstract class and interface functionality for Part 2
     */
    private static void demonstratePartTwo() {
        System.out.println("\n--- Part 2 Demonstration: Abstract Class and Interface ---");

        // 1. Test abstract class functionality
        System.out.println("\n1. Testing Abstract Class (Person):");

        // Create employee and visitor objects
        Employee employee = new Employee("John Operator", 28, "john@themepark.com", "E1001", "Ride Operations");
        Visitor visitor = new Visitor("Alice Guest", 25, "alice@email.com", "V2001", "DayPass");

        // Test abstract methods
        System.out.println("Employee introduction: " + employee.introduce());
        System.out.println("Visitor introduction: " + visitor.introduce());

        // 2. Test interface implementation
        System.out.println("\n2. Testing Interface Implementation:");

        Ride rollerCoaster = new Ride("Thunder Bolt", "RollerCoaster", 140);

        // Test interface methods
        System.out.println("\n2.1 Testing queue operations:");
        rollerCoaster.addVisitorToQueue(visitor);
        rollerCoaster.printQueue();
        rollerCoaster.removeVisitorFromQueue();
        rollerCoaster.printQueue();

        System.out.println("\n2.2 Testing history operations:");
        rollerCoaster.addVisitorToHistory(visitor);
        rollerCoaster.checkVisitorFromHistory(visitor);
        rollerCoaster.numberOfVisitors();
        rollerCoaster.printRideHistory();

        System.out.println("\n2.3 Testing runOneCycle (placeholder):");
        rollerCoaster.runOneCycle();

        // 3. Test multiple visitor scenario
        System.out.println("\n3. Testing with multiple visitors:");

        Visitor visitor1 = new Visitor("Bob Wilson", 30, "bob@email.com", "V2002", "SeasonPass");
        Visitor visitor2 = new Visitor("Carol Davis", 22, "carol@email.com", "V2003", "DayPass");
        Visitor visitor3 = new Visitor("David Brown", 18, "david@email.com", "V2004", "Single");

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.printQueue();

        // 4. Test error handling
        System.out.println("\n4. Testing error handling:");
        rollerCoaster.addVisitorToQueue(null); // Test null value handling
        rollerCoaster.addVisitorToHistory(null); // Test null value handling
        rollerCoaster.checkVisitorFromHistory(null); // Test null value handling

        // Remove from empty queue
        Ride emptyRide = new Ride("Empty Ride", "Test", 100);
        emptyRide.removeVisitorFromQueue();

        System.out.println("\n=== Part 2 Demonstration Completed ===");
    }

    /**
     * Part 3: Waiting queue management demonstration
     * 将在Part 3中实现
     */
    public void partThree() {
        System.out.println("Part 3: Queue management for waiting visitors");
        // 将在后续部分实现
    }

    /**
     * Part 4A: 游乐设施历史记录演示方法
     * 将在Part 4A中实现
     */
    public void partFourA() {
        System.out.println("Part 4A: Ride history with LinkedList");
        // 将在后续部分实现
    }

    /**
     * Part 4B: 历史记录排序演示方法
     * 将在Part 4B中实现
     */
    public void partFourB() {
        System.out.println("Part 4B: Sorting ride history");
        // 将在后续部分实现
    }

    /**
     * Part 5: 运行设施周期演示方法
     * 将在Part 5中实现
     */
    public void partFive() {
        System.out.println("Part 5: Running ride cycles");
        // 将在后续部分实现
    }

    /**
     * Part 6: 写入文件演示方法
     * 将在Part 6中实现
     */
    public void partSix() {
        System.out.println("Part 6: Writing ride history to file");
        // 将在后续部分实现
    }

    /**
     * Part 7: 读取文件演示方法
     * 将在Part 7中实现
     */
    public void partSeven() {
        System.out.println("Part 7: Reading ride history from file");
        // 将在后续部分实现
    }
}