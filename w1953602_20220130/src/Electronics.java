// Electronics class representing a specific type of product (Electronics) in the shopping system

import java.io.Serializable;

public class Electronics extends Product implements Serializable {

    // Additional fields specific to Electronics
    private String productBrand;

    private int warrantyTimePeriod;

    // Constant representing the category of the Electronics product
    private final String category = "Electronics";

    // Constructor to initialize Electronics with essential information

    public Electronics(String productID, String productName, int noAvailableItems, double productPrice, String productBrand, int warrantyTimePeriod) {
        super(productID, productName, noAvailableItems, productPrice);
        this.productBrand = productBrand;
        this.warrantyTimePeriod = warrantyTimePeriod;
    }
    // Default constructor for serialization

    public Electronics(){}
    // Getter method to retrieve the product brand

    public String getProductBrand() {
        return productBrand;
    }
    // Setter method to update the product brand

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    // Getter method to retrieve the warranty time period

    public int getWarrantyTimePeriod() {
        return warrantyTimePeriod;
    }
    // Setter method to update the warranty time period

    public void setWarrantyTimePeriod(int warrantyTimePeriod) {
        this.warrantyTimePeriod = warrantyTimePeriod;
    }

    public String getCategory() {
        return category;
    }

    public String getInfo(){
        return getProductBrand() + ", " + getWarrantyTimePeriod();
    }

    public String getUniqueValue(){
        return "Brand: " + getProductBrand() + "\n"
                + "Warranty Time Period: " + getWarrantyTimePeriod() + "\n";
    }

    public void printProducts(){
        System.out.println("Product ID : " + getProductID());
        System.out.println("Product Name : " + getProductName());
        System.out.println("Category : " + getCategory());
        System.out.println("Quantity : " + getNoAvailableItems());
        System.out.println("Price : " + getProductPrice());
        System.out.println("Brand Name : " + getProductBrand());
        System.out.println("Warranty Time Period : " + getWarrantyTimePeriod() + " weeks warranty");
        System.out.println("\n");
    }
}

