package bg.softuni.gira.web;

import bg.softuni.gira.models.services.UserLoginServiceModel;
import bg.softuni.gira.models.services.UserRegisterServiceModel;
import bg.softuni.gira.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model){
        if (!model.containsAttribute("userLoginServiceModel")){
            model.addAttribute("userLoginServiceModel", new UserRegisterServiceModel());
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginServiceModel userLoginServiceModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterServiceModel", userLoginServiceModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginServiceModel", bindingResult);

            return "redirect:login";
        }

        if (userService.authenticate(userLoginServiceModel.getEmail(), userLoginServiceModel.getPassword())){
            userService.login(userLoginServiceModel);

            return "redirect:/";
        }
        else {
            redirectAttributes.addFlashAttribute("userLoginServiceModel", userLoginServiceModel);
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:login";
        }

    }

    @GetMapping("/register")
    public String register(Model model){
        if (!model.containsAttribute("userRegisterServiceModel")){
            model.addAttribute("userRegisterServiceModel", new UserRegisterServiceModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterServiceModel userRegisterServiceModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() ||
                !userRegisterServiceModel.getPassword().equals(userRegisterServiceModel.getConfirmPassword()) ){
            redirectAttributes.addFlashAttribute("userRegisterServiceModel", userRegisterServiceModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterServiceModel", bindingResult);

            return "redirect:register";
        }

        this.userService.register(userRegisterServiceModel);

        return "redirect:login";
    }
}
