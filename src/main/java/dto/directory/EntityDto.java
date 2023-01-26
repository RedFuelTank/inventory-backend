package dto.directory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntityDto {
    private Long id;
    private EntityType type;
    private String name;
    private String username;
    private Long parentDirectoryId;

    public enum EntityType {
        DIRECTORY,
        FILE
    }
}
