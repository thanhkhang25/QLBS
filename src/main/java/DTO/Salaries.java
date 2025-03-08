package DTO;

public class Salaries {
    private int ID;
    private Integer employeeID; // Integer for foreign key, allows null
    private int month;
    private int year;
    private double netSalary; // double for DECIMAL(12,2)
    private Status status; // Using the enum

    // Enum for status
    public enum Status {
        UNPAID, PAID, PARTIALLY_PAID
    }

    // Constructors
    public Salaries() {
    }

    // Constructor without ID (for new salary records)
    public Salaries(Integer employeeID, int month, int year, double netSalary, Status status) {
        this.employeeID = employeeID;
        this.month = month;
        this.year = year;
        this.netSalary = netSalary;
        this.status = status;
    }

    // Constructor with ID (for existing salary records)
    public Salaries(int ID, Integer employeeID, int month, int year, double netSalary, Status status) {
        this.ID = ID;
        this.employeeID = employeeID;
        this.month = month;
        this.year = year;
        this.netSalary = netSalary;
        this.status = status;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // toString() method
    @Override
    public String toString() {
        return "Salaries{" +
                "ID=" + ID +
                ", employeeID=" + employeeID +
                ", month=" + month +
                ", year=" + year +
                ", netSalary=" + netSalary +
                ", status=" + status + // Prints the enum value directly
                '}';
    }
}