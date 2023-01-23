package controller.directory.add_use_case;

import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AddDirectoryController {
    private final AddDirectoryService service;

    @PostMapping("{username}/directory/root")
    public EntityDto addUserRootDirectory(@PathVariable String username, @RequestBody DirectoryDto directoryDto) {
        return service.addUserRootDirectory(username, directoryDto);
    }

    @PostMapping("{username}/parent-directory/{id}/create-directory")
    public EntityDto addUserParentDirectoryByIdDirectory(@PathVariable String username, @PathVariable Long id, @RequestBody DirectoryDto directoryDto) {
        return service.addUserDirectoryById(username, id, directoryDto);
    }

    @PostMapping("{username}/parent-directory/{id}/create-item")
    public EntityDto addUserParentDirectoryByIdItem(@PathVariable String username, @PathVariable Long id, @RequestBody ItemDto itemDto) {
        return service.addUserParentDirectoryByIdItem(username, id, itemDto);
    }
}
