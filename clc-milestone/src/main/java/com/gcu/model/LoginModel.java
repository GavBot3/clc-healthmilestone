import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// A Java class representing the model for the login form
public class LoginModel {

    // Define validation constraints for the username field
    @NotNull(message = "User name is a required field") // Username must not be null
    @Size(min = 1, max = 32, message = "User name must be between 1 and 32 characters") // Username must be between 1 and 32 characters in length
    private String username;

    // Define validation constraints for the password field
    @NotNull(message = "Password is a required field") // Password must not be null
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") // Password must be between 1 and 32 characters in length
    private String password;

    // Getter method for the username field
    public String getUsername() {
        return username;
    }

    // Setter method for the username field
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for the password field
    public String getPassword() {
        return password;
    }

    // Setter method for the password field
    public void setPassword(String password) {
        this.password = password;
    }
}
