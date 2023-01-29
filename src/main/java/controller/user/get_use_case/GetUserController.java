package controller.user.get_use_case;

import dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserController {
    private final GetUserService service;

    @GetMapping("{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return service.getUserByUsername(username);
    }

    @GetMapping("{username}/credit")
    public double getCreditByUsername(@PathVariable String username) {
        return service.getCreditByUsername(username);
    }
}
