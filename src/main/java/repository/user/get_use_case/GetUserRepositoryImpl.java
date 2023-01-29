package repository.user.get_use_case;

import exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.user.User;
import org.springframework.stereotype.Repository;
import service.user.get_use_case.GetUserRepository;

@Repository
public class GetUserRepositoryImpl implements GetUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByUsername(String username) {
        User user = entityManager.find(User.class, username);

        if (user == null) {
            throw new NotFoundException(
                    String.format("User with username (%s) doesn't exist", username)
            );
        }

        return user;
    }
}
