package net.therap.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by imran.azad on 6/17/14.
 */
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy="projects", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", students=" + students +
                '}';
    }
}
