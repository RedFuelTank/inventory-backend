package controller.directory.delete_use_case;

import dto.directory.EntityDto;
import org.springframework.security.access.prepost.PreAuthorize;

public interface DeleteDirectoryService {
    @PreAuthorize("#username == authentication.name")
    EntityDto deleteUserDirectory(String username, Long id);

    @PreAuthorize("#username == authentication.name")
    EntityDto deleteUserItem(String username, Long id);
}
