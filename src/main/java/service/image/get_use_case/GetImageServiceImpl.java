package service.image.get_use_case;

import controller.image.get_use_case.GetImageService;
import lombok.RequiredArgsConstructor;
import model.image.ImageData;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetImageServiceImpl implements GetImageService {
    private final GetImageRepository repository;

    @Override
    public byte[] getItemImageByUsername(String username, Long id) {
        ImageData imageData = repository.getImageByUsernameAndId(username, id);
        return imageData.getItemPicture();
    }
}
