package service.directory.add_use_case;

import controller.directory.add_use_case.AddDirectoryService;
import dto.directory.DirectoryDto;
import dto.directory.EntityDto;
import dto.directory.ItemDto;
import lombok.RequiredArgsConstructor;
import model.directory.Directory;
import model.directory.Item;
import org.springframework.stereotype.Service;
import service.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class AddDirectoryServiceImpl implements AddDirectoryService {
    private final AddDirectoryRepository directoryRepository;
    private final AddItemRepository itemRepository;
    private final Mapper<DirectoryDto, Directory> directoryMapper;
    private final Mapper<ItemDto, Item> itemMapper;

    @Override
    public EntityDto addUserItem(ItemDto itemDto) {
        return itemMapper.toDto(itemRepository.save(
                itemMapper.toEntity(itemDto)
        ));
    }

    @Override
    public EntityDto addUserDirectory(DirectoryDto directoryDto) {
        return directoryMapper.toDto(directoryRepository.save(
                directoryMapper.toEntity(directoryDto)
        ));
    }

}
