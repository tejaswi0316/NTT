package com.poc.health.EnrollesDemo;

import com.poc.health.EnrollesDemo.model.EnrollUserDependents;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class EnrollRequest {

    @NotBlank(message = "id must not be blank!")
    private Long id;

    @NotBlank(message = "name must not be blank!")
    private String name;

    @NotBlank(message = "activationStatus must not be blank!")
    private String activationStatus;

    private String phoneNumber;

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

    public String getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(String activationStatus) {
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
