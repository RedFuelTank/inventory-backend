package service.image.add_use_case;

import controller.image.add_use_case.AddImageService;
import dto.image.ImageDataDto;
import lombok.RequiredArgsConstructor;
import model.image.ImageData;
import org.springframework.stereotype.Service;
import service.directory.get_use_case.GetItemRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AddImageServiceImpl implements AddImageService {
    private final AddImageRepository addImageRepository;
    private final GetItemRepository itemRepository;
    @Override
    public void addItemPicture(ImageDataDto dto) throws IOException {
        ImageData data = new ImageData();

        data.setItemPicture(dto.getFile().getBytes());
        data.setItem(itemRepository.getById(dto.getItemId()).orElseThrow(IllegalArgumentException::new));

        addImageRepository.save(data);
    }
}
