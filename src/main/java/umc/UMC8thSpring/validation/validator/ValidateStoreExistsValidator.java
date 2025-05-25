package umc.UMC8thSpring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.UMC8thSpring.repository.StoreRepository.StoreRepository;
import umc.UMC8thSpring.validation.annotation.ValidateStoreExists;

@Component
@RequiredArgsConstructor
public class ValidateStoreExistsValidator implements ConstraintValidator<ValidateStoreExists, Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(ValidateStoreExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid;

        if(storeRepository.existsById(value)) {
            isValid = true;
        }else{
            isValid = false;
        }
        return isValid;
    }
}
