package umc.demo.converter;

import umc.demo.domain.User;
import umc.demo.domain.mapping.Gender;
import umc.demo.web.dto.UserRequestDTO;
import umc.demo.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .NumberId(Long.valueOf(user.getNumber()))
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .gender(gender) //바로 위에서 파싱해서 받아오기때문에
                .birth(request.getBirth()) //바로 위에서 파싱해서 받아오기때문에
                .address(request.getAddress())
                .specAddress(request.getSpecAddress()) //리퀘스트에서 받아와야한다.
                .email(request.getEmail())
                .phone(request.getPhone())
                .likefoods(new ArrayList<>()) //
                .build();
    }

}

