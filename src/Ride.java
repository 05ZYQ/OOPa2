import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

/**
 * Ride class - Represents amusement park ride
 * Implements RideInterface
 * Part 5: Complete ride cycle functionality
 */
public class Ride implements RideInterface {
    // Instance variables
    private String rideName;
    private String rideType;
    private int minHeight;
    private Employee operator;
    
    // Part 3: Waiting queue
    private Queue<Visitor> waitingQueue;
    
    // Part 4: Ride history
    private LinkedList<Visitor> rideHistory;
    
    // Part 5: New properties
    private int maxRider;      // Maximum visitors per cycle
    private int numOfCycles;   // Number of cycles run

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.minHeight = 120;
        this.operator = null;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;     // Default: 2 visitors per cycle
        this.numOfCycles = 0;  // Initial cycle count is 0
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, int minHeight) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.minHeight = minHeight;
        this.operator = null;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;     // Default: 2 visitors per cycle
        this.numOfCycles = 0;  // Initial cycle count is 0
    }

    // Constructor with maxRider parameter
    public Ride(String rideName, String rideType, int minHeight, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.minHeight = minHeight;
        this.operator = null;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = Math.max(1, maxRider); // Ensure at least 1 visitor
        this.numOfCycles = 0;
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
            System.out.println("Error: Minimum height cannot be negative");
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

    // Part 5: maxRider getter and setter
    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider >= 1) {
            this.maxRider = maxRider;
            System.out.println("Max riders for " + rideName + " set to: " + maxRider);
        } else {
            System.out.println("Error: Max riders must be at least 1");
        }
    }

    // Part 5: numOfCycles getter
    public int getNumOfCycles() {
        return numOfCycles;
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
            System.out.println("Error: Cannot check null visitor");
            return false;
        }
        
        boolean canRide = visitor.hasRidePass() && visitor.getAge() >= 10;
        System.out.println("Checking if " + visitor.getName() + " can ride " + rideName + ": " + 
                          (canRide ? "Eligible" : "Not eligible"));
        return canRide;
    }

    // ========== RideInterface Method Implementations ==========

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            if (canVisitorRide(visitor)) {
                waitingQueue.add(visitor);
                System.out.println("Success: Visitor " + visitor.getName() + " added to waiting queue for " + rideName);
                System.out.println("  Current queue position: " + waitingQueue.size());
            } else {
                System.out.println("Error: Visitor " + visitor.getName() + " is not eligible to ride " + rideName);
            }
        } else {
            System.out.println("Error: Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removedVisitor = waitingQueue.poll();
            System.out.println("Success: Visitor " + removedVisitor.getName() + " removed from waiting queue of " + rideName);
            System.out.println("  Visitors remaining in queue: " + waitingQueue.size());
        } else {
            System.out.println("Error: Waiting queue for " + rideName + " is empty, cannot remove visitor");
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
                System.out.println("Success: Visitor " + visitor.getName() + " added to ride history of " + rideName);
            } else {
                System.out.println("Info: Visitor " + visitor.getName() + " is already in ride history");
            }
        } else {
            System.out.println("Error: Cannot add null visitor to history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor != null) {
            boolean found = rideHistory.contains(visitor);
            System.out.println("Checking history: Visitor " + visitor.getName() + 
                             (found ? " found" : " not found") + " in ride history of " + rideName);
            return found;
        } else {
            System.out.println("Error: Cannot check null visitor in history");
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
            System.out.println("Total cycles run: " + numOfCycles);
            System.out.println("History (in order of riding):");
            
            // Use Iterator as required
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
        System.out.println("\n=== Attempting to run one cycle for " + rideName + " ===");
        
        // Check if operator is assigned
        if (operator == null) {
            System.out.println("Error: Cannot run ride - No operator assigned to " + rideName);
            return;
        }
        
        // Check if operator is available
        if (operator.isAvailable()) {
            System.out.println("Error: Cannot run ride - Operator " + operator.getName() + " is not available");
            return;
        }
        
        // Check if waiting queue is empty
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: Cannot run ride - No visitors in waiting queue for " + rideName);
            return;
        }
        
        // Calculate number of visitors for this cycle
        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        System.out.println("Starting ride cycle: " + ridersThisCycle + " visitor(s) will ride");
        System.out.println("  Operator: " + operator.getName());
        System.out.println("  Max capacity per cycle: " + maxRider);
        System.out.println("  Visitors in queue: " + waitingQueue.size());
        
        // Process visitors for this cycle
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor ridingVisitor = waitingQueue.poll();
            if (ridingVisitor != null) {
                // Remove from queue and add to history
                rideHistory.add(ridingVisitor);
                System.out.println("  " + ridingVisitor.getName() + " enjoyed the ride and added to history");
            }
        }
        
        // Increase cycle count
        numOfCycles++;
        System.out.println("Success: Ride cycle completed!");
        System.out.println("  Total cycles run: " + numOfCycles);
        System.out.println("  Visitors remaining in queue: " + waitingQueue.size());
        System.out.println("  Total visitors in history: " + rideHistory.size());
        System.out.println("=== End of Ride Cycle ===");
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
     * Sort ride history using Comparator
     * @param comparator Comparator object
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
            System.out.println("Success: Ride history sorted using custom comparator");
        } else {
            System.out.println("Info: Not enough visitors in history to sort");
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
    
    // Part 5: New helper methods
    /**
     * Get current cycle information
     */
    public void printCycleInfo() {
        System.out.println("=== Ride Cycle Information for " + rideName + " ===");
        System.out.println("Max riders per cycle: " + maxRider);
        System.out.println("Total cycles run: " + numOfCycles);
        System.out.println("Current queue size: " + waitingQueue.size());
        System.out.println("Total visitors in history: " + rideHistory.size());
        System.out.println("Operator: " + (operator != null ? operator.getName() : "None"));
        System.out.println("=== End of Cycle Information ===");
    }
    
    /**
     * Reset cycle count (for testing)
     */
    public void resetCycles() {
        this.numOfCycles = 0;
        System.out.println("Cycle count for " + rideName + " has been reset to 0");
    }

    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator assigned";
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", minHeight=" + minHeight +
                ", operator=" + operatorInfo +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                ", waitingQueueSize=" + waitingQueue.size() +
                ", historySize=" + rideHistory.size() +
                '}';
    }
}