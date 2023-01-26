package repository.directory.add_use_case;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.directory.Directory;
import org.springframework.stereotype.Repository;
import service.directory.add_use_case.AddDirectoryRepository;

@Repository
public class AddDirectoryRepositoryImpl implements AddDirectoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Directory save(Directory directory) {
        entityManager.persist(directory);
        return directory;
    }
}
