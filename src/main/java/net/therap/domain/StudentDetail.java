package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by imran.azad on 6/17/14.
 */
@Entity
@Table(name = "student_detail")
public class StudentDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "mobile_no")
    private String mobileNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
