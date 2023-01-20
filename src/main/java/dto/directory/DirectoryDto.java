package dto.directory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectoryDto extends EntityDto {
    public DirectoryDto(String name) {
        super(EntityType.DIRECTORY, name);
    }
}
