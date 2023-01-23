package service.mapper.directory;

import dto.directory.ItemDto;
import jakarta.transaction.Transactional;
import model.directory.Item;
import org.springframework.stereotype.Component;
import service.mapper.Mapper;

@Component
public class ItemMapper implements Mapper<ItemDto, Item> {
    @Override
    public ItemDto toDto(Item item) {
        return new ItemDto(item.getName());
    }

    @Override
    public Item toEntity(ItemDto itemDto) {
        return null;
    }
}
