package service.mapper.directory;

import dto.directory.ItemDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import model.directory.Item;
import model.user.User;
import org.springframework.stereotype.Component;
import service.mapper.Mapper;
import service.user.get_use_case.GetUserRepository;

@Component
@RequiredArgsConstructor
public class ItemMapper implements Mapper<ItemDto, Item> {
    private final GetUserRepository userRepository;
    @Override
    public ItemDto toDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getUser().getUsername(),
                item.getDirectoryId());
    }

    @Override
    public Item toEntity(ItemDto itemDto) {
        Item item = new Item();
        User user = userRepository.getUserByUsername(itemDto.getUsername());
        item.setName(itemDto.getName());
        item.setDirectoryId(item.getDirectoryId());
        item.setUser(user);
        return item;
    }
}
