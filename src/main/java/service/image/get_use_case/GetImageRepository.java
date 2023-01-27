package service.image.get_use_case;

import model.image.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetImageRepository extends JpaRepository<ImageData, Long> {
    @Query(value = "select o from ImageData o where o.item.user.username = :username and o.item.id = :id")
    ImageData getImageByUsernameAndId(@Param("username") String username,
                                      @Param("id") Long id);
}
