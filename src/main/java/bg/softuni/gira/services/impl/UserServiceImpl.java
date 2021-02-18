package bg.softuni.gira.services.impl;

import bg.softuni.gira.models.entities.User;
import bg.softuni.gira.models.services.UserLoginServiceModel;
import bg.softuni.gira.models.services.UserRegisterServiceModel;
import bg.softuni.gira.repositories.UserRepository;
import bg.softuni.gira.security.CurrentUser;
import bg.softuni.gira.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserRegisterServiceModel userRegisterServiceModel) {
        User user = new User();

        user
                .setUsername(userRegisterServiceModel.getUsername())
                .setPassword(userRegisterServiceModel.getPassword())
                .setEmail(userRegisterServiceModel.getEmail());

        userRepository.save(user);
    }

    @Override
    public boolean authenticate(String email, String password) {
        Optional<User> user = this.userRepository.findByEmail(email);

        if (user.isEmpty()){
            return false;
        }
        else {
            return user.get().getPassword().equals(password);
        }
    }

    @Override
    public void login(UserLoginServiceModel userLoginServiceModel) {
        Optional<User> user = this.userRepository.findByEmail(userLoginServiceModel.getEmail());

        currentUser.setName(user.get().getUsername()).setAnonymous(false);
    }
}
