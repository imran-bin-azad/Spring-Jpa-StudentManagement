package net.therap.dao;

import net.therap.domain.Project;
import net.therap.domain.Student;
import net.therap.domain.StudentDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by imran.azad on 6/17/14.
 */
@Repository
@Qualifier("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public void addStudent(Student newStudent) {
        System.out.println("INSERTING : " + newStudent);
        entityManager.persist(newStudent);
        entityManager.flush();
    }

    @Override
    public void addMultipleStudents(List<Student> newStudents) {
        System.out.println("INSERTING STUDENT LIST:");
        for (Student student : newStudents) {
            entityManager.persist(student);
        }
        entityManager.flush();
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }

    @Override
    public List<Project> getProjectsOfStudent(int studentId) {
//        Dont know whats the problem with TypedQuery :/
//        TypedQuery<Project> query = entityManager.createNamedQuery("SELECT p " +
//                                                                    "FROM Student s JOIN s.projects p " +
//                                                                    "WHERE s.id=:id", Project.class)
//                                                    .setParameter("id", studentId);
//        return query.getResultList();

        Query query = entityManager.createQuery("SELECT p " +
                                                "FROM Student s JOIN s.projects p " +
                                                "WHERE s.id=:id")
                                    .setParameter("id", studentId);

        return query.getResultList();
    }

    public StudentDetail getDetailOfStudent(int studentId) {
        Query query = entityManager.createQuery("SELECT sd " +
                                                "FROM Student s JOIN s.detail sd " +
                                                "WHERE s.id=:id")
                                    .setParameter("id", studentId);

        return (StudentDetail) query.getSingleResult();
    }
}
