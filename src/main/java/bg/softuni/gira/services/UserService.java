package bg.softuni.gira.services;

import bg.softuni.gira.models.services.UserLoginServiceModel;
import bg.softuni.gira.models.services.UserRegisterServiceModel;

public interface UserService {


    void register(UserRegisterServiceModel userRegisterServiceModel);

    boolean authenticate(String email, String password);

    void login(UserLoginServiceModel userLoginServiceModel);

    void logout();
}
