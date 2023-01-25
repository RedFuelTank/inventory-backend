package controller.directory.get_use_case;

import dto.directory.EntityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

public interface GetDirectoryService {
    @PreAuthorize("#username == authentication.name")
    Page<EntityDto> getUserDirectoryByIdContent(String username, Optional<Long> id, Pageable pageable);
}
