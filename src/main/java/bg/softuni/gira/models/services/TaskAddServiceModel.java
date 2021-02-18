package bg.softuni.gira.models.services;

import bg.softuni.gira.models.entities.enums.ClassificationName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

public class TaskAddServiceModel {
    private String name;
    private String description;
    private Date dueDate;
    private ClassificationName classification;

    public TaskAddServiceModel() {
    }

    @NotBlank(message = "Must not be blank")
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public TaskAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank(message = "Must not be blank")
    @Size(min = 5, message = "Description length must be minimum 5 characters")
    public String getDescription() {
        return description;
    }

    public TaskAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date cannot be in the past")
    public Date getDueDate() {
        return dueDate;
    }

    public TaskAddServiceModel setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @NotNull(message = "You must select a classification")
    public ClassificationName getClassification() {
        return classification;
    }

    public TaskAddServiceModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }
}
