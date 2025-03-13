package DTO;

import java.sql.Date;

public class WarehouseReceipts {
    private int ID;
    private Integer supplierID;  // Integer, allows NULL (foreign key)
    private Integer enteredBy;    // Integer, allows NULL (foreign key)
    private Date entryDate;
    private Status status;      // Using enum
    private double totalAmount; // double for DECIMAL(12,2)

    // Enum for status
    public enum Status {
        PENDING, COMPLETED, CANCELLED
    }

    // Constructors
    public WarehouseReceipts() {
    }

    // Constructor without ID (for new receipts)
    public WarehouseReceipts(Integer supplierID, Integer enteredBy, Date entryDate, Status status, double totalAmount) {
        this.supplierID = supplierID;
        this.enteredBy = enteredBy;
        this.entryDate = entryDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Constructor with ID (for existing receipts)
    public WarehouseReceipts(int ID, Integer supplierID, Integer enteredBy, Date entryDate, Status status, double totalAmount) {
        this.ID = ID;
        this.supplierID = supplierID;
        this.enteredBy = enteredBy;
        this.entryDate = entryDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Integer getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Integer enteredBy) {
        this.enteredBy = enteredBy;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // toString() method
    @Override
    public String toString() {
        return "WarehouseReceipts{" +
                "ID=" + ID +
                ", supplierID=" + supplierID +
                ", enteredBy=" + enteredBy +
                ", entryDate=" + entryDate +
                ", status=" + status +
                ", totalAmount=" + totalAmount +
                '}';
    }
}