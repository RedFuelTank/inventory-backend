package dto.directory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto extends EntityDto {
    public ItemDto(Long id, String name, String username, Long parentDirectoryId) {
        super(id, EntityType.FILE, name, username, parentDirectoryId);
    }
}
