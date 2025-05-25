package umc.UMC8thSpring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.UMC8thSpring.repository.MemberMissionRepository;
import umc.UMC8thSpring.validation.annotation.CheckMissionNotInProgress;

@Component
@RequiredArgsConstructor
public class CheckMissionNotInProgressValidator implements ConstraintValidator<CheckMissionNotInProgress, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(CheckMissionNotInProgress constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        boolean isValid;
        if(memberMissionRepository.existsById(value)) {
            isValid = true;
        }else{
            isValid = false;
        }
        return isValid;
    }
}
