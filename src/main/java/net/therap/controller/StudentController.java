package net.therap.controller;

import net.therap.controller.util.RedirectUrls;
import net.therap.domain.Project;
import net.therap.domain.Student;
import net.therap.domain.StudentDetail;
import net.therap.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    private Student student;

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(ModelMap model) {
        List<Student> allStudents = studentService.getAllStudents();
        printAllObjectsFromList(allStudents);
        model.addAttribute("allStudents", allStudents);
        this.student = allStudents.get(0);

        return "student/showAll";
    }

    private <T> void printAllObjectsFromList(List<T> objects) {
        for (T object : objects) {
            System.out.println(object);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateStudent(ModelMap model) {
        Student student = studentService.getStudentById(5);
        StudentDetail detail = student.getDetail();
        detail.setMobileNo("01818-xxx000");
        student.setDetail(detail);

        logger.info("Student to update : " + student);
        studentService.updateStudent(student);

        return "redirect:/student/showAll";
    }

    @RequestMapping(value = "/createNew", method = RequestMethod.GET)
    public String createNew() {
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setMobileNo("01818-xxxxxx");

        Student student = new Student();
        student.setName("sanjay");
        student.setDetail(studentDetail);
        studentService.addStudent(student);

        return RedirectUrls.showAllStudents;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public String getStudent(ModelMap model) {
        Student student = studentService.getStudentById(5);
        logger.info("Student By Id: " + student);

        model.addAttribute("studentById", student);

        return "student/showAll";
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
        return "student/showAll";
    }

    @RequestMapping(value = "/showProjects", method = RequestMethod.GET)
    public String getProjects(ModelMap model) {
        List<Project> projects = studentService.getProjectsOfStudent(1);
        model.addAttribute("projects", projects);
        return "student/showAll";
    }

    @RequestMapping(value = "/showFriendList", method = RequestMethod.GET)
    public String getFriends(ModelMap model) {
        List<Student> friends = studentService.getFriendListOfStudent(1);
        model.addAttribute("friends", friends);
        return "student/showAll";
    }
}
