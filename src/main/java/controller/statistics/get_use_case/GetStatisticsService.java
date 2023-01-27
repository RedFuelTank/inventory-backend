package controller.statistics.get_use_case;

import dto.statistics.StatisticsUnitDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

public interface GetStatisticsService {
    @PreAuthorize("#username == authentication.name")
    Page<StatisticsUnitDto> getStatisticsFromTo(String username, Long from, Optional<Long> to, Pageable pageable);
}
