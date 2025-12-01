import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Ride class - Represents amusement park ride
 * Implements RideInterface
 * Part 7: Add file import functionality
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
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
            System.out.println("Success: Ride history sorted using custom comparator");
        } else {
            System.out.println("Info: Not enough visitors in history to sort");
        }
    }

    public void sortHistoryByName() {
        sortRideHistory(new VisitorNameComparator());
    }

    public void sortHistoryByAge() {
        sortRideHistory(new VisitorAgeComparator());
    }

    public void sortHistoryByTicketType() {
        sortRideHistory(new VisitorTicketTypeComparator());
    }

    // Part 5: New helper methods
    public void printCycleInfo() {
        System.out.println("=== Ride Cycle Information for " + rideName + " ===");
        System.out.println("Max riders per cycle: " + maxRider);
        System.out.println("Total cycles run: " + numOfCycles);
        System.out.println("Current queue size: " + waitingQueue.size());
        System.out.println("Total visitors in history: " + rideHistory.size());
        System.out.println("Operator: " + (operator != null ? operator.getName() : "None"));
        System.out.println("=== End of Cycle Information ===");
    }

    public void resetCycles() {
        this.numOfCycles = 0;
        System.out.println("Cycle count for " + rideName + " has been reset to 0");
    }

    // Part 6: File export methods
    public boolean exportRideHistory(String filename) {
        if (rideHistory.isEmpty()) {
            System.out.println("Error: No ride history to export for " + rideName);
            return false;
        }

        PrintWriter writer = null;
        try {
            // Create PrintWriter with FileWriter
            writer = new PrintWriter(new FileWriter(filename));

            // Write header
            writer.println("Ride Name,Visitor Name,Visitor ID,Age,Email,Ticket Type,Ride Type,Min Height");

            // Write each visitor's details
            for (Visitor visitor : rideHistory) {
                String line = String.format("%s,%s,%s,%d,%s,%s,%s,%d",
                        rideName,
                        visitor.getName(),
                        visitor.getVisitorId(),
                        visitor.getAge(),
                        visitor.getEmail(),
                        visitor.getTicketType(),
                        rideType,
                        minHeight
                );
                writer.println(line);
            }

            System.out.println("Success: Ride history exported to file: " + filename);
            System.out.println("  Total visitors exported: " + rideHistory.size());
            System.out.println("  File format: CSV (Comma Separated Values)");
            return true;

        } catch (IOException e) {
            System.out.println("Error: Failed to write to file: " + filename);
            System.out.println("  Exception: " + e.getMessage());
            return false;
        } finally {
            // Always close the writer
            if (writer != null) {
                writer.close();
            }
        }
    }

    public boolean exportRideHistory() {
        String filename = rideName.replaceAll("\\s+", "_") + "_history.csv";
        return exportRideHistory(filename);
    }

    public boolean exportRideHistory(String filename, boolean includeRideInfo) {
        if (rideHistory.isEmpty()) {
            System.out.println("Error: No ride history to export for " + rideName);
            return false;
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename));

            if (includeRideInfo) {
                // Write header with ride information
                writer.println("Ride Name,Ride Type,Min Height,Visitor Name,Visitor ID,Age,Email,Ticket Type");

                // Write each visitor's details with ride info
                for (Visitor visitor : rideHistory) {
                    String line = String.format("%s,%s,%d,%s,%s,%d,%s,%s",
                            rideName,
                            rideType,
                            minHeight,
                            visitor.getName(),
                            visitor.getVisitorId(),
                            visitor.getAge(),
                            visitor.getEmail(),
                            visitor.getTicketType()
                    );
                    writer.println(line);
                }
            } else {
                // Write header without ride information
                writer.println("Visitor Name,Visitor ID,Age,Email,Ticket Type");

                // Write each visitor's details
                for (Visitor visitor : rideHistory) {
                    String line = String.format("%s,%s,%d,%s,%s",
                            visitor.getName(),
                            visitor.getVisitorId(),
                            visitor.getAge(),
                            visitor.getEmail(),
                            visitor.getTicketType()
                    );
                    writer.println(line);
                }
            }

            System.out.println("Success: Ride history exported to file: " + filename);
            System.out.println("  Total visitors exported: " + rideHistory.size());
            System.out.println("  Ride information included: " + includeRideInfo);
            return true;

        } catch (IOException e) {
            System.out.println("Error: Failed to write to file: " + filename);
            System.out.println("  Exception: " + e.getMessage());
            return false;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    // Part 7: File import method
    /**
     * Import ride history from a CSV file
     * @param filename The name of the file to read
     * @return Number of visitors successfully imported, or -1 if error occurred
     */
    public int importRideHistory(String filename) {
        BufferedReader reader = null;
        int visitorsImported = 0;
        int lineNumber = 0;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            System.out.println("Starting import from file: " + filename);

            // Read file line by line
            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Skip header line (line 1)
                if (lineNumber == 1) {
                    System.out.println("Found header: " + line);
                    continue;
                }

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Parse the CSV line
                try {
                    Visitor visitor = parseVisitorFromCSV(line);
                    if (visitor != null) {
                        // Add visitor to ride history
                        if (addVisitorToHistoryWithoutMessage(visitor)) {
                            visitorsImported++;
                            System.out.println("  Line " + lineNumber + ": Successfully imported " + visitor.getName());
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("  Line " + lineNumber + ": Error - " + e.getMessage());
                    System.out.println("    Line content: " + line);
                }
            }

            System.out.println("Import completed: " + visitorsImported + " visitors imported from " + filename);
            return visitorsImported;

        } catch (IOException e) {
            System.out.println("Error: Failed to read file: " + filename);
            System.out.println("  Exception: " + e.getMessage());
            return -1;
        } finally {
            // Always close the reader
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Warning: Failed to close file reader");
                }
            }
        }
    }

    /**
     * Parse a Visitor object from a CSV line
     * @param csvLine CSV line containing visitor data
     * @return Visitor object, or null if parsing failed
     * @throws IllegalArgumentException if CSV format is invalid
     */
    private Visitor parseVisitorFromCSV(String csvLine) throws IllegalArgumentException {
        // Split the CSV line by comma
        String[] parts = csvLine.split(",");

        // Check for minimum required fields
        if (parts.length < 8) {
            throw new IllegalArgumentException("Invalid CSV format: expected 8 fields, found " + parts.length);
        }

        try {
            // Extract fields from CSV (matching export format)
            String rideName = parts[0].trim();
            String visitorName = parts[1].trim();
            String visitorId = parts[2].trim();
            int age = Integer.parseInt(parts[3].trim());
            String email = parts[4].trim();
            String ticketType = parts[5].trim();
            String rideType = parts[6].trim();
            int minHeight = Integer.parseInt(parts[7].trim());

            // Validate data
            if (visitorName.isEmpty() || visitorId.isEmpty() || email.isEmpty()) {
                throw new IllegalArgumentException("Required fields are empty");
            }

            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Invalid age: " + age);
            }

            if (!ticketType.equals("Single") && !ticketType.equals("DayPass") && !ticketType.equals("SeasonPass")) {
                throw new IllegalArgumentException("Invalid ticket type: " + ticketType);
            }

            // Create and return Visitor object
            return new Visitor(visitorName, age, email, visitorId, ticketType);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in CSV line");
        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing visitor data: " + e.getMessage());
        }
    }

    /**
     * Add visitor to history without printing success message (for import)
     * @param visitor Visitor to add
     * @return true if added successfully, false otherwise
     */
    private boolean addVisitorToHistoryWithoutMessage(Visitor visitor) {
        if (visitor != null && !rideHistory.contains(visitor)) {
            rideHistory.add(visitor);
            return true;
        }
        return false;
    }

    /**
     * Import ride history with flexible format (handles both with and without ride info)
     * @param filename The name of the file to read
     * @param hasRideInfo Whether the file includes ride information
     * @return Number of visitors successfully imported, or -1 if error occurred
     */
    public int importRideHistory(String filename, boolean hasRideInfo) {
        BufferedReader reader = null;
        int visitorsImported = 0;
        int lineNumber = 0;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            System.out.println("Starting import from file: " + filename);
            System.out.println("Ride information in file: " + (hasRideInfo ? "Yes" : "No"));

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Skip header line
                if (lineNumber == 1) {
                    System.out.println("Found header: " + line);
                    continue;
                }

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    Visitor visitor;
                    if (hasRideInfo) {
                        // Parse with ride information
                        visitor = parseVisitorFromCSVWithRideInfo(line);
                    } else {
                        // Parse without ride information
                        visitor = parseVisitorFromCSVWithoutRideInfo(line);
                    }

                    if (visitor != null) {
                        if (addVisitorToHistoryWithoutMessage(visitor)) {
                            visitorsImported++;
                            System.out.println("  Line " + lineNumber + ": Imported " + visitor.getName());
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("  Line " + lineNumber + ": Error - " + e.getMessage());
                }
            }

            System.out.println("Import completed: " + visitorsImported + " visitors imported");
            return visitorsImported;

        } catch (IOException e) {
            System.out.println("Error: Failed to read file: " + filename);
            System.out.println("  Exception: " + e.getMessage());
            return -1;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Warning: Failed to close file reader");
                }
            }
        }
    }

    /**
     * Parse visitor from CSV line with ride information
     */
    private Visitor parseVisitorFromCSVWithRideInfo(String csvLine) throws IllegalArgumentException {
        String[] parts = csvLine.split(",");

        if (parts.length < 8) {
            throw new IllegalArgumentException("Invalid CSV format with ride info");
        }

        try {
            // Format: Ride Name,Ride Type,Min Height,Visitor Name,Visitor ID,Age,Email,Ticket Type
            String visitorName = parts[3].trim();
            String visitorId = parts[4].trim();
            int age = Integer.parseInt(parts[5].trim());
            String email = parts[6].trim();
            String ticketType = parts[7].trim();

            return new Visitor(visitorName, age, email, visitorId, ticketType);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format");
        }
    }

    /**
     * Parse visitor from CSV line without ride information
     */
    private Visitor parseVisitorFromCSVWithoutRideInfo(String csvLine) throws IllegalArgumentException {
        String[] parts = csvLine.split(",");

        if (parts.length < 5) {
            throw new IllegalArgumentException("Invalid CSV format without ride info");
        }

        try {
            // Format: Visitor Name,Visitor ID,Age,Email,Ticket Type
            String visitorName = parts[0].trim();
            String visitorId = parts[1].trim();
            int age = Integer.parseInt(parts[2].trim());
            String email = parts[3].trim();
            String ticketType = parts[4].trim();

            return new Visitor(visitorName, age, email, visitorId, ticketType);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format");
        }
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