import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

/**
 * Ride class - Represents amusement rides in the theme park
 * Implements RideInterface
 * Part 4: Enhanced history management and sorting functionality
 */
public class Ride implements RideInterface {
    // Instance variables
    private String rideName;
    private String rideType;
    private int minHeight;
    private Employee operator;
    
    // Part 3: Waiting queue
    private Queue<Visitor> waitingQueue;
    
    // Part 4: Ride history - Using LinkedList
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.minHeight = 120;
        this.operator = null;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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
            operator.setAvailable(false);
            System.out.println("Employee " + operator.getName() + " assigned to operate " + rideName);
        }
    }

    public Queue<Visitor> getWaitingQueue() {
        return waitingQueue;
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    public boolean isOperational() {
        return operator != null && !operator.isAvailable();
    }

    public boolean canVisitorRide(Visitor visitor) {
        if (visitor == null) {
            System.out.println("✗ Failure: Cannot check null visitor");
            return false;
        }
        
        boolean canRide = visitor.hasRidePass() && visitor.getAge() >= 10;
        System.out.println("Checking if " + visitor.getName() + " can ride " + rideName + ": " + 
                          (canRide ? "✓ Eligible" : "✗ Not eligible"));
        return canRide;
    }

    // ========== RideInterface implementation ==========

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            if (canVisitorRide(visitor)) {
                waitingQueue.add(visitor);
                System.out.println("✓ Success: Visitor " + visitor.getName() + " added to waiting queue for " + rideName);
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
            // Check if already in history
            if (!rideHistory.contains(visitor)) {
                rideHistory.add(visitor);
                System.out.println("✓ Success: Visitor " + visitor.getName() + " added to ride history of " + rideName);
            } else {
                System.out.println("ℹ Info: Visitor " + visitor.getName() + " is already in ride history");
            }
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
            System.out.println("=== Ride History for " + rideName + " ===");
            System.out.println("Total visitors in history: " + rideHistory.size());
            System.out.println("History (in order of riding):");
            
            // Part 4A: Use Iterator to traverse (required as per instructions)
            Iterator<Visitor> iterator = rideHistory.iterator();
            int count = 1;
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println("  " + count + ". " + visitor.getName() + 
                                 " (ID: " + visitor.getVisitorId() + 
                                 ", Age: " + visitor.getAge() + 
                                 ", Ticket: " + visitor.getTicketType() + ")");
                count++;
            }
            System.out.println("=== End of History ===");
        }
    }

    @Override
    public void runOneCycle() {
        // To be fully implemented in Part 5
        System.out.println("runOneCycle method called for " + rideName + " - To be implemented in Part 5");
    }

    // Part 3: Queue helper methods
    public int getQueueSize() {
        return waitingQueue.size();
    }
    
    public Visitor peekQueue() {
        return waitingQueue.peek();
    }
    
    public boolean isQueueEmpty() {
        return waitingQueue.isEmpty();
    }
    
    public void clearQueue() {
        waitingQueue.clear();
        System.out.println("Waiting queue for " + rideName + " has been cleared");
    }

    // Part 4B: Sorting methods
    /**
     * Sort ride history using a Comparator
     * @param comparator Comparator object
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
            System.out.println("✓ Success: Ride history sorted using custom comparator");
        } else {
            System.out.println("ℹ Info: Not enough visitors in history to sort");
        }
    }
    
    /**
     * Sort history by name (convenience method)
     */
    public void sortHistoryByName() {
        sortRideHistory(new VisitorNameComparator());
    }
    
    /**
     * Sort history by age (convenience method)
     */
    public void sortHistoryByAge() {
        sortRideHistory(new VisitorAgeComparator());
    }
    
    /**
     * Sort history by ticket type (convenience method)
     */
    public void sortHistoryByTicketType() {
        sortRideHistory(new VisitorTicketTypeComparator());
    }

    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator assigned";
        return "Ride{" +
                "rideName='" + rideName + "'" +
                ", rideType='" + rideType + "'" +
                ", minHeight=" + minHeight +
                ", operator=" + operatorInfo +
                ", isOperational=" + isOperational() +
                ", waitingQueueSize=" + waitingQueue.size() +
                ", historySize=" + rideHistory.size() +
                '}';
    }
}