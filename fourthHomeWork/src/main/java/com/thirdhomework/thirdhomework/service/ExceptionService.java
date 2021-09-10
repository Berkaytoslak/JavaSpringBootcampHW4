package com.thirdhomework.thirdhomework.service;


import com.thirdhomework.thirdhomework.entity.ExceptionLogger;
import com.thirdhomework.thirdhomework.repository.LoggerRepository;
import com.thirdhomework.thirdhomework.util.Formatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExceptionService {

    private final LoggerRepository loggerRepository;


    public List<ExceptionLogger> getAll() {
        return (List<ExceptionLogger>) loggerRepository.findAll();
    }

    public List<ExceptionLogger> getCourseAlreadyExistExceptions(){
        return loggerRepository.findExceptionTransactionLoggerByMessage("Course daha önce oluşturuldu.");
    }

    public List<ExceptionLogger> getInstructorAlreadyExistExceptions(){
        return loggerRepository.findExceptionTransactionLoggerByMessage("Instructor daha önce oluşturuldu");
    }
    public List<ExceptionLogger> getStudentAgeNotValidExceptions(){
        return loggerRepository.findExceptionTransactionLoggerByMessage("Student yaş aralığı 18 - 40 olmalıdır.");
    }
    public List<ExceptionLogger> getStudentNumberForOneCourseExceededException(){
        return loggerRepository.findExceptionTransactionLoggerByMessage("Maximum 20 öğrenci olabilir.");
    }

    public List<ExceptionLogger> getExceptionsByDate(String date){
        LocalDate localDate = Formatter.convertStringToLocalDate(date);
        return loggerRepository.findExceptionTransactionLoggerByLocalDateAfter(localDate);
    }

}
