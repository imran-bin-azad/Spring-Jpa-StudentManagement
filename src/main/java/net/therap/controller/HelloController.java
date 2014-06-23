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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping({"/hello"})
public class HelloController {
    @Autowired
    private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(value = "/testInsert", method = RequestMethod.GET)
    public String testInsert() {
        System.out.println("TEST INSERT:");
//        Student Details
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setMobileNo("01919-xxxxxx");

        StudentDetail studentDetail2 = new StudentDetail();
        studentDetail2.setMobileNo("01717-xxxxxx");

        StudentDetail studentDetail3 = new StudentDetail();
        studentDetail3.setMobileNo("01616-xxxxxx");

//        Projects
        Project project = new Project();
        project.setName("project: imran-safat");

        Project project2 = new Project();
        project2.setName("project: imran-rashed");

        Project project3 = new Project();
        project3.setName("project: rashed-safat");

//        Students
        Student student = new Student();
        student.setName("imran");
        student.setDetail(studentDetail);
        student.setProjects(new ArrayList<Project>(Arrays.asList(project, project2)));

        Student student2 = new Student();
        student2.setName("safat");
        student2.setDetail(studentDetail2);
        student2.setProjects(new ArrayList<Project>(Arrays.asList(project, project3)));

        Student student3 = new Student();
        student3.setName("rashed");
        student3.setDetail(studentDetail3);
        student3.setProjects(new ArrayList<Project>(Arrays.asList(project2, project3)));

        System.out.println(student);
        System.out.println(student2);
        System.out.println(student3);

        List<Student> newStudents = new ArrayList<Student>(Arrays.asList(student, student2, student3));

//        studentService.addMultipleStudents(newStudents);
        
//        studentService.addStudent(student);
//        studentService.addStudent(student2);
//        studentService.addStudent(student3);

        return RedirectUrls.showAllStudents;
    }

    @RequestMapping(value = "/parseProjectClass", method = RequestMethod.GET)
    public String parseAnnotationsOfProjectClass(ModelMap model) throws ClassNotFoundException {
        Class projectClass = Class.forName("net.therap.domain.Project");

        Field[] fields = projectClass.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            System.out.println("Field: " + field.getName() + ":");
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }

        return "hello";
    }
}