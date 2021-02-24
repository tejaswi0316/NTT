package com.poc.health.EnrollesDemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "enroll_users")
public class EnrollUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enroll_id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "activation_status")
    @NotNull
    private Boolean activationStatus;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enroll_id", referencedColumnName = "enroll_id")
    private List<EnrollUserDependents> userDependents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(Boolean activationStatus) {
        this.activationStatus = activationStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<EnrollUserDependents> getUserDependents() {
        return userDependents;
    }

    public void setUserDependents(List<EnrollUserDependents> userDependents) {
        this.userDependents = userDependents;
    }
}
