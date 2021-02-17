package bg.softuni.gira.services.impl;

import bg.softuni.gira.models.entities.User;
import bg.softuni.gira.models.services.UserRegisterServiceModel;
import bg.softuni.gira.repositories.UserRepository;
import bg.softuni.gira.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
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
}
