package service.user.add_use_case;

import dto.user.RegistrationDto;
import model.user.User;

public interface AddUserRepository {
    User register(RegistrationDto registrationDto);
}
