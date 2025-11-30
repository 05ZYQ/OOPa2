/**
 * Employee class - Extends Person class, represents theme park employees
 * Contains employee-specific properties and methods
 */
public class Employee extends Person {
    // Employee-specific instance variables
    private String employeeId;
    private String department;
    private boolean isAvailable;

    // Default constructor
    public Employee() {
        super(); // Call parent class default constructor
        this.employeeId = "E0000";
        this.department = "General";
        this.isAvailable = true;
    }

    // Parameterized constructor
    public Employee(String name, int age, String email, String employeeId, String department) {
        super(name, age, email); // Call parent class parameterized constructor
        this.employeeId = employeeId;
        this.department = department;
        this.isAvailable = true;
    }

    // Getter and Setter methods
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Employee-specific methods
    public void operateRide(Ride ride) {
        if (isAvailable) {
            System.out.println("Employee " + getName() + " is operating ride: " + ride.getRideName());
        } else {
            System.out.println("Employee " + getName() + " is not available");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + "'" +
                ", age=" + getAge() +
                ", email='" + getEmail() + "'" +
                ", employeeId='" + employeeId + "'" +
                ", department='" + department + "'" +
                ", isAvailable=" + isAvailable +
                '}';
    }
}