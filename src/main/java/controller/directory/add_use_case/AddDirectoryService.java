package controller.directory.add_use_case;

import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import org.springframework.security.access.prepost.PreAuthorize;

public interface AddDirectoryService {
    @PreAuthorize("#username == authentication.name")
    EntityDto addUserRootDirectory(String username, DirectoryDto directoryDto);

    @PreAuthorize("#username == authentication.name")
    EntityDto addUserDirectoryById(String username, Long id, DirectoryDto directoryDto);

    @PreAuthorize("#username == authentication.name")
    EntityDto addUserParentDirectoryByIdItem(String username, Long id, ItemDto itemDto);
}
