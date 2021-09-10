package com.thirdhomework.thirdhomework.exception;

public class StudentNumberForOneCourseExceededException extends RuntimeException {
    public StudentNumberForOneCourseExceededException() {
        super("Maximum 20 öğtrnci olacaktır.");
    }
}
