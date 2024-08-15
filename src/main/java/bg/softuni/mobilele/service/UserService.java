package bg.softuni.mobilele.service;

public interface UserService {
//**

    boolean authenticate(String userName, String password);

    void loginUser(String userName);

    void logoutCurrentUser();
}
