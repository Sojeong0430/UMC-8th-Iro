package umc.UMC8thSpring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.UMC8thSpring.validation.validator.ValidateStoreExistsValidator;

import java.lang.annotation.*;

@Documented // 사용자 정의 어노테이션
@Constraint(validatedBy = ValidateStoreExistsValidator.class) // validation을 커스텀 어노테이션을 통해 할 수 있도록
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) // 어노테이션의 적용 범위
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 생명 주기 설정
public @interface ValidateStoreExists {

    String message() default "존재하지않는 가게입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
