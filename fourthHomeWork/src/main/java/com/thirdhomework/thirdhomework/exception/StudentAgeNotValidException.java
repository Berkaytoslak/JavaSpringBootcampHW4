package com.thirdhomework.thirdhomework.exception;

public class StudentAgeNotValidException extends RuntimeException {

    public StudentAgeNotValidException() {
        super("Student yaş aralığı 18 - 40 olmalıdır.");
    }
}
