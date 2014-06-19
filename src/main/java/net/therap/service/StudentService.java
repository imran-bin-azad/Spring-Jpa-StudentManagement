package net.therap.service;

import net.therap.dao.StudentDao;
import net.therap.dao.StudentDaoImpl;
import net.therap.domain.Project;
import net.therap.domain.Student;
import net.therap.domain.StudentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by imran.azad on 6/17/14.
 */
@Service
@Transactional
public class StudentService {
    @Autowired
    @Qualifier("studentDaoImpl")
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public void addStudent(Student newStudent) {
        studentDao.addStudent(newStudent);
    }

    public void addMultipleStudents(List<Student> newStudents) {
        studentDao.addMultipleStudents(newStudents);
    }

    public void removeStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    public List<Project> getProjectsOfStudent(int studentId) {
        return studentDao.getProjectsOfStudent(studentId);
    }

    public StudentDetail getDetailOfStudent(int studentId) {
        return studentDao.getDetailOfStudent(studentId);
    }
}
