package service.directory.add_use_case;

import controller.directory.add_use_case.AddDirectoryService;
import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model.directory.Directory;
import model.directory.Item;
import model.statistics.StatisticsUnit;
import model.user.User;
import org.springframework.stereotype.Service;
import service.mapper.Mapper;
import service.statistics.add_use_case.AddStatisticsRepository;
import service.user.get_use_case.GetUserRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AddDirectoryServiceImpl implements AddDirectoryService {
    private final AddDirectoryRepository directoryRepository;
    private final AddStatisticsRepository statisticsRepository;
    private final GetUserRepository userRepository;
    private final AddItemRepository itemRepository;
    private final Mapper<DirectoryDto, Directory> directoryMapper;
    private final Mapper<ItemDto, Item> itemMapper;

    @Override
    @Transactional
    public EntityDto addUserItem(ItemDto itemDto) {
        Item savedItem = itemRepository.save(
                itemMapper.toEntity(itemDto));

        User user = userRepository.getUserByUsername(itemDto.getUsername());
        user.setExistingNumberItems(user.getExistingNumberItems() + 1);

        StatisticsUnit unit = new StatisticsUnit();

        unit.setId(savedItem.getId());
        unit.setUser(user);
        unit.setName(savedItem.getName());
        unit.setItem(savedItem);
        unit.setStartDate(new Date());

        statisticsRepository.save(unit);

        return itemMapper.toDto(savedItem);
    }

    @Override
    public EntityDto addUserDirectory(DirectoryDto directoryDto) {
        return directoryMapper.toDto(directoryRepository.save(
                directoryMapper.toEntity(directoryDto)
        ));
    }

}
