package controller.directory.add_use_case;

import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/create")
public class AddDirectoryController {
    private final AddDirectoryService service;

    @PostMapping("/directory")
    public EntityDto addUserRootDirectorySubDirectory(@RequestBody DirectoryDto directoryDto) {
        return service.addUserDirectory(directoryDto);
    }

    @PostMapping("/item")
    public EntityDto addUserRootDirectorySubItem(@RequestBody ItemDto itemDto) {
        return service.addUserItem(itemDto);
    }
}
