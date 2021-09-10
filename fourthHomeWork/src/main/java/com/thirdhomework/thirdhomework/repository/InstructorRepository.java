package com.thirdhomework.thirdhomework.repository;

import com.thirdhomework.thirdhomework.entity.Instructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {

    List<Instructor> findByNameContains(String name);

    boolean existsByPhoneNumber(String phone);

    @Transactional
    @Modifying
    @Query(value = "delete from Instructor i where i.name=:name")
    void deleteInstructorByName(String name);




}
