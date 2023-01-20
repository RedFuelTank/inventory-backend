package dto.directory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public abstract class EntityDto {
    private final EntityType type;
    private final String name;

    public enum EntityType {
        DIRECTORY,
        FILE
    }
}
