/**
 * Ride class - Represents amusement rides in the theme park
 * Contains basic ride information and operator details
 */
public class Ride {
    // Instance variables
    private String rideName;
    private String rideType; // "RollerCoaster", "WaterRide", "FamilyRide", etc.
    private int minHeight; // Minimum height requirement (cm)
    private Employee operator; // Employee responsible for operating the ride

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.minHeight = 120; // Default 120cm minimum height
        this.operator = null; // No operator initially
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, int minHeight) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.minHeight = minHeight;
        this.operator = null; // No operator initially
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

    // Check if ride is operational (has an operator)
    public boolean isOperational() {
        return operator != null && !operator.isAvailable();
    }

    // Check if visitor meets ride requirements
    public boolean canVisitorRide(Visitor visitor) {
        System.out.println("Checking if " + visitor.getName() + " can ride " + rideName);
        
        // Check if ride is operational
        if (!isOperational()) {
            System.out.println("Ride is not operational");
            return false;
        }
        
        // Check if visitor has valid pass
        if (!visitor.hasRidePass()) {
            System.out.println(visitor.getName() + " does not have a valid ride pass");
            return false;
        }
        
        // All requirements met (removed height check since getHeight() method doesn't exist)
        System.out.println(visitor.getName() + " meets all requirements for " + rideName);
        return true;
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
                '}';
    }
}