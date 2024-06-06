package umc.demo.service.TempService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.demo.apiPayload.code.status.ErrorStatus;
import umc.demo.apiPayload.exception.handler.LikeFoodHandler;
import umc.demo.converter.LikeFoodConverter;
import umc.demo.converter.UserConverter;
import umc.demo.domain.Food;
import umc.demo.domain.Likefood;
import umc.demo.domain.User;
import umc.demo.repository.LikeFoodRepository;
import umc.demo.repository.UserRepository;
import umc.demo.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

// @RequiredArgsConstructor 필수 인자 생성자 생성: final 또는 @NonNull이 붙은 필드를 매개변수로 갖는 생성자를 자동으로 생성해줍니다. 이를 통해 해당 필드들이 초기화되지 않은 상태로 객체가 생성되는 것을 방지합니다.
// 코드 간결화: 반복적인 생성자 코드를 작성하지 않아도 되므로, 코드가 간결해지고 가독성이 향상됩니다.
@Service // 이 클래스를 스프링 서비스로 등록합니다.
@RequiredArgsConstructor // Lombok을 사용하여 final 필드를 매개변수로 하는 생성자를 자동으로 생성합니다.
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository; // 유저 정보를 저장하고 조회하기 위한 JPA 리포지토리
    private final LikeFoodRepository likeFoodRepository; // 좋아하는 음식 정보를 저장하고 조회하기 위한 JPA 리포지토리

    @Override
    @Transactional // 메서드 내에서 수행되는 작업들을 하나의 트랜잭션으로 묶어줍니다.
    public User joinUser(UserRequestDTO.JoinDto request) {
        User newUser = UserConverter.toUser(request); // 요청 DTO를 User 엔티티로 변환합니다. //우리가 겟할 User(dto) 만듬

        // 좋아하는 음식 목록이 null이 아닌지 확인합니다.
        if (request.getLikefood() != null) {
            // 각 좋아하는 음식 ID를 통해 Food 엔티티를 조회하고, 존재하지 않으면 예외를 발생시킵니다.
            List<Food> foodList = request.getLikefood().stream()
                    .map(category -> likeFoodRepository.findById(category)
                            .orElseThrow(() -> new LikeFoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                    .collect(Collectors.toList()); // 조회된 Food 엔티티를 리스트로 수집합니다.

            // 조회된 Food 엔티티를 Likefood 엔티티로 변환합니다.
            List<Likefood> likeFoodList = LikeFoodConverter.toLikefoodList(foodList);

            // 각 Likefood 엔티티에 새로운 유저를 설정합니다.
            likeFoodList.forEach(likefood -> likefood.setUser(newUser));
        }

        return userRepository.save(newUser); // 새로운 유저를 데이터베이스에 저장하고 반환합니다.
    }

    @Override
    public boolean checkCategoriesExist(List<Long> categoryIds) {
        // 주어진 좋아하는 음식 ID 리스트의 모든 ID가 데이터베이스에 존재하는지 확인합니다.
        return categoryIds.stream() // categoryIds 리스트를 스트림으로 변환합니다.
                .allMatch(likeFoodRepository::existsById); // 각 ID가 데이터베이스에 존재하는지 확인합니다.
        // likeFoodRepository::existsById는 각 ID에 대해 likeFoodRepository.existsById(ID)를 호출하는 것과 같습니다.
        // 스트림의 모든 요소가 존재하면 true, 그렇지 않으면 false를 반환합니다.
    }
}
