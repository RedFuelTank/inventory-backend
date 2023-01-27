package service.statistics.get_use_case;

import model.statistics.StatisticsUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GetStatisticsRepository extends JpaRepository<StatisticsUnit, Long> {

    @Query(value = "select o from StatisticsUnit o where o.startDate = :from and o.endDate = :to")
    Page<StatisticsUnit> getStatisticsFromTo(String username, Long from, Long to, Pageable pageable);

    @Query(value = "select o from StatisticsUnit o where o.startDate = :from and o.endDate = null")
    Page<StatisticsUnit> getActualItems(String username, Long from, Pageable pageable);
}
