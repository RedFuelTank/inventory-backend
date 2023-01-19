package service.user.get_use_case;

import model.user.User;

public interface GetUserRepository {
    User getUserByUsername(String username);
}
