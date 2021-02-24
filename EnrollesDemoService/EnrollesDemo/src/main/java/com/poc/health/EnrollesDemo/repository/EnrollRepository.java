package com.poc.health.EnrollesDemo.repository;

import com.poc.health.EnrollesDemo.model.EnrollUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollRepository extends CrudRepository<EnrollUsers,Long> {



    /*@Modifying
    @Query("insert into Person (id,name,age) select :id,:name,:age from Dual")
    public int modifyingQueryInsertPerson(@Param("id")Long id, @Param("name")String name, @Param("age")Integer age);*/
}
