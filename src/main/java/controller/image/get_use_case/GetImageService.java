package controller.image.get_use_case;

import org.springframework.security.access.prepost.PreAuthorize;

public interface GetImageService {
    @PreAuthorize("#username == authentication.name")
    byte[] getItemImageByUsername(String username, Long id);
}
