package com.thirdhomework.thirdhomework.exception;

public class CourseIsAlreadyExistException extends RuntimeException {
    public CourseIsAlreadyExistException() {
        super("Course daha önce oluştu.");
    }
}
