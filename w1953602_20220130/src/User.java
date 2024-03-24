// User class representing a user in the shopping system
public class User {
    // Fields to store user information
    private String username;
    private String password;
    private boolean newUser;

    // Constructor to initialize user with provided username, password, and new user status
    public User(String username, String password, boolean newUser) {
        this.username = username;
        this.password = password;
        this.newUser = newUser;
    }
    // Getter method to check if the user is new
    public boolean isNewUser() {
        return newUser;
    }

    // Setter method to update new user status
    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    // Getter method to retrieve the username
    public String getUsername() {
        return username;
    }

    // Setter method to update the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method to retrieve the password
    public String getPassword() {
        return password;
    }

    // Setter method to update the password
    public void setPassword(String password) {
        this.password = password;
    }
}
