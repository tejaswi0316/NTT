package com.poc.health.EnrollesDemo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "enroll_user_dependents")
public class EnrollUserDependents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dependent_id")
    private Long id;

    @Column(name = "enroll_id")
    private Integer enrollId;

    @Column(name = "name")
    private String name;

    private Date dob;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(Integer enrollId) {
        this.enrollId = enrollId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
