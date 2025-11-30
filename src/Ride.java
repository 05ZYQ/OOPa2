import java.util.LinkedList;
import java.util.Queue;

/**
 * Ride class - Represents a ride in the theme park
 * Implements RideInterface
 * Part 2: Implement interface methods (some methods with empty implementation for now, to be completed in later parts)
 */
public class Ride implements RideInterface {
    // Instance variables
    private String rideName;
    private String rideType; // "RollerCoaster", "WaterRide", "FamilyRide", etc.
    private int minHeight; // Minimum height requirement (cm)
    private Employee operator; // Employee responsible for operating the ride

    // Collections to be used in Part 3 & 4 (declared now, implemented later)
    private Queue<Visitor> waitingQueue;
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

    // Constructor with parameters
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
            operator.setAvailable(false); // Employee becomes unavailable after assignment
            System.out.println("Employee " + operator.getName() + " assigned to operate " + rideName);
        }
    }

    // Get waiting queue (for later testing)
    public Queue<Visitor> getWaitingQueue() {
        return waitingQueue;
    }

    // Get ride history (for later testing)
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    // Check if the ride is operational (has an operator)
    public boolean isOperational() {
        return operator != null && !operator.isAvailable();
    }

    // Check if visitor meets ride requirements
    public boolean canVisitorRide(Visitor visitor) {
        // Additional checks can be added here, such as age, health condition, etc.
        System.out.println("Checking if " + visitor.getName() + " can ride " + rideName);
        return visitor.hasRidePass();
    }

    // ========== RideInterface method implementations ==========

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.add(visitor);
            System.out.println("✓ Success: Visitor " + visitor.getName() + " added to waiting queue for " + rideName);
        } else {
            System.out.println("✗ Failure: Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removedVisitor = waitingQueue.poll();
            System.out.println("✓ Success: Visitor " + removedVisitor.getName() + " removed from waiting queue");
        } else {
            System.out.println("✗ Failure: Waiting queue is empty, cannot remove visitor");
        }
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue for " + rideName + " is empty");
        } else {
            System.out.println("Waiting queue for " + rideName + " (" + waitingQueue.size() + " visitors):");
            int position = 1;
            for (Visitor visitor : waitingQueue) {
                System.out.println("  " + position + ". " + visitor.getName() + " (ID: " + visitor.getVisitorId() + ")");
                position++;
            }
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
                    (found ? " found" : " not found") + " in ride history");
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
            // Iterator implementation will be in Part 4A
            int count = 1;
            for (Visitor visitor : rideHistory) {
                System.out.println("  " + count + ". " + visitor.getName() + " (ID: " + visitor.getVisitorId() + ")");
                count++;
            }
        }
    }

    @Override
    public void runOneCycle() {
        // Will be fully implemented in Part 5
        System.out.println("runOneCycle method called for " + rideName + " - To be implemented in Part 5");
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