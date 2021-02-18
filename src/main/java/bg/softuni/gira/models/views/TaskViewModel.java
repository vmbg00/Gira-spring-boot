package bg.softuni.gira.models.views;

import bg.softuni.gira.models.entities.enums.ClassificationName;
import bg.softuni.gira.models.entities.enums.ProgressEnums;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class TaskViewModel {
    private Long id;
    private String name;
    private String assignedTo;
    private ClassificationName classification;
    private String dueDate;
    private ProgressEnums progress;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public TaskViewModel setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ProgressEnums getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(ProgressEnums progress) {
        this.progress = progress;
        return this;
    }
}
