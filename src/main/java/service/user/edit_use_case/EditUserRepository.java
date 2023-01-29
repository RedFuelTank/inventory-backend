package service.user.edit_use_case;

import org.springframework.data.repository.query.Param;

public interface EditUserRepository {

    void setAvailableItemNumber(@Param("username") String username,
                                @Param("amount") int amount);

    void decrementExistingItems(@Param("username") String username);
}
