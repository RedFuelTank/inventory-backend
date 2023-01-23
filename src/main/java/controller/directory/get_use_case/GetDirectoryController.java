package controller.directory.get_use_case;

import dto.directory.EntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetDirectoryController {
    private final GetDirectoryService service;

    @GetMapping("{username}/directory/root")
    public Page<EntityDto> getUserRootDirectoryContent(@PathVariable String username, Pageable pageable) {
        return service.getUserRootDirectoryContent(username, pageable);
    }

    @GetMapping("{username}/directory/{id}")
    public Page<EntityDto> getUserDirectoryByIdContent(@PathVariable String username, @PathVariable Long id, Pageable pageable) {
        return service.getUserDirectoryByIdContent(username, id, pageable);
    }
}
