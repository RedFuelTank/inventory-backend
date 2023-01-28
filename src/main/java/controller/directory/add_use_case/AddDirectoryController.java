package controller.directory.add_use_case;

import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddDirectoryController {
    private final AddDirectoryService service;

    @PostMapping("/directories")
    public EntityDto addUserRootDirectorySubDirectory(@RequestBody @Valid DirectoryDto directoryDto) {
        return service.addUserDirectory(directoryDto);
    }

    @PostMapping("/items")
    public EntityDto addUserRootDirectorySubItem(@RequestBody @Valid ItemDto itemDto) {
        return service.addUserItem(itemDto);
    }
}
