package bg.softuni.gira.services;

import bg.softuni.gira.models.services.TaskAddServiceModel;
import bg.softuni.gira.models.views.TaskViewModel;

import java.text.ParseException;
import java.util.List;

public interface TaskService {

    void addTask(TaskAddServiceModel taskAddServiceModel);

    List<TaskViewModel> allTasks() throws ParseException;

    void progressUp(Long id);
}
