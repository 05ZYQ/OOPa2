import java.io.FileWriter;
import java.io.IOException;

/**
 * Ride class - Represents amusement park ride
 * Implements RideInterface
 * Part 6: Add file export functionality
 */
public class Ride implements RideInterface {
    // ... (existing code remains the same) ...

    // Part 6: File export method
    /**
     * Export ride history to a CSV file
     * @param filename The name of the file to export to
     */
    public void exportRideHistory(String filename) {
        if (rideHistory.isEmpty()) {
            System.out.println("Info: No ride history to export for " + rideName);
            return;
        }

        try (FileWriter writer = new FileWriter(filename)) {
            for (Visitor visitor : rideHistory) {
                // Format: name,age,email,visitorId,ticketType
                String line = String.format("%s,%d,%s,%s,%s%n",
                        visitor.getName(),
                        visitor.getAge(),
                        visitor.getEmail(),
                        visitor.getVisitorId(),
                        visitor.getTicketType());
                writer.write(line);
            }
            System.out.println("Success: Ride history exported to " + filename);
            System.out.println("  Total visitors exported: " + rideHistory.size());
        } catch (IOException e) {
            System.out.println("Error: Failed to export ride history to " + filename);
            System.out.println("  Exception: " + e.getMessage());
        }
    }

    // ... (existing code continues) ...
}