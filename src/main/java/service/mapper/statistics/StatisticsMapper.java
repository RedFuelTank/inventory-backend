package service.mapper.statistics;

import dto.statistics.StatisticsUnitDto;
import model.statistics.StatisticsUnit;
import org.springframework.stereotype.Component;
import service.mapper.Mapper;

@Component
public class StatisticsMapper implements Mapper<StatisticsUnitDto, StatisticsUnit> {
    @Override
    public StatisticsUnitDto toDto(StatisticsUnit entity) {
        StatisticsUnitDto dto = new StatisticsUnitDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());

        if (entity.getItem() != null) {
            dto.setItemId(entity.getItem().getId());
        }

        return dto;
    }

    @Override
    public StatisticsUnit toEntity(StatisticsUnitDto dto) {
        StatisticsUnit entity = new StatisticsUnit();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());

        return entity;
    }
}
