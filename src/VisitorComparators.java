import java.util.Comparator;

/**
 * VisitorComparators class - Contains all Visitor comparator implementations
 * Part 4B: Implement Comparator interface for different ways of sorting visitors
 */

/**
 * VisitorNameComparator class - Sorts by visitor name
 * Uses two instance variables for comparison: name and visitor ID
 */
class VisitorNameComparator implements Comparator<Visitor> {
    
    @Override
    public int compare(Visitor visitor1, Visitor visitor2) {
        if (visitor1 == null && visitor2 == null) return 0;
        if (visitor1 == null) return -1;
        if (visitor2 == null) return 1;
        
        // First sort by name (case-insensitive)
        int nameComparison = visitor1.getName().compareToIgnoreCase(visitor2.getName());
        
        // If names are the same, sort by visitor ID
        if (nameComparison == 0) {
            return visitor1.getVisitorId().compareTo(visitor2.getVisitorId());
        }
        
        return nameComparison;
    }
    
    @Override
    public String toString() {
        return "VisitorNameComparator - Sorts by name (alphabetical) and then by visitor ID";
    }
}

/**
 * VisitorAgeComparator class - Sorts by visitor age
 * Uses two instance variables for comparison: age and ticket type
 */
class VisitorAgeComparator implements Comparator<Visitor> {
    
    @Override
    public int compare(Visitor visitor1, Visitor visitor2) {
        if (visitor1 == null && visitor2 == null) return 0;
        if (visitor1 == null) return -1;
        if (visitor2 == null) return 1;
        
        // First sort by age (ascending)
        int ageComparison = Integer.compare(visitor1.getAge(), visitor2.getAge());
        
        // If ages are the same, sort by ticket type (SeasonPass > DayPass > Single)
        if (ageComparison == 0) {
            return getTicketPriority(visitor2) - getTicketPriority(visitor1); // Descending, better ticket types first
        }
        
        return ageComparison;
    }
    
    /**
     * Get ticket type priority (higher value means higher priority)
     */
    private int getTicketPriority(Visitor visitor) {
        switch (visitor.getTicketType()) {
            case "SeasonPass": return 3;
            case "DayPass": return 2;
            case "Single": return 1;
            default: return 0;
        }
    }
    
    @Override
    public String toString() {
        return "VisitorAgeComparator - Sorts by age (ascending) and then by ticket type (descending)";
    }
}

/**
 * VisitorTicketTypeComparator class - Sorts by ticket type
 * Uses two instance variables for comparison: ticket type and age
 */
class VisitorTicketTypeComparator implements Comparator<Visitor> {
    
    @Override
    public int compare(Visitor visitor1, Visitor visitor2) {
        if (visitor1 == null && visitor2 == null) return 0;
        if (visitor1 == null) return -1;
        if (visitor2 == null) return 1;
        
        // First sort by ticket type (SeasonPass > DayPass > Single)
        int ticketComparison = getTicketPriority(visitor2) - getTicketPriority(visitor1);
        
        // If ticket types are the same, sort by age (descending, older first)
        if (ticketComparison == 0) {
            return Integer.compare(visitor2.getAge(), visitor1.getAge());
        }
        
        return ticketComparison;
    }
    
    /**
     * Get ticket type priority (higher value means higher priority)
     */
    private int getTicketPriority(Visitor visitor) {
        switch (visitor.getTicketType()) {
            case "SeasonPass": return 3;
            case "DayPass": return 2;
            case "Single": return 1;
            default: return 0;
        }
    }
    
    @Override
    public String toString() {
        return "VisitorTicketTypeComparator - Sorts by ticket type (descending) and then by age (descending)";
    }
}