package bg.softuni.gira.repositories;

import bg.softuni.gira.models.entities.Classification;
import bg.softuni.gira.models.entities.enums.ClassificationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Classification findByClassificationName(ClassificationName classification);
}
