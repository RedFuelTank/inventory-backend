package dto.directory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DirectoryDto extends EntityDto {
    public DirectoryDto(Long id, String name, String username, Long parentDirectoryId) {
        super(id,EntityType.DIRECTORY, name, username, parentDirectoryId);
    }
}
