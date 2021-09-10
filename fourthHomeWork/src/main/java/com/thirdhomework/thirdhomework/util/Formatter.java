package com.thirdhomework.thirdhomework.util;

import java.time.LocalDate;

public class Formatter {

    public static LocalDate convertStringToLocalDate(String date){
        return LocalDate.parse(date);
    }
}
