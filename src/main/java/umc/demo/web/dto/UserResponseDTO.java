package umc.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
//      요청이오면 그에맞는 데이터를 대답해주면 되는곳!
        Long NumberId;
        LocalDateTime createdAt;
    }
}
