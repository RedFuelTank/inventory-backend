package service.directory.delete_use_case;

import model.directory.Directory;
import model.directory.Item;

public interface DeleteDirectoryRepository {

    Directory deleteUserDirectory(String username, Long id);

    Item deleteUserItem(String username, Long id);
}
