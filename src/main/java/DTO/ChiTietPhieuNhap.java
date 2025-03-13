package DTO;

public class WarehouseReceiptDetails {
    private int ID;
    private Integer receiptID; // Integer, allows NULL (foreign key)
    private Integer productID; // Integer, allows NULL (foreign key)
    private int quantity;
    private double cost; // double for DECIMAL(12,2)

    // Constructors
    public WarehouseReceiptDetails() {
    }

    // Constructor without ID (for new details)
    public WarehouseReceiptDetails(Integer receiptID, Integer productID, int quantity, double cost) {
        this.receiptID = receiptID;
        this.productID = productID;
        this.quantity = quantity;
        this.cost = cost;
    }

    // Constructor with ID (for existing details)
    public WarehouseReceiptDetails(int ID, Integer receiptID, Integer productID, int quantity, double cost) {
        this.ID = ID;
        this.receiptID = receiptID;
        this.productID = productID;
        this.quantity = quantity;
        this.cost = cost;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(Integer receiptID) {
        this.receiptID = receiptID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // toString() method
    @Override
    public String toString() {
        return "WarehouseReceiptDetails{" +
                "ID=" + ID +
                ", receiptID=" + receiptID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}