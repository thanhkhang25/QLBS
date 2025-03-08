package DTO;

public class PromotionDetails {
    private Integer promotionID; // Integer, allows NULL (foreign key)
    private Integer productID;   // Integer, allows NULL (foreign key)

    // Constructors

    // Default constructor (important for some frameworks)
    public PromotionDetails() {
    }

    // Constructor with both IDs
    public PromotionDetails(Integer promotionID, Integer productID) {
        this.promotionID = promotionID;
        this.productID = productID;
    }

    // Getters and Setters
    public Integer getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(Integer promotionID) {
        this.promotionID = promotionID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    // toString() method
    @Override
    public String toString() {
        return "PromotionDetails{" +
                "promotionID=" + promotionID +
                ", productID=" + productID +
                '}';
    }

    // hashCode() and equals() methods (VERY IMPORTANT)
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((promotionID == null) ? 0 : promotionID.hashCode());
        result = prime * result + ((productID == null) ? 0 : productID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PromotionDetails other = (PromotionDetails) obj;
        if (promotionID == null) {
            if (other.promotionID != null)
                return false;
        } else if (!promotionID.equals(other.promotionID))
            return false;
        if (productID == null) {
            if (other.productID != null)
                return false;
        } else if (!productID.equals(other.productID))
            return false;
        return true;
    }
}