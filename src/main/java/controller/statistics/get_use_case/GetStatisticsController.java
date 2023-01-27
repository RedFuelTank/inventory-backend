package controller.statistics.get_use_case;

import dto.statistics.StatisticsUnitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GetStatisticsController {
    private final GetStatisticsService service;

    @GetMapping("/user/{username}/statistics")
    public Page<StatisticsUnitDto> getStatisticsFromTo(@PathVariable String username,
                                                       @RequestParam Long from,
                                                       @RequestParam(required = false) Optional<Long> to,
                                                       Pageable pageable) {
        return service.getStatisticsFromTo(username, from, to, pageable);
    }
}
