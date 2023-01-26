package service.mapper.directory;

import dto.directory.DirectoryDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model.directory.Directory;
import model.directory.Item;
import model.user.User;
import org.springframework.stereotype.Component;
import service.mapper.Mapper;
import service.user.get_use_case.GetUserRepository;

@Component
@RequiredArgsConstructor
public class DirectoryMapper implements Mapper<DirectoryDto, Directory> {
    private final GetUserRepository userRepository;

    @Override
    public DirectoryDto toDto(Directory directory) {
        return new DirectoryDto(
                directory.getId(),
                directory.getName(),
                directory.getUser().getUsername(),
                directory.getUpperId());
    }

    @Override
    public Directory toEntity(DirectoryDto directoryDto) {
        Directory directory = new Directory();
        User user = userRepository.getUserByUsername(directoryDto.getUsername());
        directory.setName(directoryDto.getName());
        directory.setUpperId(directoryDto.getParentDirectoryId());
        directory.setUser(user);
        return directory;
    }
}
