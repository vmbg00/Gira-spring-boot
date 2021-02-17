package bg.softuni.gira;

import bg.softuni.gira.models.entities.Classification;
import bg.softuni.gira.models.entities.enums.ClassificationName;
import bg.softuni.gira.repositories.ClassificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final ClassificationRepository classificationRepository;

    public DBInit(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (classificationRepository.count() == 0){
            Classification bug = new Classification();
            bug.setClassificationName(ClassificationName.BUG);
            bug.setDescription("Must be fixed ASAP");

            Classification feature = new Classification();
            feature.setClassificationName(ClassificationName.FEATURE);
            feature.setDescription("Added functionality");

            Classification support = new Classification();
            support.setClassificationName(ClassificationName.SUPPORT);
            support.setDescription("Help maintain stability");

            Classification other = new Classification();
            other.setClassificationName(ClassificationName.OTHER);
            other.setDescription("Bonus stuff");

            classificationRepository.save(bug);
            classificationRepository.save(feature);
            classificationRepository.save(support);
            classificationRepository.save(other);
        }
    }
}
