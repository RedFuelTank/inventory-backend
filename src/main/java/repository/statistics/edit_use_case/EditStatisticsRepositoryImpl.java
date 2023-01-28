package repository.statistics.edit_use_case;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.statistics.StatisticsUnit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.statistics.edit_use_case.EditStatisticsRepository;

@Repository
public class EditStatisticsRepositoryImpl implements EditStatisticsRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    @Transactional
    public void setEndDate(Long itemId, Long time) {
        Query query = manager.createQuery("select o from StatisticsUnit o where o.item.id = :itemId");
        query.setParameter("itemId", itemId);
        int id = query.getFirstResult();

        StatisticsUnit unit = manager.find(StatisticsUnit.class, id);
        unit.setEndDate(time);
        manager.merge(unit);
    }
}
