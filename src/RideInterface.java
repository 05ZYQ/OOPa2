/**
 * RideInterface interface - Defines methods that rides must implement
 * Part 2: Create interface to standardize Ride class behavior
 */
public interface RideInterface {

    /**
     * Add visitor to waiting queue
     * @param visitor The visitor to add
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Remove visitor from waiting queue
     */
    void removeVisitorFromQueue();

    /**
     * Print list of visitors in waiting queue
     */
    void printQueue();

    /**
     * Add visitor to ride history
     * @param visitor The visitor to add
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Check if visitor is in ride history
     * @param visitor The visitor to check
     * @return true if exists, false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Return the number of visitors in ride history
     * @return Number of visitors
     */
    int numberOfVisitors();

    /**
     * Print ride history
     */
    void printRideHistory();

    /**
     * Run one cycle of the ride
     */
    void runOneCycle();
}