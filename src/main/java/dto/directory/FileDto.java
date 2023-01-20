package dto.directory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDto extends EntityDto {
    private String date = "Today";
    public FileDto(String name) {
        super(EntityType.FILE, name);
    }
}
