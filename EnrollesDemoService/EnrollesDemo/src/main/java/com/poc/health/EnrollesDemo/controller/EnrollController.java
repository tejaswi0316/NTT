package com.poc.health.EnrollesDemo.controller;

import com.poc.health.EnrollesDemo.model.EnrollUserDependents;
import com.poc.health.EnrollesDemo.model.EnrollUsers;
import com.poc.health.EnrollesDemo.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EnrollController {

    @Autowired
    private EnrollService enrollService;

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello.!";
    }

    @PostMapping("/enrollUsers")
    public String saveEnrollUsers(@Valid @RequestBody EnrollUsers enrollUsers) {
        enrollService.saveEnrollUsers(enrollUsers);
        return "Successfully saved in the DB";
    }

    @PutMapping("/enrollUsers")
    public String updateEnrollUsers(@RequestBody EnrollUsers enrollUsers) {
        return enrollService.updateEnrollUsers(enrollUsers);

    }

    @PostMapping("/removeEnrollUsers")
    public String removeEnrollUsers(@RequestBody EnrollUsers enrollUsers) {
        return enrollService.removeEnrollUsers(enrollUsers);

    }

    

}
