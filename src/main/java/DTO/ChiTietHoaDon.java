package DTO;

public class SalesReceiptDetails {
    private int ID;
    private Integer receiptID;  // Integer, allows NULL (foreign key)
    private Integer productID;  // Integer, allows NULL (foreign key)
    private int quantity;
    private double salePrice; // double for DECIMAL(12,2)

    // Constructors
    public SalesReceiptDetails() {
    }

    // Constructor without ID (for new details)
    public SalesReceiptDetails(Integer receiptID, Integer productID, int quantity, double salePrice) {
        this.receiptID = receiptID;
        this.productID = productID;
        this.quantity = quantity;
        this.salePrice = salePrice;
    }

    // Constructor with ID (for existing details)
    public SalesReceiptDetails(int ID, Integer receiptID, Integer productID, int quantity, double salePrice) {
        this.ID = ID;
        this.receiptID = receiptID;
        this.productID = productID;
        this.quantity = quantity;
        this.salePrice = salePrice;
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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    // toString() method
    @Override
    public String toString() {
        return "SalesReceiptDetails{" +
                "ID=" + ID +
                ", receiptID=" + receiptID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", salePrice=" + salePrice +
                '}';
    }
}