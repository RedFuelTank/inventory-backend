package service.mapper.directory;

import dto.directory.DirectoryDto;
import jakarta.transaction.Transactional;
import model.directory.Directory;
import org.springframework.stereotype.Component;
import service.mapper.Mapper;

@Component
public class DirectoryMapper implements Mapper<DirectoryDto, Directory> {
    @Override
    public DirectoryDto toDto(Directory directory) {
        return new DirectoryDto(directory.getName(), directory.getUser().getUsername());
    }

    @Override
    public Directory toEntity(DirectoryDto directoryDto) {
        return null;
    }
}
