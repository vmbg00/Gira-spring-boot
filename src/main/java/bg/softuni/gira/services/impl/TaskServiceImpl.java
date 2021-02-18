package bg.softuni.gira.services.impl;

import bg.softuni.gira.models.entities.Classification;
import bg.softuni.gira.models.entities.Task;
import bg.softuni.gira.models.entities.User;
import bg.softuni.gira.models.entities.enums.ProgressEnums;
import bg.softuni.gira.models.services.TaskAddServiceModel;
import bg.softuni.gira.models.views.TaskViewModel;
import bg.softuni.gira.repositories.ClassificationRepository;
import bg.softuni.gira.repositories.TaskRepository;
import bg.softuni.gira.repositories.UserRepository;
import bg.softuni.gira.security.CurrentUser;
import bg.softuni.gira.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class TaskServiceImpl implements TaskService {

    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final ClassificationRepository classificationRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(CurrentUser currentUser, UserRepository userRepository, TaskRepository taskRepository, ClassificationRepository classificationRepository, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.classificationRepository = classificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addTask(TaskAddServiceModel taskAddServiceModel) {
        Task task = new Task();
        User user = this.userRepository.findByUsername(currentUser.getName());
        Classification classification = this.classificationRepository.findByClassificationName(taskAddServiceModel.getClassification());

        task.setName(taskAddServiceModel.getName());
        task.setDescription(taskAddServiceModel.getDescription());
        task.setDueDate(taskAddServiceModel.getDueDate());
        task.setUser(user);
        task.setProgress(ProgressEnums.OPEN);
        task.setClassification(classification);

        this.taskRepository.save(task);

    }

    @Override
    public List<TaskViewModel> allTasks() throws ParseException {
        List<TaskViewModel> tasks = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        List<Task> allTasks = this.taskRepository.findAll();

        for (Task task : allTasks) {
            TaskViewModel taskViewModel = new TaskViewModel();
            modelMapper.map(task, taskViewModel);

            taskViewModel.setAssignedTo(task.getUser().getUsername());
            taskViewModel.setDueDate(formatter.format(task.getDueDate()));
            tasks.add(taskViewModel);
        }

        return tasks;
    }

    @Override
    public void progressUp(Long id) {
        Task task = this.taskRepository.findById(id).get();

        if (task.getProgress().equals(ProgressEnums.OPEN)){
            task.setProgress(ProgressEnums.IN_PROGRESS);
            taskRepository.save(task);
        }
        else if (task.getProgress().equals(ProgressEnums.IN_PROGRESS)){
            task.setProgress(ProgressEnums.COMPLETED);
            taskRepository.save(task);
        }
        else if (task.getProgress().equals(ProgressEnums.COMPLETED)){
            this.taskRepository.delete(task);
        }
    }
}
