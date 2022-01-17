package codegym.controller;

import codegym.model.Classroom;
import codegym.model.Student;
import codegym.service.IClassroomService;
import codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;
    @Autowired
    IClassroomService classroomService;

    @GetMapping("students")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("classrooms", classroomService.findAll());
        return modelAndView;
    }
    @PostMapping("create")
    public String create(@ModelAttribute("student") Student student, @RequestParam("idClassroom") Long idClassroom, @RequestParam MultipartFile upImg) {
        Classroom classroom = new Classroom();
        classroom.setId(idClassroom);
        student.setClassRoom(classroom);
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("D:\\[1] InteliJ project\\Module 4\\[6] JPA\\student-classroom-management\\src\\main\\webapp\\WEB-INF\\img\\"+ nameFile) );
            student.setImg("/i/img/" + nameFile);
            studentService.save(student);
        } catch (IOException e) {
            e.printStackTrace();
            student.setImg("/i/img/Screenshot (3).png");
            studentService.save(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student", studentService.findById(id));
        modelAndView.addObject("classrooms", classroomService.findAll());
        return modelAndView;
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute("student") Student student, @RequestParam("idClassroom") Long idClassroom, @RequestParam MultipartFile upImg) {
        Classroom classroom = new Classroom();
        classroom.setId(idClassroom);
        student.setClassRoom(classroom);
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("D:\\[1] InteliJ project\\Module 4\\[6] JPA\\student-classroom-management\\src\\main\\webapp\\WEB-INF\\img\\"+ nameFile) );
            student.setImg("/i/img/" + nameFile);
            studentService.save(student);
        } catch (IOException e) {
            e.printStackTrace();
            student.setImg("/i/img/Screenshot (3).png");
            studentService.save(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("student", studentService.findById(id));
        modelAndView.addObject("classrooms", classroomService.findAll());
        return modelAndView;
    }

    @PostMapping("delete")
    public String delete(@RequestParam(value = "id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
