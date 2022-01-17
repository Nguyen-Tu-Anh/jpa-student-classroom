package codegym.service;

import codegym.model.Student;
import codegym.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentService implements IStudentService{
    @Autowired
    StudentRepo studentRepo;
    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }
}
