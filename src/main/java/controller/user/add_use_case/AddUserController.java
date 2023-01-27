package controller.user.add_use_case;

import dto.user.RegistrationDto;
import dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddUserController {
    private final AddUserService service;

    @PostMapping("user/registration")
    public UserDto register(@RequestBody RegistrationDto registrationDto) {
        return service.register(registrationDto);
    }
}
