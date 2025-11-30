import java.util.LinkedList;
import java.util.Queue;

/**
 * Ride class - Represents a ride in the theme park
 * Implements RideInterface
 * Part 3: Enhance queue management functionality
 */
public class Ride implements RideInterface {
    // Instance variables
    private String rideName;
    private String rideType; // "RollerCoaster", "WaterRide", "FamilyRide", etc.
    private int minHeight; // Minimum height requirement (cm)
    private Employee operator; // Employee responsible for operating this ride
    
    // Part 3: Waiting queue - Using LinkedList to implement Queue interface
    private Queue<Visitor> waitingQueue;
    
    // Collection to be used in Part 4 (declared now, to be implemented later)
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.minHeight = 120; // Default minimum height 120cm
        this.operator = null; // No operator initially
        this.waitingQueue = new LinkedList<>(); // Initialize waiting queue
        this.rideHistory = new LinkedList<>(); // Initialize ride history
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, int minHeight) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.minHeight = minHeight;
        this.operator = null;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Getter and Setter methods
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        if (minHeight >= 0) {
            this.minHeight = minHeight;
        } else {
            System.out.println("Minimum height cannot be negative");
        }
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
        if (operator != null) {
            operator.setAvailable(false); // Employee unavailable after assignment
            System.out.println("Employee " + operator.getName() + " assigned to operate " + rideName);
        }
    }

    // Get waiting queue (for testing)
    public Queue<Visitor> getWaitingQueue() {
        return waitingQueue;
    }

    // Get ride history (for testing)
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    // Check if the ride is operational (has an operator)
    public boolean isOperational() {
        return operator != null && !operator.isAvailable();
    }

    // Check if visitor meets ride requirements
    public boolean canVisitorRide(Visitor visitor) {
        if (visitor == null) {
            System.out.println("✗ Failure: Cannot check null visitor");
            return false;
        }
        
        boolean canRide = visitor.hasRidePass() && visitor.getAge() >= 10; // Simple check: has ride pass and age >= 10
        System.out.println("Checking if " + visitor.getName() + " can ride " + rideName + ": " + 
                          (canRide ? "✓ Eligible" : "✗ Not eligible"));
        return canRide;
    }

    // ========== RideInterface method implementations ==========

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            if (canVisitorRide(visitor)) {
                waitingQueue.add(visitor);
                System.out.println("✓ Success: Visitor " + visitor.getName() + " added to waiting queue for " + rideName);
                System.out.println("  Current queue position: " + waitingQueue.size());
            } else {
                System.out.println("✗ Failure: Visitor " + visitor.getName() + " is not eligible to ride " + rideName);
            }
        } else {
            System.out.println("✗ Failure: Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removedVisitor = waitingQueue.poll();
            System.out.println("✓ Success: Visitor " + removedVisitor.getName() + " removed from waiting queue of " + rideName);
            System.out.println("  Visitors remaining in queue: " + waitingQueue.size());
        } else {
            System.out.println("✗ Failure: Waiting queue for " + rideName + " is empty, cannot remove visitor");
        }
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue for " + rideName + " is empty");
        } else {
            System.out.println("=== Waiting Queue for " + rideName + " ===");
            System.out.println("Total visitors waiting: " + waitingQueue.size());
            System.out.println("Queue order (FIFO - First In First Out):");
            
            int position = 1;
            for (Visitor visitor : waitingQueue) {
                System.out.println("  " + position + ". " + visitor.getName() + 
                                 " (ID: " + visitor.getVisitorId() + 
                                 ", Age: " + visitor.getAge() + 
                                 ", Ticket: " + visitor.getTicketType() + ")");
                position++;
            }
            System.out.println("=== End of Queue ===");
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("✓ Success: Visitor " + visitor.getName() + " added to ride history of " + rideName);
        } else {
            System.out.println("✗ Failure: Cannot add null visitor to history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor != null) {
            boolean found = rideHistory.contains(visitor);
            System.out.println("Checking history: Visitor " + visitor.getName() + 
                             (found ? " ✓ found" : " ✗ not found") + " in ride history of " + rideName);
            return found;
        } else {
            System.out.println("✗ Failure: Cannot check null visitor in history");
            return false;
        }
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in history for " + rideName + ": " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history for " + rideName + " is empty");
        } else {
            System.out.println("Ride history for " + rideName + " (" + rideHistory.size() + " visitors):");
            // Iterator implementation will be done in Part 4A
            int count = 1;
            for (Visitor visitor : rideHistory) {
                System.out.println("  " + count + ". " + visitor.getName() + " (ID: " + visitor.getVisitorId() + ")");
                count++;
            }
        }
    }

    @Override
    public void runOneCycle() {
        // To be fully implemented in Part 5
        System.out.println("runOneCycle method called for " + rideName + " - To be implemented in Part 5");
    }

    // Part 3: New helper methods
    /**
     * Get the size of the waiting queue
     * @return Number of visitors in the queue
     */
    public int getQueueSize() {
        return waitingQueue.size();
    }
    
    /**
     * View the visitor at the front of the queue (without removing)
     * @return The visitor at the front of the queue, or null if empty
     */
    public Visitor peekQueue() {
        return waitingQueue.peek();
    }
    
    /**
     * Check if the queue is empty
     * @return True if queue is empty, false otherwise
     */
    public boolean isQueueEmpty() {
        return waitingQueue.isEmpty();
    }
    
    /**
     * Clear the waiting queue
     */
    public void clearQueue() {
        waitingQueue.clear();
        System.out.println("Waiting queue for " + rideName + " has been cleared");
    }

    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator assigned";
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", minHeight=" + minHeight +
                ", operator=" + operatorInfo +
                ", isOperational=" + isOperational() +
                ", waitingQueueSize=" + waitingQueue.size() +
                ", historySize=" + rideHistory.size() +
                '}';
    }
}