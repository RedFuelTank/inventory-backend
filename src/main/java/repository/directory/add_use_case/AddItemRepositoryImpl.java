package repository.directory.add_use_case;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.directory.Item;
import org.springframework.stereotype.Repository;
import service.directory.add_use_case.AddItemRepository;
@Repository
public class AddItemRepositoryImpl implements AddItemRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    @Transactional
    public Item save(Item item) {
        manager.persist(item);
        return item;
    }
}
