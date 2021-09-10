package com.thirdhomework.thirdhomework.mapper;


import com.thirdhomework.thirdhomework.dto.CourseDTO;
import com.thirdhomework.thirdhomework.dto.InstructorDTO;
import com.thirdhomework.thirdhomework.dto.StudentDTO;
import com.thirdhomework.thirdhomework.entity.Course;
import com.thirdhomework.thirdhomework.entity.PermanentInstructor;
import com.thirdhomework.thirdhomework.entity.Student;
import com.thirdhomework.thirdhomework.entity.VisitingResearcher;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface BaseMapper {

    @InheritConfiguration(name = "Instructor")
    PermanentInstructor mapToPermanent(InstructorDTO instructorDTO);

    @InheritConfiguration(name = "Instructor")
    VisitingResearcher mapToVisiting(InstructorDTO instructorDTO);

    Student mapperFromStudentDTOSt(StudentDTO studentDTO);

    Course mapperFromCourseDTOtoCr(CourseDTO courseDTO);




}
