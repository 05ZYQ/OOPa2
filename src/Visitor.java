/**
 * Visitor class - Inherits from Person class, represents theme park visitors
 * Contains visitor-specific attributes and methods
 */
public class Visitor extends Person {
    // Visitor-specific instance variables
    private String visitorId;
    private String ticketType; // "Single", "DayPass", "SeasonPass"
    private boolean hasRidePass;

    // Default constructor
    public Visitor() {
        super(); // Call parent class default constructor
        this.visitorId = "V0000";
        this.ticketType = "Single";
        this.hasRidePass = false;
    }

    // Constructor with parameters
    public Visitor(String name, int age, String email, String visitorId, String ticketType) {
        super(name, age, email); // Call parent class constructor with parameters
        this.visitorId = visitorId;
        this.ticketType = ticketType;
        this.hasRidePass = ticketType.equals("DayPass") || ticketType.equals("SeasonPass");
    }

    // Getter and Setter methods
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
        // Update ride pass status
        this.hasRidePass = ticketType.equals("DayPass") || ticketType.equals("SeasonPass");
    }

    public boolean hasRidePass() {
        return hasRidePass;
    }

    public void setHasRidePass(boolean hasRidePass) {
        this.hasRidePass = hasRidePass;
    }

    // Implement abstract method
    @Override
    public String introduce() {
        return "Hi, I'm " + getName() + ", a visitor with " + ticketType + " ticket. My visitor ID is " + visitorId + ".";
    }

    // Visitor-specific method
    public void purchaseTicket(String ticketType) {
        this.ticketType = ticketType;
        this.hasRidePass = ticketType.equals("DayPass") || ticketType.equals("SeasonPass");
        System.out.println("Visitor " + getName() + " purchased " + ticketType + " ticket");
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", visitorId='" + visitorId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", hasRidePass=" + hasRidePass +
                '}';
    }
}