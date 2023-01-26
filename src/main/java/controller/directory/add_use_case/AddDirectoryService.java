package controller.directory.add_use_case;

import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import org.springframework.security.access.prepost.PreAuthorize;

public interface AddDirectoryService {
    @PreAuthorize("#itemDto.username == authentication.name")
    EntityDto addUserItem(ItemDto itemDto);

    @PreAuthorize("#directoryDto.username == authentication.name")
    EntityDto addUserDirectory(DirectoryDto directoryDto);
}
