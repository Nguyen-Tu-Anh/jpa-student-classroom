package codegym.service;

import codegym.model.Classroom;
import codegym.repository.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassroomService implements IClassroomService{
    @Autowired
    ClassroomRepo classroomRepo;
    @Override
    public List<Classroom> findAll() {
        return (List<Classroom>) classroomRepo.findAll();
    }
}
