package umc.demo.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.demo.apiPayload.code.status.ErrorStatus;
import umc.demo.repository.LikeFoodRepository;
import umc.demo.service.TempService.UserCommandService;
import umc.demo.service.TempService.UserCommandServiceImpl;
import umc.demo.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final UserCommandService userCommandService;
    /**
     * 초기화 메서드. ConstraintValidator 인터페이스에서 제공하며,
     * 검증 초기화 논리를 구현할 수 있습니다.
     *
     * @param constraintAnnotation 존재하는 카테고리 유효성 검사 어노테이션
     */
    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    /**
     * 주어진 값 목록이 유효한지 검증하는 메서드.
     * UserCommandService를 통해 각 값이 존재하는지 확인합니다.
     *
     * @param values 검증할 값 목록 (카테고리 ID 리스트)
     * @param context ConstraintValidatorContext, 검증 컨텍스트
     * @return 유효한 경우 true, 그렇지 않으면 false
     */
    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {

        // 서비스 계층을 통해 값 목록이 유효한지 확인
        // 유효하지 않은 경우, 기본 제약 조건 위반 메시지를 비활성화하고
        // 사용자 정의 메시지를 추가

        boolean isValid = userCommandService.checkCategoriesExist(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
