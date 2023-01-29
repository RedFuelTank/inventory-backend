package service.directory.get_use_case;

import model.directory.Item;
import model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface GetItemRepository extends PagingAndSortingRepository<Item, Long> {
    Page<Item> getAllByDirectoryIdAndUser(Long id, User user, Pageable pageable);

    Page<Item> findAllByNameLikeAndUser(String name, User username, Pageable pageable);

    Optional<Item> getById(Long itemId);
}
