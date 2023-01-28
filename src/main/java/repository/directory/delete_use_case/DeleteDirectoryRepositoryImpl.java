package repository.directory.delete_use_case;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.directory.Directory;
import model.directory.Item;
import org.springframework.stereotype.Repository;
import service.directory.delete_use_case.DeleteDirectoryRepository;

import java.util.Objects;

@Repository
public class DeleteDirectoryRepositoryImpl implements DeleteDirectoryRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    @Transactional
    public Directory deleteUserDirectory(String username, Long id) {
        Directory directory = manager.find(Directory.class, id);

        if (!Objects.equals(directory.getUser().getUsername(), username)) {
            throw new IllegalArgumentException();
        }

        manager.remove(directory);

        return directory;
    }

    @Override
    @Transactional
    public Item deleteUserItem(String username, Long id) {
        Item item = manager.find(Item.class, id);

        if (!Objects.equals(item.getUser().getUsername(), username)) {
            throw new IllegalArgumentException();
        }

        manager.remove(item);

        return item;
    }
}
