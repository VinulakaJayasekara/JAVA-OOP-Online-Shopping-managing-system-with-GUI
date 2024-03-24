// Clothing class representing a specific type of product (Clothing) in the shopping system
import java.io.Serializable;

public class Clothing extends Product implements Serializable {

    // Additional fields specific to Clothing
    private String clothSize;

    private String clothColor;

    // Constant representing the category of the Clothing product
    private final String category = "Clothing";


    // Constructor to initialize Clothing with essential information
    public Clothing(String productID, String productName, int noAvailableItems, double productPrice, String clothSize, String clothColor) {
        super(productID, productName, noAvailableItems, productPrice);
        this.clothSize = clothSize;
        this.clothColor = clothColor;
    }

    // Default constructor for serialization
    public Clothing(){}

    // Getter method to retrieve the cloth size
    public String getClothSize() {
        return clothSize;
    }

    // Setter method to update the cloth size
    public void setClothSize(String clothSize) {
        this.clothSize = clothSize;
    }

    // Getter method to retrieve the cloth color
    public String getClothColor() {
        return clothColor;
    }

    // Setter method to update the cloth color
    public String getCategory() {
        return category;
    }

    public String getInfo(){
        return getClothSize() + ", " + getClothColor();
    }

    public String getUniqueValue(){
        return "Size: " + getClothSize() + "\n"
                + "Colour: " + getClothColor() + "\n";
    }

    public void setClothColor(String clothColor) {
        this.clothColor = clothColor;
    }

    public void printProducts(){
        System.out.println("Product ID : " + getProductID());
        System.out.println("Product Name : " + getProductName());
        System.out.println("Category : " + getCategory());
        System.out.println("Quantity : " + getNoAvailableItems());
        System.out.println("Price : " + getProductPrice());
        System.out.println("Size : " + getClothSize());
        System.out.println("Color : " + getClothColor());
        System.out.println("\n");
    }
}