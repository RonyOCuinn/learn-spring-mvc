package com.ronyo.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    public void initialize(CourseCode constraint) {
        coursePrefix = constraint.value();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {

        boolean x = obj.startsWith(coursePrefix);
        return x;
    }
}
