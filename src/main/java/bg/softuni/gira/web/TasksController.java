package bg.softuni.gira.web;

import bg.softuni.gira.models.services.TaskAddServiceModel;
import bg.softuni.gira.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/add")
    public String add(Model model){
        if (!model.containsAttribute("taskAddServiceModel")){
            model.addAttribute("taskAddServiceModel", new TaskAddServiceModel());
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddServiceModel taskAddServiceModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskAddServiceModel", taskAddServiceModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddServiceModel", bindingResult);

            return "redirect:add";
        }
        this.taskService.addTask(taskAddServiceModel);

        return "redirect:/";
    }

}
