package umc.demo.service.TempService;

import umc.demo.domain.User;
import umc.demo.web.dto.UserRequestDTO;

import java.util.List;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);

    boolean checkCategoriesExist(List<Long> categoryIds);
}
