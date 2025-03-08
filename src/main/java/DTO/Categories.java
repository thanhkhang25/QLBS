package DTO;

public class Categories {
    private int ID;
    private String name;
    private Status status; // Using the enum

    // Enum for status
    public enum Status {
        ACTIVE, INACTIVE
    }

    // Constructors
    public Categories() {
    }

    // Constructor without ID (for new categories)
    public Categories(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    // Constructor with ID (for existing categories)
    public Categories(int ID, String name, Status status) {
        this.ID = ID;
        this.name = name;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // toString() method
    @Override
    public String toString() {
        return "Categories{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}