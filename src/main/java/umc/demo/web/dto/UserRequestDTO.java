package umc.demo.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.demo.validation.annotation.ExistCategories;
import umc.demo.validation.annotation.ValidLocalDate;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @Size(min = 0, max = 20)
        String nickname;
        @NotNull
        Integer gender;

        @NotNull
        @ValidLocalDate
        LocalDate birth;

        @NotNull
        String address;
        @NotNull
        String specAddress;
        @NotNull
        String email;
        @NotNull
        String phone;
        @ExistCategories
        List<Long> likefood;
    }
}
