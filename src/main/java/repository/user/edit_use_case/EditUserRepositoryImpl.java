package repository.user.edit_use_case;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import service.user.edit_use_case.EditUserRepository;

@Repository
public class EditUserRepositoryImpl implements EditUserRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    @Transactional
    public void setAvailableItemNumber(String username, int amount) {
        Query query = manager.createQuery("update User set availableNumberItems = :amount where username = :username");
        query.setParameter("username", username);
        query.setParameter("amount", amount);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void decrementExistingItems(String username) {
        Query query = manager.createQuery("update User set existingNumberItems = existingNumberItems - 1 where username = :username");
        query.setParameter("username", username);
        query.executeUpdate();
    }
}
