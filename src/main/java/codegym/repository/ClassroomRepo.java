package codegym.repository;

import codegym.model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepo extends CrudRepository<Classroom, Long> {
}
