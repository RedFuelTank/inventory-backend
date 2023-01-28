package service.image.add_use_case;

import model.image.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddImageRepository extends JpaRepository<ImageData, Long> {
}
