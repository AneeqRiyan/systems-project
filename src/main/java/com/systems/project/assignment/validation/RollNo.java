package com.systems.project.assignment.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RollNoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RollNo {
    String message() default "Invalid roll number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
