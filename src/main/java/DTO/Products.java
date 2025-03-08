package DTO;

import java.math.BigDecimal;

public class Products {
    private int ID;
    private String name;
    private Integer authorID;  // Integer, allows NULL (foreign key)
    private Integer categoryID; // Integer, allows NULL (foreign key)
    private Integer publisherID; // Integer, allows NULL (foreign key)
    private String language;
    private String image;      //  Consider using a URL or File object
    private double price;      // double for DECIMAL
    private double cost;       // double for DECIMAL
    private int stockQuantity;
    private String description;
    private Status status;     // Using enum

    // Enum for status
    public enum Status {
        AVAILABLE, OUT_OF_STOCK, DISCONTINUED
    }

    // Constructors
    public Products() {
    }

    // Constructor without ID (for new products)
    public Products(String name, Integer authorID, Integer categoryID, Integer publisherID,
                    String language, String image, double price, double cost,
                    int stockQuantity, String description, Status status) {
        this.name = name;
        this.authorID = authorID;
        this.categoryID = categoryID;
        this.publisherID = publisherID;
        this.language = language;
        this.image = image;
        this.price = price;
        this.cost = cost;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.status = status;
    }

    // Constructor with ID (for existing products)
    public Products(int ID, String name, Integer authorID, Integer categoryID, Integer publisherID,
                    String language, String image, double price, double cost,
                    int stockQuantity, String description, Status status) {
        this.ID = ID;
        this.name = name;
        this.authorID = authorID;
        this.categoryID = categoryID;
        this.publisherID = publisherID;
        this.language = language;
        this.image = image;
        this.price = price;
        this.cost = cost;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters (all fields)

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

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Integer publisherID) {
        this.publisherID = publisherID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image){
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public void setStatus(Status status){
        this.status = status;
    }

    // toString() method
    @Override
    public String toString() {
        return "Products{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", authorID=" + authorID +
                ", categoryID=" + categoryID +
                ", publisherID=" + publisherID +
                ", language='" + language + '\'' +
                ", image ='" + image + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}