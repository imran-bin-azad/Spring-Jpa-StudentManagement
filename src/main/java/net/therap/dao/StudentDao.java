package net.therap.dao;

import net.therap.domain.Student;
import net.therap.domain.StudentDetail;

import java.util.List;

/**
 * Created by imran.azad on 6/17/14.
 */
public interface StudentDao {
    public List<Student> getAllStudents();
    public void addStudent(Student newStudent);
    public void addMultipleStudents(List<Student> students);
    public void deleteStudent(Student student);
    public List getProjectsOfStudent(int studentId);
    public StudentDetail getDetailOfStudent(int studentId);
}
