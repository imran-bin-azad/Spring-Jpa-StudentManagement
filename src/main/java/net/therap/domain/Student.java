package net.therap.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by imran.azad on 6/16/14.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_detail_id")
    private StudentDetail detail;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name="student_project",
                joinColumns={@JoinColumn(name="student_id", referencedColumnName="id")},
                inverseJoinColumns={@JoinColumn(name="project_id", referencedColumnName="id")})
    private List<Project> projects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentDetail getDetail() {
        return detail;
    }

    public void setDetail(StudentDetail detail) {
        this.detail = detail;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail=" + detail +
                ", projects=" + projects +
                '}';
    }
}
