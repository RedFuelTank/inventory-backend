package service.mapper;

public interface Mapper<DTO, Entity> {
    DTO toDto(Entity entity);
    Entity toEntity(DTO dto);
}
