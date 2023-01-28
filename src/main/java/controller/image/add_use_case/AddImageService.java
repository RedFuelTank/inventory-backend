package controller.image.add_use_case;

import dto.image.ImageDataDto;
import org.springframework.security.access.prepost.PreAuthorize;

import java.io.IOException;

public interface AddImageService {
    @PreAuthorize("#dto.username == authentication.name")
    void addItemPicture(ImageDataDto dto) throws IOException;
}
