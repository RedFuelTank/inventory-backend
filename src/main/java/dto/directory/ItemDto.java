package dto.directory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto extends EntityDto {
    private String date = "Today";
    public ItemDto(String name) {
        super(EntityType.FILE, name);
    }
}
