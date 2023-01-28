package service.statistics.get_use_case;

import model.statistics.StatisticsUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetStatisticsRepository extends JpaRepository<StatisticsUnit, Long> {

    @Query(value = "select o from StatisticsUnit o where o.user.username = :username and o.startDate >= :from and o.endDate <= :to")
    Page<StatisticsUnit> getStatisticsFromTo(@Param("username") String username,
                                             @Param("from") Long from,
                                             @Param("to") Long to,
                                             Pageable pageable);

    @Query(value = "select o from StatisticsUnit o where o.user.username = :username and o.startDate >= :from")
    Page<StatisticsUnit> getStatisticsFrom(@Param("username") String username,
                                             @Param("from") Long from,
                                             Pageable pageable);
}
