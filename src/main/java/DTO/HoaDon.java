package DTO;

import java.sql.Date;

public class SalesReceipts {
    private int ID;
    private Integer sellerID; // Integer, allows NULL (foreign key)
    private Date saleDate;
    private double totalAmount; // double for DECIMAL(12,2)
    private Status status;     // Using enum

    // Enum for status
    public enum Status {
        PENDING, COMPLETED, CANCELLED
    }

    // Constructors
    public SalesReceipts() {
    }

    // Constructor without ID (for new receipts)
    public SalesReceipts(Integer sellerID, Date saleDate, double totalAmount, Status status) {
        this.sellerID = sellerID;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Constructor with ID (for existing receipts)
    public SalesReceipts(int ID, Integer sellerID, Date saleDate, double totalAmount, Status status) {
        this.ID = ID;
        this.sellerID = sellerID;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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
        return "SalesReceipts{" +
                "ID=" + ID +
                ", sellerID=" + sellerID +
                ", saleDate=" + saleDate +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }
}