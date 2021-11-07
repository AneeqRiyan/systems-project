package com.systems.project.assignment.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RollNoValidator implements ConstraintValidator<RollNo, String> {



    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Pattern pattern = Pattern.compile("^([0-9]{2})([kK]-)([0-9]{4})");
        Matcher matcher = pattern.matcher(value);
        try {
            if (!matcher.matches()) {
                return false;
                } else
                return true;
            }
        catch (Exception e) {
            return false;
        }
    }
}
