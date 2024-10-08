package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.entities.UserEntity;
import bg.softuni.mobilele.model.entities.UserRoleEntity;
import bg.softuni.mobilele.model.entities.enums.UserRoleEnum;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.security.CurrentUser;
import bg.softuni.mobilele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository,
                           CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String userName, String password) {

        Optional<UserEntity> userEntityOpt = userRepository.findByUsername(userName);
        if (userEntityOpt.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(password, userEntityOpt.get().getPassword());
        }
    }

    @Override
    public void loginUser(String userName) {

        UserEntity user = userRepository.findByUsername(userName).orElseThrow();

        List<UserRoleEnum> userRoles = user.
                getUserRoles().
                stream().
                map(UserRoleEntity::getRole).
                collect(Collectors.toList());

        currentUser.setAnonymous(false);
        currentUser.setName(userName);
        currentUser.setUserRoles(userRoles);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }
}
