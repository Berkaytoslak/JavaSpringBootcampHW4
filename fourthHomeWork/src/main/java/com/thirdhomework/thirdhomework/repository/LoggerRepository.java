package com.thirdhomework.thirdhomework.repository;

import com.thirdhomework.thirdhomework.entity.ExceptionLogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoggerRepository extends CrudRepository<ExceptionLogger,Long> {

    List<ExceptionLogger> findExceptionTransactionLoggerByMessage(String message);
    List<ExceptionLogger> findExceptionTransactionLoggerByLocalDateAfter(LocalDate localDate);

}
