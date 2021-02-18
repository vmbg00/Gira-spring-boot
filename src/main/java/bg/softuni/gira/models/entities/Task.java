package bg.softuni.gira.models.entities;

import bg.softuni.gira.models.entities.enums.ProgressEnums;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{

    private String name;
    private String description;
    private ProgressEnums progress;
    private Date dueDate;
    private Classification classification;
    private User user;

    public Task() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(value = EnumType.STRING)
    public ProgressEnums getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnums progress) {
        this.progress = progress;
    }

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @ManyToOne
    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
