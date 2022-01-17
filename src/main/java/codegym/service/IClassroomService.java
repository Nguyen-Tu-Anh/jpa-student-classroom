package codegym.service;

import codegym.model.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();
}
