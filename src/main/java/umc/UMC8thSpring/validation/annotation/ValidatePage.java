package umc.UMC8thSpring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.UMC8thSpring.validation.validator.PageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatePage {
    String message() default "PageNum은 0보다 작으면 안됩니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}