package com.thirdhomework.thirdhomework.service;


import com.thirdhomework.thirdhomework.dto.StudentDTO;
import com.thirdhomework.thirdhomework.entity.Student;
import com.thirdhomework.thirdhomework.exception.StudentAgeNotValidException;
import com.thirdhomework.thirdhomework.mapper.BaseMapper;
import com.thirdhomework.thirdhomework.repository.StudentRepository;
import com.thirdhomework.thirdhomework.util.Formatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final BaseMapper baseMapper;


    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    public Student findById(long id) {
        return studentRepository.findById(id).get();
    }

    public Student save(StudentDTO studentDTO) {

        Student student = baseMapper.mapperFromStudentDTOSt(studentDTO);
        LocalDate birthday = Formatter.convertStringToLocalDate(student.getBirthDate());
        long age = ChronoUnit.YEARS.between(birthday, LocalDate.now());

        if (age < 18 || age > 40) {
            throw new StudentAgeNotValidException();
        }
        return studentRepository.save(student);
    }

    public Student update(StudentDTO studentDTO) {
        return save(studentDTO);
    }

    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }

    public void deleteByObject(StudentDTO studentDTO) {
        long id = studentDTO.getId();
        deleteById(id);
    }

    public List<Student> findIncludeName(String name) {
        return studentRepository.findByNameContains(name);
    }

    public List<?> groupByGender() {
        return studentRepository.groupByGender();
    }

    public void deleteByName(String name) {
        studentRepository.deleteStudentByName(name);
    }
}

