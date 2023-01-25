package controller.directory.add_use_case;

import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public class AddDirectoryController {
    private final AddDirectoryService service;

    @PostMapping("{username}/directory/create-directory")
    public EntityDto addUserRootDirectorySubDirectory(@PathVariable String username, @RequestBody DirectoryDto directoryDto) {
        return service.addUserRootDirectory(username, directoryDto);
    }

    @PostMapping("{username}/directory/{id}/create-directory")
    public EntityDto addUserParentDirectoryByIdSubDirectory(@PathVariable String username, @PathVariable Long id, @RequestBody DirectoryDto directoryDto) {
        return service.addUserDirectoryByIdSubDirectory(username, id, directoryDto);
    }

    @PostMapping("{username}/directory/create-item")
    public EntityDto addUserRootDirectorySubItem(@PathVariable String username, @RequestBody ItemDto itemDto) {
        return service.addUserItem(username, itemDto);
    }

    @PostMapping("{username}/directory/{id}/create-item")
    public EntityDto addUserParentDirectoryByIdItem(@PathVariable String username, @PathVariable Long id, @RequestBody ItemDto itemDto) {
        return service.addUserDirectoryByIdItem(username, id, itemDto);
    }
}
