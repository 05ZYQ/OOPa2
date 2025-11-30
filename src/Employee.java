/**
 * Employee class - extends Person, representing theme park employee
 */
public class Employee extends Person {
    // Employee-specific instance variables
    private String employeeId;
    private String department;
    
    // Default constructor
    public Employee() {
        super(); // Call parent class default constructor
        this.employeeId = "E0000";
        this.department = "Unknown";
    }
    
    // Constructor with parameters
    public Employee(String name, int age, String gender, String employeeId, String department) {
        super(name, age, gender); // Call parent class constructor
        this.employeeId = employeeId;
        this.department = department;
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
    
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}