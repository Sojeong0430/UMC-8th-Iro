package umc.UMC8thSpring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.UMC8thSpring.validation.annotation.ValidatePage;

@Component
@RequiredArgsConstructor
public class PageValidator implements ConstraintValidator<ValidatePage, Long>{

    @Override
    public boolean isValid(Long pageNum, ConstraintValidatorContext context) {
        if (pageNum == null) return false;
        return pageNum >= 1;
    }

}

