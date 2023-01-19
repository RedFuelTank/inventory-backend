package repository.user;

import model.user.User;
import org.springframework.stereotype.Repository;
import service.user.get_use_case.GetUserRepository;

@Repository
public class GetUserRepositoryImpl implements GetUserRepository {
    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
