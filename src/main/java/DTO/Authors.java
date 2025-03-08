package DTO;

public class Authors {
    private int ID;
    private String fullName;
    private String penName;
    private Gender gender; // Using the enum
    private String nationality;
    private Status status; // Using the enum

    // Enum for gender
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    // Enum for status
    public enum Status {
        ACTIVE, INACTIVE
    }

    // Constructors
    public Authors() {
    }

    // Constructor without ID (for new authors)
    public Authors(String fullName, String penName, Gender gender, String nationality, Status status) {
        this.fullName = fullName;
        this.penName = penName;
        this.gender = gender;
        this.nationality = nationality;
        this.status = status;
    }

    // Constructor with ID (for existing authors)
    public Authors(int ID, String fullName, String penName, Gender gender, String nationality, Status status) {
        this.ID = ID;
        this.fullName = fullName;
        this.penName = penName;
        this.gender = gender;
        this.nationality = nationality;
        this.status = status;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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
        return "Authors{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", penName='" + penName + '\'' +
                ", gender=" + gender +
                ", nationality='" + nationality + '\'' +
                ", status=" + status +
                '}';
    }
}