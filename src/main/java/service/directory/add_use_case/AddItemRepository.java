package service.directory.add_use_case;

import model.directory.Item;

public interface AddItemRepository {
    Item save(Item toEntity);
}
