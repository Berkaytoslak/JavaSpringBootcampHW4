package com.thirdhomework.thirdhomework.service;


import com.thirdhomework.thirdhomework.dto.CourseDTO;
import com.thirdhomework.thirdhomework.dto.StudentDTO;
import com.thirdhomework.thirdhomework.entity.Course;
import com.thirdhomework.thirdhomework.entity.Student;
import com.thirdhomework.thirdhomework.exception.CourseIsAlreadyExistException;
import com.thirdhomework.thirdhomework.exception.StudentNumberForOneCourseExceededException;
import com.thirdhomework.thirdhomework.mapper.BaseMapper;
import com.thirdhomework.thirdhomework.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final BaseMapper baseMapper;

    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().forEach(courseList::add);
        return courseList;
    }

    public Course findById(long id) {
        return courseRepository.findById(id).get();
    }

    public Course save(CourseDTO courseDTO) {

        Course course = baseMapper.mapperFromCourseDTOtoCr(courseDTO);

        if (courseRepository.existsByCourseCode(course.getCourseCode())){
            throw new CourseIsAlreadyExistException();
        }
        return courseRepository.save(course);
    }

    public Course update(CourseDTO courseDTO) {
        Course course = baseMapper.mapperFromCourseDTOtoCr(courseDTO);
        return courseRepository.save(course);
    }

    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }

    public void deleteByObject(CourseDTO courseDTO) {
        long id = courseDTO.getId();
        deleteById(id);
    }

    public List<Course> findIncludeName(String name) {
        return courseRepository.findByCourseNameContains(name);
    }

    public void deleteByName(String name) {
        courseRepository.deleteCourseByCourseName(name);
    }

    public Course addStudentToCourse(StudentDTO studentDTO, long courseId){
        Course course = courseRepository.findById(courseId).get();

        List<Student> studentList = course.getStudentList();

        if(studentList.size()==20){
            throw new StudentNumberForOneCourseExceededException();
        }
        Student student = baseMapper.mapperFromStudentDTOSt(studentDTO);
        studentList.add(student);

        return courseRepository.save(course);



    }
}
