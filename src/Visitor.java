/**
 * Visitor class - extends Person, representing theme park visitor
 */
public class Visitor extends Person {
    // Visitor-specific instance variables
    private String ticketNumber;
    private boolean hasSeasonPass;
    
    // Default constructor
    public Visitor() {
        super(); // Call parent class default constructor
        this.ticketNumber = "T0000";
        this.hasSeasonPass = false;
    }
    
    // Constructor with parameters
    public Visitor(String name, int age, String gender, String ticketNumber, boolean hasSeasonPass) {
        super(name, age, gender); // Call parent class constructor
        this.ticketNumber = ticketNumber;
        this.hasSeasonPass = hasSeasonPass;
    }
    
    // Getter and Setter methods
    public String getTicketNumber() {
        return ticketNumber;
    }
    
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
    public boolean hasSeasonPass() {
        return hasSeasonPass;
    }
    
    public void setHasSeasonPass(boolean hasSeasonPass) {
        this.hasSeasonPass = hasSeasonPass;
    }
    
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", hasSeasonPass=" + hasSeasonPass +
                '}';
    }
}