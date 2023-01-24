package service.directory.get_use_case;

import model.directory.Directory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetDirectoryRepository extends PagingAndSortingRepository<Directory, Long> {
    Page<Directory> getAllByUpperId(Long upperId, Pageable pageable);
}
