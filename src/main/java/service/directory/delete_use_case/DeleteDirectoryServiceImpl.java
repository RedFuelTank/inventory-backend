package service.directory.delete_use_case;

import controller.directory.delete_use_case.DeleteDirectoryService;
import dto.directory.DirectoryDto;
import dto.directory.ItemDto;
import lombok.RequiredArgsConstructor;
import model.directory.Directory;
import model.directory.Item;
import org.springframework.stereotype.Service;
import service.mapper.Mapper;
import service.statistics.edit_use_case.EditStatisticsRepository;
import service.user.edit_use_case.EditUserRepository;

@Service
@RequiredArgsConstructor
public class DeleteDirectoryServiceImpl implements DeleteDirectoryService {
    private final DeleteDirectoryRepository directoryRepository;
    private final EditUserRepository userRepository;
    private final EditStatisticsRepository statisticsRepository;
    private final Mapper<DirectoryDto, Directory> directoryMapper;
    private final Mapper<ItemDto, Item> itemMapper;

    @Override
    public DirectoryDto deleteUserDirectory(String username, Long id) {
        return directoryMapper.toDto(directoryRepository.deleteUserDirectory(username, id));
    }

    @Override
    public ItemDto deleteUserItem(String username, Long id) {
        statisticsRepository.setOutdated(id);
        userRepository.decrementExistingItems(username);

        return itemMapper.toDto(directoryRepository.deleteUserItem(username, id));
    }
}
