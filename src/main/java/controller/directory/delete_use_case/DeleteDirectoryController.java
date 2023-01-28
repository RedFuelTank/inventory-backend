package controller.directory.delete_use_case;

import dto.directory.EntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteDirectoryController {
    private final DeleteDirectoryService service;

    @DeleteMapping("{username}/directory/{id}")
    public EntityDto deleteUserDirectory(@PathVariable String username, @PathVariable Long id) {
        return service.deleteUserDirectory(username, id);
    }

    @DeleteMapping("{username}/item/{id}")
    public EntityDto deleteUserItem(@PathVariable String username, @PathVariable Long id) {
        return service.deleteUserItem(username, id);
    }
}
