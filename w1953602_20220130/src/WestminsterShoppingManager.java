import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// WestminsterShoppingManager class implementing ShoppingManager interface
public class WestminsterShoppingManager implements ShoppingManager {          //interface vs abstract class

    // ArrayLists to store products and users
    private static ArrayList<Product> productList;
    private static ArrayList<User> userList;
    private static Scanner input;

    // Constructor to initialize ArrayLists and Scanner
    public WestminsterShoppingManager() {
        productList = new ArrayList<>();
        userList = new ArrayList<>();
        input = new Scanner(System.in);
    }
    // Main method to start the shopping manager
    public static void main(String[] args) throws Exception {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        shoppingManager.managerConsole();
    }
    // Console interface for the shopping manager
    public void managerConsole() throws Exception {
        boolean flag = true;
        while (flag) {
            // Display menu options
            System.out.println("\n-------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("1) Add a new product");
            System.out.println("2) Delete an existing Product");
            System.out.println("3) Print all products");
            System.out.println("4) Save products to file");
            System.out.println("5) Load products from file");
            System.out.println("6) User console");
            System.out.println("0) Quit");
            System.out.print("\nEnter an option: ");

            // Validate user input
            if (!input.hasNextInt()) {
                System.out.println("\nInvalid input, Please enter an integer");
                input.next();
                continue;
            }
            int option = input.nextInt();

            input.nextLine();

            // Perform actions based on user input
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    printProducts();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    readFromFile();
                    break;
                case 6:
                    user();
                    break;
                case 0:
                    System.out.println("\nProgram end ....");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Option");
                    System.out.println(" ");
            }
        }
    }
    // Implementation of addProduct method from ShoppingManager interface
    @Override
    public  void addProduct() {
        // Method logic for adding a new product
        int choice = 0, noOfAvailableItems, warrantyTimePeriod;
        String productId;
        double productPrice;

        while (true){
            if (productList.size() == 50){
                System.out.println("Maximum Amount of Products Reached!!");
                break;
            }
            System.out.println("What Do You Want to Add? \n(1 : Electronics, 2: Cloths)");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input, please enter 1 for Electronics, 2 for Cloths: ");
                input.next();
                continue;
            }
            choice = input.nextInt();
            input.nextLine(); // Consume the newline character
            break;
        }

        if (choice == 1) {
            // Logic for adding Electronics
            while (true) {
                System.out.println("Enter Product ID: ");
                productId = input.next();

                for (Product product: productList){
                    if (product.getProductID().equals(productId)){
                        System.out.println("This ProductID is Already entered.");
                        return;
                    }
                }
                break;
            }

            System.out.println("Enter Product Name: ");
            String productName = input.next();

            while (true){
                try {
                    System.out.println("Enter No of Available Items: ");
                    noOfAvailableItems = input.nextInt();
                    break;
                } catch (Exception e){
                    System.out.println("Please enter an Integer \n");
                    input.nextLine();
                    continue;
                }
            }

            while (true){
                try {
                    System.out.println("Enter Product Price: ");
                    productPrice = input.nextDouble();
                    break;

                } catch (Exception e){
                    System.out.println("Please enter an valid price\n");
                    input.nextLine();
                }
            }

            System.out.println("Enter Product Brand: ");
            String productBrand = input.next();

            while (true){
                try {
                    System.out.println("Enter Warranty Time Period: ");
                    warrantyTimePeriod = input.nextInt();
                    break;

                } catch (Exception e){
                    System.out.println("Please enter an Integer \n");
                    input.nextLine();
                }
            }


            Product product = new Electronics(productId, productName, noOfAvailableItems, productPrice, productBrand, warrantyTimePeriod);
            productList.add(product);

        } else if (choice == 2) {
            // Logic for adding Clothing
            while (true) {
                System.out.println("Enter Product ID: ");
                productId = input.next();

                for (Product product: productList){
                    if (product.getProductID().equals(productId)){
                        System.out.println("This ProductID is Already entered.");
                        return;
                    }
                }
                break;
            }

            System.out.println("Enter Product Name: ");
            String productName = input.next();

            while (true){
                try {
                    System.out.println("Enter No of Available Items: ");
                    noOfAvailableItems = input.nextInt();
                    break;
                } catch (Exception e){
                    System.out.println("Please enter an Integer \n");
                    input.nextLine();
                }
            }

            while (true){
                try {
                    System.out.println("Enter Product Price: ");
                    productPrice = input.nextDouble();
                    break;

                } catch (Exception e){
                    System.out.println("Please enter an valid price\n");
                    input.nextLine();
                }
            }

            System.out.println("Enter Cloth Size: ");
            String clothSize = input.next();

            System.out.println("Enter Cloth Color: ");
            String clothColor = input.next();

            Product product = new Clothing(productId, productName, noOfAvailableItems, productPrice, clothSize, clothColor);
            productList.add(product);
        }
        else {
            System.out.println("Invalid Input");
        }
    }
    // Implementation of deleteProduct method from ShoppingManager interface
    @Override
    public void deleteProduct() {
        System.out.println("Enter Product ID to Delete: ");
        String delete = input.next();

        for (Product product : productList) {
            if (product.getProductID().equals(delete)) {
                productList.remove(product);
                System.out.println("Product Removed Successfully");
                System.out.println("Available Product Count: " + productList.size());
                break;
            }
        }
    }
    // Implementation of printProducts method from ShoppingManager interface
    @Override
    public void printProducts() {
        for (int i = 0; i < productList.size() - 1; i++) {
            for (int j = 0; j < productList.size() - i - 1; j++) {
                String id1 = productList.get(j).getProductID();
                String id2 = productList.get(j + 1).getProductID();

                if (id1.compareTo(id2) > 0) {
                    Collections.swap(productList, j, j + 1);
                }
            }
        }
        for (Product product : productList) {
            product.printProducts();
        }
    }
    // Implementation of saveToFile method from ShoppingManager interface
    @Override
    public void saveToFile() throws IOException {
        File inputFile = new File("Text.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inputFile));
        for (Product product : productList) {
            oos.writeObject(product);
        }
        oos.close();
    }
    // Implementation of readFromFile method from ShoppingManager interface
    @Override
    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Text.txt"))) {
            while (true) {
                try {
                    Product obj = (Product) ois.readObject();
                    productList.add(obj);
                } catch (EOFException eofException) {
                    break;
                }
            }
            System.out.println("Products loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // Method to handle user login
    public static User userLogin(){
        System.out.println("Enter Username: ");
        String username = input.next();
        System.out.println("Enter Password: ");
        String password = input.next();

        for (User user : userList){
            if (user.getUsername().equals(username)){
                user.setNewUser(false);
                return user;
            }
        }

        User customer = new User(username, password, true);
        userList.add(customer);
        return customer;
    }
    // Method to initiate the user console
    public static void user() {
        User user = userLogin();
        ShoppingCart cart = new ShoppingCart(user);
        UserConsole myFrame = new UserConsole(cart);
        myFrame.setSize(750, 600);
        myFrame.setTitle("Westminster Shopping Center");
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setVisible(true);
    }
    // UserConsole class representing the GUI for user interaction
    public static class UserConsole extends JFrame {
        // Fields for various components in the GUI
        private JPanel main, head, content, footer, p1, p2, p3, addToCartPanel;
        private JButton cartButton, addToCartButton;
        private JTable table;
        private JTextArea footerTextArea;
        private ShoppingCart shoppingCart;

        public UserConsole(ShoppingCart shoppingCart) {
            // Initialization of GUI components
            this.shoppingCart = shoppingCart;

            main = new JPanel();
            main.setBackground(Color.red);
            head = new JPanel(new BorderLayout());
            head.setPreferredSize(new Dimension(700, 70));

            p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            p1.setBackground(Color.blue);
            p1.setPreferredSize(new Dimension(700, 30));
            cartButton = new JButton("Shopping Cart");
            p1.add(cartButton);
            head.add(p1, BorderLayout.CENTER);

            cartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ShoppingCart.ShoppingCartFrame(shoppingCart);
                }
            });

            p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
            p2.setBackground(Color.pink);
            JLabel categoryLabel = new JLabel("Select Product Category");
            p2.add(categoryLabel);
            String[] categories = {"All", "Electronics", "Clothing"};
            JComboBox<String> categoryComboBox = new JComboBox<>(categories);
            p2.add(categoryComboBox);
            head.add(p2, BorderLayout.SOUTH);


            main.add(head, BorderLayout.NORTH);

            String[] columnNames = {"Product ID", "Product Name", "Category", "Price(£)", "Info"};
            Object[][] rowData = new Object[productList.size()][columnNames.length];

            categoryComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedCategory = (String) categoryComboBox.getSelectedItem();
                    updateTableData(selectedCategory);
                }
            });

            for (int i = 0; i < productList.size() - 1; i++) {
                for (int j = 0; j < productList.size() - i - 1; j++) {
                    String id1 = productList.get(j).getProductID();
                    String id2 = productList.get(j + 1).getProductID();

                    if (id1.compareTo(id2) > 0) {
                        Collections.swap(productList, j, j + 1);
                    }
                }
            }

            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                rowData[i][0] = product.getProductID();
                rowData[i][1] = product.getProductName();
                rowData[i][2] = product.getCategory();
                rowData[i][3] = product.getProductPrice();
                rowData[i][4] = product.getInfo();
            }

            table = new JTable();
            TableModel model = new DefaultTableModel(rowData, columnNames);
            table.setModel(model);
            table.setGridColor(Color.pink);
            table.setPreferredScrollableViewportSize(new Dimension(700, 150));

            JScrollPane scrollPane = new JScrollPane(table);

            content = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 45));
            content.add(scrollPane);
            content.setBackground(Color.pink);

            main.add(content);

            footer = new JPanel(new BorderLayout());
            footer.setBackground(Color.cyan);
            footer.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
            footer.setPreferredSize(new Dimension(750, 200));

            JLabel footerTitle = new JLabel("Selected Product - Details");
            footerTitle.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            footer.add(footerTitle, BorderLayout.NORTH);


            footerTextArea = new JTextArea(5, 20);
            footerTextArea.setEditable(false);
            footerTextArea.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            footerTextArea.setBackground(Color.lightGray);
            footer.add(footerTextArea, BorderLayout.CENTER);

            addToCartPanel = new JPanel(new FlowLayout());
            addToCartButton = new JButton("Add to Cart");
            addToCartPanel.add(addToCartButton);
            addToCartPanel.setBackground(Color.pink);

            addToCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        addSelectedProductToCart(selectedRow);
                    }
                }
            });

            footer.add(addToCartPanel, BorderLayout.SOUTH);

            main.add(footer);

            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            updateFooterTextArea(selectedRow);
                        }
                    }
                }
            });
            // Add components to the main panel
            this.add(main);
        }
        // Method to add a selected product to the shopping cart
        private void addSelectedProductToCart(int selectedRow) {
            String productID = table.getValueAt(selectedRow, 0).toString();

            for (Product product : productList) {
                if (product.getProductID().equals(productID)) {
                    shoppingCart.addToCart(product);
                    break;
                }
            }
        }
        // Method to update table data based on selected category
    public void updateTableData(String selectedCategory) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Product product : productList) {
                if (selectedCategory.equals("All")) {
                    Object[] rowData = {product.getProductID(), product.getProductName(), product.getCategory(), product.getProductPrice(), product.getInfo()};
                    model.addRow(rowData);
                }
                else if (selectedCategory.equals("Electronics") && product.getCategory().equals("Electronics")) {
                    Object[] rowData = {product.getProductID(), product.getProductName(), product.getCategory(), product.getProductPrice(), product.getInfo()};
                    model.addRow(rowData);
                }
                else if(selectedCategory.equals("Clothing") && product.getCategory().equals("Clothing")) {
                    Object[] rowData = {product.getProductID(), product.getProductName(), product.getCategory(), product.getProductPrice(), product.getInfo()};
                    model.addRow(rowData);
                }
            }
        }
        // Method to update footer text area based on selected row
        public void updateFooterTextArea(int selectedRow) {
            String productID = table.getValueAt(selectedRow, 0).toString();
            String footerText = "";

            for (Product product: productList){
                if (product.getProductID().equals(productID)){
                    footerText =
                    "Product ID: " + productID + "\n" +
                    "Category: " + product.getCategory() + "\n" +
                    "Product Name: " + product.getProductName() + "\n" +
                    product.getUniqueValue() +
                    "Price: £" + product.getProductPrice() + "\n" +
                    "Items Available: " + product.getNoAvailableItems();
                    break;
                }
            }
            footerTextArea.setText(footerText);
        }
    }
}


