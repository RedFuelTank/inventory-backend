package controller.user.get_use_case;

import dto.user.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;

public interface GetUserService {
    @PreAuthorize("#username == authentication.name")
    UserDto getUserByUsername(String username);
}
