package controller.user.add_use_case;

import dto.user.RegistrationDto;
import dto.user.UserDto;

public interface AddUserService {
    UserDto register(RegistrationDto registrationDto);
}
