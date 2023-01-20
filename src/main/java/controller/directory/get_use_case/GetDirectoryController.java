package controller.directory.get_use_case;

import dto.directory.EntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetDirectoryController {
    private final GetDirectoryService service;

    @GetMapping("{username}/directory/root")
    public Page<EntityDto> getUserRootDirectoryContent(@PathVariable String username) {
        return service.getUserRootDirectoryContent(username);
    }

    @GetMapping("{username}/directory/{id}")
    public Page<EntityDto> getUserDirectoryByIdContent(@PathVariable String username, @PathVariable Long id) {
        return service.getUserDirectoryByIdContent(username, id);
    }
}
