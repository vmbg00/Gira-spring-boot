package bg.softuni.gira.models.services;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterServiceModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterServiceModel() {
    }

    @NotBlank(message = "Cannot be empty")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Cannot be empty")
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "Cannot be empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "Cannot be empty")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
