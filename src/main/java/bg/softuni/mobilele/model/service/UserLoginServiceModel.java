package bg.softuni.mobilele.model.service;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginServiceModel {
    @NotNull
    @Size(min = 2)
    private String username;
    @NotNull
    @Size(min = 3)
    private String password;


    public String getUsername() {
        return username;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
