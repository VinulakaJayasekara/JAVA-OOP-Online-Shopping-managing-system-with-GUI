// ShoppingManager interface representing the core functionality of a shopping manager

import java.io.IOException;

public interface ShoppingManager {

    // Method to add a new product
    public  void addProduct();

    // Method to delete an existing product
    public  void deleteProduct();

    // Method to print all products
    public void printProducts();

    // Method to save products to a file, may throw an IOException
    public void saveToFile() throws IOException;

    // Method to read products from a file
    public void readFromFile();
}
