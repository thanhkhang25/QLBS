package DTO;

public class Suppliers {
    private int ID;
    private String name;
    private String address;
    private String phoneNumber;
    private Status status; // Using the enum

    // Enum for status
    public enum Status {
        ACTIVE, INACTIVE
    }

    // Constructors
    public Suppliers() {
    }

    // Constructor without ID (for new suppliers)
    public Suppliers(String name, String address, String phoneNumber, Status status) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    // Constructor with ID (for existing suppliers)
    public Suppliers(int ID, String name, String address, String phoneNumber, Status status) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "Suppliers{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                '}';
    }
}