package bg.softuni.gira.models.entities;

import bg.softuni.gira.models.entities.enums.ClassificationName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    private ClassificationName classificationName;
    private String description;

    public Classification() {
    }

    @Enumerated(value = EnumType.STRING)
    public ClassificationName getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationName classificationName) {
        this.classificationName = classificationName;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
