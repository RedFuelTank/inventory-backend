package dto.statistics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsUnitDto {
    private Long id;
    private String name;
    private Long itemId;
    private Long startDate;
    private Long endDate;
}
