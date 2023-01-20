package controller.directory.get_use_case;

import dto.directory.EntityDto;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;

public interface GetDirectoryService {
    @PreAuthorize("#username == authentication.name")
    Page<EntityDto> getUserRootDirectoryContent(String username);

    @PreAuthorize("#username == authentication.name")
    Page<EntityDto> getUserDirectoryByIdContent(String username, Long id);
}