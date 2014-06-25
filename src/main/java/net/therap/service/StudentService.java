package net.therap.service;

import net.therap.dao.StudentDao;
import net.therap.domain.Project;
import net.therap.domain.Student;
import net.therap.domain.StudentDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by imran.azad on 6/17/14.
 */
@Service
@Transactional
public class StudentService {
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    @Qualifier("jpaStudentDaoImpl")
    private StudentDao studentDao;

    @Cacheable(value = "students")
    public List<Student> getAllStudents() {
        logger.info("getAllStudents");
        return studentDao.getAllStudents();
    }

    @Cacheable(value = "singleStudent", key = "#studentId")
    public Student getStudentById(int studentId) {
        logger.info("getStudentById");
        return studentDao.getStudentById(studentId);
    }

    @CacheEvict(value = "students", allEntries = true)
    public void addStudent(Student newStudent) {
        studentDao.addStudent(newStudent);
    }

    public void addMultipleStudents(List<Student> newStudents) {
        studentDao.addMultipleStudents(newStudents);
    }

    public void removeStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    @CacheEvict(value = {"singleStudent", "students"}, key = "#student.id")
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public List<Project> getProjectsOfStudent(int studentId) {
        return studentDao.getProjectsOfStudent(studentId);
    }

    public List<Student> getFriendListOfStudent(int studentId) {
        return studentDao.getFriendListOfStudent(studentId);
    }

    @Cacheable(value = "studentDetail")
    public StudentDetail getDetailOfStudent(int studentId) {
        logger.info("getDetailOfStudent");
        return studentDao.getDetailOfStudent(studentId);
    }
}
