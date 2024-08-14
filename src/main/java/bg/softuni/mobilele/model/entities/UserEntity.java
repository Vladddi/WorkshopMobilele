package bg.softuni.mobilele.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

private String username;
private String password;
private String firstName;
private String lastName;
private boolean isActive;
private String imageUrl;
@ManyToMany
private List<UserRoleEntity> userRoles;

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public UserEntity setUserRoles(
            List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='N/A" + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
