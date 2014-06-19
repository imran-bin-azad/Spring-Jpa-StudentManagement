package net.therap.controller;

import net.therap.controller.util.RedirectUrls;
import net.therap.domain.Project;
import net.therap.domain.Student;
import net.therap.domain.StudentDetail;
import net.therap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by imran.azad on 6/17/14.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private Student student;

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(ModelMap model) {
        List<Student> allStudents = studentService.getAllStudents();
        printAllObjectsFromList(allStudents);
        model.addAttribute("allStudents", allStudents);

        System.out.println("SHOW ALL STUDENTS:");
        this.student = allStudents.get(0);

        return "enlistStudents";
    }

    private <T> void printAllObjectsFromList(List<T> objects) {
        for (T object : objects) {
            System.out.println(object);
        }
    }

    @RequestMapping(value = "/createNew", method = RequestMethod.GET)
    public String createNew() {
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setMobileNo("01919-xxxxxx");

        Student student = new Student();
        student.setName("imran");
        student.setDetail(studentDetail);
        studentService.addStudent(student);

        return RedirectUrls.showAllStudents;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove() {
        studentService.removeStudent(this.student);
        return RedirectUrls.showAllStudents;
    }

    @RequestMapping(value = "/showDetail", method = RequestMethod.GET)
    public String getDetail(ModelMap model) {
        StudentDetail studentDetail = studentService.getDetailOfStudent(1);
        model.addAttribute("studentDetail", studentDetail);
        return "enlistStudents";
    }

    @RequestMapping(value = "/showProjects", method = RequestMethod.GET)
    public String getProjects(ModelMap model) {
        List<Project> projects = studentService.getProjectsOfStudent(1);
        model.addAttribute("projects", projects);
        return "enlistStudents";
    }
}
