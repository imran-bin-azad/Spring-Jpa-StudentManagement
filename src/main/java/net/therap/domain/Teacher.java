package net.therap.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by imran.azad on 6/24/14.
 */
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name", length = 50)
    @Size(max = 30, min = 3,
          message = "name must be of 3 characters min, 30 characters max")
    private String name;

    @NotNull
    @Column(name = "email", length = 20)
    @Pattern(regexp = "[a-zA-Z0-9.]+@[a-zA-Z]+[.][a-zA-Z]+",
             message = "invalid email")
    private String email;

    @NotNull
    @Column(name = "password", length = 50)
    @Size(min = 6,
          message = "password too small, 6 characters min")
    private String password;

    @NotNull
    @Column(name = "dob")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat
    @Past
    private Date dob;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                '}';
    }
}
