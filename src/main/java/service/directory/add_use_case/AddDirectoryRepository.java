package service.directory.add_use_case;

import model.directory.Directory;

public interface AddDirectoryRepository {

    Directory save(Directory directory);
}
