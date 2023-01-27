package service.statistics.add_use_case;

import model.statistics.StatisticsUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddStatisticsRepository extends JpaRepository<StatisticsUnit, Long> {
}
