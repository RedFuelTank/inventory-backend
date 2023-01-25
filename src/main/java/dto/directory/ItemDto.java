package dto.directory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto extends EntityDto {
    public ItemDto(String name, String username) {
        super(EntityType.FILE, name, username);
    }
}
