package bg.softuni.gira.web;

import bg.softuni.gira.security.CurrentUser;
import bg.softuni.gira.services.TaskService;
import bg.softuni.gira.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, TaskService taskService, UserService userService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) throws ParseException {
        if (currentUser.isAnonymous()){
            return "index";
        }
        model.addAttribute("tasks",taskService.allTasks());
        return "home";
    }

    @GetMapping("/users/logout")
    public String logout(){
        this.userService.logout();
        return "redirect:/";
    }

    @GetMapping("/tasks/progress/{id}")
    public String progressUp(@PathVariable Long id){
        this.taskService.progressUp(id);

        return "redirect:/";
    }
}
