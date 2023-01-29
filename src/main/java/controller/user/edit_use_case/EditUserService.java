package controller.user.edit_use_case;

import org.springframework.security.access.annotation.Secured;

public interface EditUserService {
    @Secured("ROLE_ADMIN")
    void setAvailableItemNumber(String username, int amount);

}
