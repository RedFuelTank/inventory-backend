package controller.image.get_use_case;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetImageController {
    private final GetImageService service;

    @GetMapping(value = "/{username}/item/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getItemImageByUsername(@PathVariable String username,
                                     @PathVariable Long id) {
        return service.getItemImageByUsername(username, id);
    }
}
