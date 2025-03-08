package DTO;

import java.sql.Date;

public class Promotions {
    private int ID;
    private String name;
    private Date startDate;
    private Date endDate;
    private int discountPercentage;
    private Status status; // Using enum

    // Enum for status
    public enum Status {
        ACTIVE, INACTIVE, SCHEDULED
    }

    // Constructors
    public Promotions() {
    }

    // Constructor without ID (for new promotions)
    public Promotions(String name, Date startDate, Date endDate, int discountPercentage, Status status) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
        this.status = status;
    }

    // Constructor with ID (for existing promotions)
    public Promotions(int ID, String name, Date startDate, Date endDate, int discountPercentage, Status status) {
        this.ID = ID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
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
        return "Promotions{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", discountPercentage=" + discountPercentage +
                ", status=" + status +
                '}';
    }
}