package controller.image.add_use_case;

import dto.image.ImageDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AddImageController {
    private final AddImageService service;

    @GetMapping("/images")
    @ResponseStatus(HttpStatus.OK)
    public void addItemPicture(@RequestBody ImageDataDto dto) {
        try {
            service.addItemPicture(dto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
