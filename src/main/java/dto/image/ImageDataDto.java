package dto.image;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageDataDto {
    private String username;
    private Long itemId;
    private MultipartFile file;
}
