package codegym.service;

import codegym.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    void delete(Long id);

    Optional<Student> findById(Long id);

}
