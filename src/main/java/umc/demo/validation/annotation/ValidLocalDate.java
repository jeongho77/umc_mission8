package umc.demo.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.demo.validation.validator.LocalDateValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LocalDateValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLocalDate {
    String message() default "Invalid local date format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
