package bg.softuni.gira.models.services;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginServiceModel {
    private String email;
    private String password;

    public UserLoginServiceModel() {
    }

    @NotBlank(message = "Cannot be empty")
    @Size(min = 3, max = 20, message = "Mail length must be between 3 and 20 characters")
    public String getEmail() {
        return email;
    }

    public UserLoginServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Cannot be empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public UserLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
