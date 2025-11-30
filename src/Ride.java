/**
 * Ride class - representing an amusement ride in the theme park
 */
public class Ride {
    // Instance variables
    private String rideName;
    private String rideType;
    private int minHeightRequirement; // Minimum height requirement (cm)
    private Employee operator; // Employee responsible for operating this ride
    
    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown";
        this.minHeightRequirement = 0;
        this.operator = null;
    }
    
    // Constructor with parameters
    public Ride(String rideName, String rideType, int minHeightRequirement, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.minHeightRequirement = minHeightRequirement;
        this.operator = operator;
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
    
    public int getMinHeightRequirement() {
        return minHeightRequirement;
    }
    
    public void setMinHeightRequirement(int minHeightRequirement) {
        this.minHeightRequirement = minHeightRequirement;
    }
    
    public Employee getOperator() {
        return operator;
    }
    
    public void setOperator(Employee operator) {
        this.operator = operator;
    }
    
    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator assigned";
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", minHeightRequirement=" + minHeightRequirement +
                ", operator=" + operatorInfo +
                '}';
    }
}