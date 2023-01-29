package service.statistics.get_use_case;

import controller.statistics.get_use_case.GetStatisticsService;
import dto.statistics.StatisticsUnitDto;
import lombok.RequiredArgsConstructor;
import model.statistics.StatisticsUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import service.mapper.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetStatisticsServiceImpl implements GetStatisticsService {
    private final GetStatisticsRepository repository;
    private final Mapper<StatisticsUnitDto, StatisticsUnit> statisticsMapper;

    @Override
    public Page<StatisticsUnitDto> getStatisticsFromTo(String username, Date from, Optional<Date> toOptional, Pageable pageable) {
        List<StatisticsUnit> units = toOptional.map(to -> repository.getStatisticsFromTo(username, from, to, pageable).getContent())
                .orElseGet(() -> repository.getStatisticsFrom(username, from, pageable).getContent());
        List<StatisticsUnitDto> unitDtos = units.stream().map(statisticsMapper::toDto).toList();
        return new PageImpl<>(unitDtos);
    }
}
