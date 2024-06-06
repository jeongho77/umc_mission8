package umc.demo.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.demo.validation.annotation.ValidLocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LocalDateValidator implements ConstraintValidator<ValidLocalDate, LocalDate> {


    @Override
    public void initialize(ValidLocalDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true; // null values are valid, use @NotNull to check for nulls
        }

        try {
            LocalDate.parse(value.toString());
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
