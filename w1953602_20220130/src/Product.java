// Product abstract class representing a general product in the shopping system
import java.io.Serializable;

public abstract class Product implements Serializable {

    // Fields to store product information
    private String productID;
    private String productName;
    private int noAvailableItems;
    private double productPrice;
    private String category;
    private String info;
    private String uniqueValue;
    private int quantity;

    // Constructor to initialize a product with essential information
    public Product(String productID, String productName, int noAvailableItems, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.noAvailableItems = noAvailableItems;
        this.productPrice = productPrice;
    }
    // Default constructor for serialization
    public Product(){}

    // Abstract method to print product information, to be implemented by subclasses
    public abstract void printProducts();

    // Getter method to retrieve the product ID
    public String getProductID() {
        return productID;
    }

    // Setter method to update the product ID
    public void setProductID(String productID) {
        this.productID = productID;
    }

    // Getter method to retrieve the product name
    public String getProductName() {
        return productName;
    }

    // Setter method to update the product name
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter method to retrieve the number of available items
    public int getNoAvailableItems() {
        return noAvailableItems;
    }

    // Setter method to update the number of available items
    public void setNoAvailableItems(int noAvailableItems) {
        this.noAvailableItems = noAvailableItems;
    }

    // Getter method to retrieve the product price
    public double getProductPrice() {
        return productPrice;
    }

    // Setter method to update the product price

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    // Abstract getter method for the product category
    public String getCategory(){
        return this.category;
    }
    // Abstract getter method for additional information about the product
    public String getInfo(){
        return this.info;
    }
    // Abstract getter method for a unique value associated with the product
    public String getUniqueValue(){
        return this.uniqueValue;
    }
    // Getter method to retrieve the quantity of the product
    public int getQuantity() {
        return quantity;
    }

    // Setter method to update the quantity of the product
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
