package bg.softuni.gira.web;

import bg.softuni.gira.security.CurrentUser;
import bg.softuni.gira.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model){
        if (currentUser.isAnonymous()){
            return "index";
        }
        model.addAttribute("tasks",taskService.allTasks());
        return "home";
    }
}
