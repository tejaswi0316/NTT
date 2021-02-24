package com.poc.health.EnrollesDemo.service;

import com.poc.health.EnrollesDemo.model.EnrollUserDependents;
import com.poc.health.EnrollesDemo.model.EnrollUsers;
import com.poc.health.EnrollesDemo.repository.EnrollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnrollService {

    @Autowired
    private EnrollRepository enrollRepository;






    public void saveEnrollUsers(EnrollUsers enrollUsers ){

        enrollRepository.save(enrollUsers);
    }

    public String updateEnrollUsers(EnrollUsers enrollUsers) {

        Optional<EnrollUsers> dbUsers = enrollRepository.findById(enrollUsers.getId());
        if(dbUsers.isPresent()){
            EnrollUsers user= dbUsers.get();
            enrollUsers.setId(user.getId());
            if(enrollUsers.getActivationStatus()==null){
                enrollUsers.setActivationStatus(user.getActivationStatus());
            }
            if(enrollUsers.getName()==null){
                enrollUsers.setName(user.getName());
            }
            if(enrollUsers.getPhoneNumber()==null){
                enrollUsers.setPhoneNumber(user.getPhoneNumber());
            }
            if(enrollUsers.getUserDependents()==null){

                enrollUsers.setUserDependents(user.getUserDependents());
            }

            enrollRepository.save(enrollUsers);
            return "Successfully updated in the DB";
        }else{
            return "No Data Found in the DB";
        }

    }

    public String removeEnrollUsers(EnrollUsers enrollUsers) {
        Optional<EnrollUsers> dbUsers = enrollRepository.findById(enrollUsers.getId());
        if(dbUsers.isPresent()){
            enrollRepository.deleteById(enrollUsers.getId());
            return "Successfully updated in the DB";
        }else{
            return "No Data Found in the DB";
        }

    }

    public String addDependentsToEnrollUsers(EnrollUsers enrollUsers) {
        Optional<EnrollUsers> dbUsers = enrollRepository.findById(enrollUsers.getId());
         if(dbUsers.isPresent()){
             if(enrollUsers.getUserDependents()!=null){
                 List<EnrollUserDependents> userDependents=  enrollUsers.getUserDependents();
                 if(!dbUsers.get().getUserDependents().isEmpty()){
                     userDependents.addAll(dbUsers.get().getUserDependents());
                     enrollUsers.setUserDependents(userDependents);
                     enrollRepository.save(enrollUsers);
                 }
             }
            return "Add Dependents added in the DB";
        }else{
            return "No Data Found in the DB";
        }
    }

    public String removeDependentsToEnrollUsers(EnrollUsers enrollUsers) {
        Optional<EnrollUsers> dbUsers = enrollRepository.findById(enrollUsers.getId());
        if(dbUsers.isPresent()){
            if(enrollUsers.getUserDependents()!=null) {
                List<EnrollUserDependents> userReqDependents = enrollUsers.getUserDependents();
                if (!dbUsers.get().getUserDependents().isEmpty()) {
                    List<EnrollUserDependents> userDependents = dbUsers.get().getUserDependents();

                    if(userReqDependents!=null && !userReqDependents.isEmpty()){
                        Set<Long> userReqDependentsIds = userReqDependents.stream()
                                .map(p -> new Long(p.getId()))
                                .collect(Collectors.toSet());
                        userDependents.removeIf(e->userReqDependentsIds.contains(e.getId()));
                        enrollUsers.setUserDependents(userDependents);
                    }
                }
            }
            return "successfully removed dependents from the DB";
        }else{
            return "No Data Found in the DB";
        }
    }


}
