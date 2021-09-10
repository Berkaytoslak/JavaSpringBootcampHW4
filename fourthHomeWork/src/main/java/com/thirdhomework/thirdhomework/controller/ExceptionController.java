package com.thirdhomework.thirdhomework.controller;


import com.thirdhomework.thirdhomework.entity.ExceptionLogger;
import com.thirdhomework.thirdhomework.service.ExceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/exceptions")
@RequiredArgsConstructor
public class ExceptionController {

    private final ExceptionService exceptionService;

    @GetMapping
    public ResponseEntity<List<ExceptionLogger>> getAllExceptionTransaction() {
        return new ResponseEntity<>(exceptionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/courseAlreadyExist")
    public ResponseEntity<List<ExceptionLogger>> getCourseAlreadyExistExceptionTransaction() {
        return new ResponseEntity<>(exceptionService.getCourseAlreadyExistExceptions(), HttpStatus.OK);
    }

    @GetMapping("/instructorAlreadyExist")
    public ResponseEntity<List<ExceptionLogger>> getInstructorAlreadyExistExceptionTransaction() {
        return new ResponseEntity<>(exceptionService.getInstructorAlreadyExistExceptions(), HttpStatus.OK);
    }

    @GetMapping("/studentAgeNotValid")
    public ResponseEntity<List<ExceptionLogger>> getStudentAgeNotValidExceptionTransaction() {
        return new ResponseEntity<>(exceptionService.getStudentAgeNotValidExceptions(), HttpStatus.OK);
    }

    @GetMapping("/studentNumberExceed")
    public ResponseEntity<List<ExceptionLogger>> getStudentNumberExceedExceptionTransaction() {
        return new ResponseEntity<>(exceptionService.getStudentNumberForOneCourseExceededException(), HttpStatus.OK);
    }

    @GetMapping("/getByDate")
    public ResponseEntity<List<ExceptionLogger>> getExceptionsByDate (@RequestParam String date){
        return new ResponseEntity<>(exceptionService.getExceptionsByDate(date), HttpStatus.OK);

    }


}
