package dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageDataDto {
    @NotNull
    @Size(min = 1)
    private String username;
    @Min(0)
    private long itemId;
    @NotNull
    private MultipartFile file;
}
